/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.model.BahanMakanan;
import static com.model.Constants.databaseUrl;
import com.model.Golongan;
import com.model.MakananDiKonsumsi;
import com.model.MakananDiKonsumsiReport;
import com.model.ProfilUser;
import com.sview.SimpanMakananDikonsumsiFrame;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.olap4j.impl.ArrayNamedListImpl;

/**
 *
 * @author fahmi
 */
public class MakanDikonsumsiController extends Observable {

    private JdbcConnectionSource jdbcConnectionSource;
    private Dao<BahanMakanan, Long> daoBahanMakanan;
    private Dao<Golongan, Long> daoGolongan;
    private List<BahanMakanan> listBahanMakanan;
    private List<Golongan> listGolongan;
    private ProfilUser profilUser;
    private ArrayList<MakananDiKonsumsi> listMakananDikonsumsi = new ArrayList<>();
    private BahanMakanan currentBahanMakanan = null;
    private MakananDiKonsumsi currentMakananDiKonsumsi = null;

    public MakanDikonsumsiController(ProfilUser profilUser) throws SQLException {
        jdbcConnectionSource = new JdbcConnectionSource(databaseUrl);
        daoBahanMakanan = DaoManager.createDao(jdbcConnectionSource, BahanMakanan.class);
        daoGolongan = DaoManager.createDao(jdbcConnectionSource, Golongan.class);
        TableUtils.createTableIfNotExists(jdbcConnectionSource, Golongan.class);
        TableUtils.createTableIfNotExists(jdbcConnectionSource, BahanMakanan.class);
        this.profilUser = profilUser;
        getListDataFromDb();
        inialDumyData();
    }

    public List<BahanMakanan> getListBahanMakanan() {
        return listBahanMakanan;
    }

    public void setListBahanMakanan(List<BahanMakanan> listBahanMakanan) {
        this.listBahanMakanan = listBahanMakanan;
    }

    private void inialDumyData() {
        MakananDiKonsumsi makananDiKonsumsi = new MakananDiKonsumsi();
        makananDiKonsumsi.setBahanMakanan(listBahanMakanan.get(0));
        makananDiKonsumsi.setJumlah(10.0);
        makananDiKonsumsi.setWaktuMakan("Siang");
        makananDiKonsumsi.hitungTotalKandunganGizi();
        listMakananDikonsumsi.add(makananDiKonsumsi);
    }

    public void getListDataFromDb() throws SQLException {
        this.listBahanMakanan = daoBahanMakanan.queryForAll();
        this.listGolongan = daoGolongan.queryForAll();
    }

    public ArrayList<MakananDiKonsumsi> getListMakananDikonsumsi() {
        return listMakananDikonsumsi;
    }

    public void setListMakananDikonsumsi(ArrayList<MakananDiKonsumsi> listMakananDikonsumsi) {
        this.listMakananDikonsumsi = listMakananDikonsumsi;
    }

    public Object[] getListStringGolongan() {
        ArrayList<String> listString = new ArrayList<>();
        for (Golongan gol : listGolongan) {
            listString.add(gol.getNamaGolongan());
        }
        return listString.toArray();
    }

    public BahanMakanan getCurrentBahanMakanan() {
        return currentBahanMakanan;
    }

    public void setCurrentBahanMakanan(BahanMakanan currentBahanMakanan) {
        this.currentBahanMakanan = currentBahanMakanan;
    }

    public void setCurrentBahanMakananByid(Long id) {
        BahanMakanan bahanMakanan = new BahanMakanan();
        bahanMakanan.setIdBahanMakanan(id);
        this.setCurrentBahanMakanan(listBahanMakanan.get(listBahanMakanan.indexOf(bahanMakanan)));
    }

    public boolean saveData(String waktuMakan, Double jumlah) {
        if (currentBahanMakanan == null) {
            return false;
        }
        MakananDiKonsumsi makananDiKonsumsi = new MakananDiKonsumsi();
        makananDiKonsumsi.setBahanMakanan(currentBahanMakanan);
        makananDiKonsumsi.setJumlah(jumlah);
        makananDiKonsumsi.setWaktuMakan(waktuMakan);
        makananDiKonsumsi.hitungTotalKandunganGizi();
        listMakananDikonsumsi.add(makananDiKonsumsi);
        currentBahanMakanan = null;
        notifyAllObserver();
        return true;
    }

    public boolean updateData(String waktuMakan, Double jumlah, int index) {
        if (currentBahanMakanan == null) {
            return false;
        }
        MakananDiKonsumsi makananDiKonsumsi = new MakananDiKonsumsi();
        makananDiKonsumsi.setBahanMakanan(currentBahanMakanan);
        makananDiKonsumsi.setJumlah(jumlah);
        makananDiKonsumsi.setWaktuMakan(waktuMakan);
        makananDiKonsumsi.hitungTotalKandunganGizi();
        listMakananDikonsumsi.set(index, makananDiKonsumsi);
        notifyAllObserver();
        return true;
    }

    public void delete(int index) {
        listMakananDikonsumsi.remove(index);
        notifyAllObserver();
    }

    public void notifyAllObserver() {
        setChanged();
        notifyObservers();
    }

    public void setMakananDiKonsumsiToView(int index, SimpanMakananDikonsumsiFrame aThis) {
        MakananDiKonsumsi makananDiKonsumsi = listMakananDikonsumsi.get(index);
        currentBahanMakanan = makananDiKonsumsi.getBahanMakanan();
        aThis.textFieldNamaMakanan.setText(currentBahanMakanan.getNamaBahanMakanan());
        aThis.labelSatuanUrt.setText(currentBahanMakanan.getSatuanUrt());
        aThis.textFieldJumlah.setText(makananDiKonsumsi.getJumlah() + "");
    }

    public void showPriviewReport() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream streamRep;
                try {
                    streamRep = JRLoader.getFileInputStream("gizi_report.jasper");
                    JRBeanCollectionDataSource jRDataSource = new JRBeanCollectionDataSource(getListMakananDikonsumsiReport());
                    Map<String, Object> map = new HashMap<>();

                    map.put(JRParameter.REPORT_DATA_SOURCE, jRDataSource);
                    map.put("PROFILE_USER", profilUser.toString());
                    JasperPrint report = JasperFillManager.fillReport(streamRep, map, jRDataSource);
                    
                    JasperViewer jv = new JasperViewer(report, false);
                    
                    jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jv.setVisible(true);
                    
                } catch (JRException ex) {
                    Logger.getLogger(MakanDikonsumsiController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();

    }

    private ArrayList<MakananDiKonsumsiReport> getListMakananDikonsumsiReport() {
        ArrayList<MakananDiKonsumsiReport> listMakananDiKonsumsiReports = new ArrayList<>();
        for (MakananDiKonsumsi e : listMakananDikonsumsi) {
            listMakananDiKonsumsiReports.add(new MakananDiKonsumsiReport(e));
        }
        return listMakananDiKonsumsiReports;
    }
}
