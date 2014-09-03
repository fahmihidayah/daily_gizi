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
import com.sview.SimpanMakananDikonsumsiFrame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author fahmi
 */
public class MakanDikonsumsiController extends Observable{
    private JdbcConnectionSource jdbcConnectionSource;
    private Dao<BahanMakanan, Long> daoBahanMakanan;
    private Dao<Golongan, Long> daoGolongan;
    
    private List<BahanMakanan> listBahanMakanan;
    private List<Golongan> listGolongan;
    
    private ArrayList<MakananDiKonsumsi> listMakananDikonsumsi = new ArrayList<>();
    
    private BahanMakanan currentBahanMakanan = null;
    
    private MakananDiKonsumsi currentMakananDiKonsumsi = null;
    
    public MakanDikonsumsiController() throws SQLException {
        jdbcConnectionSource = new JdbcConnectionSource(databaseUrl);
        daoBahanMakanan = DaoManager.createDao(jdbcConnectionSource, BahanMakanan.class);
        daoGolongan = DaoManager.createDao(jdbcConnectionSource, Golongan.class);
        TableUtils.createTableIfNotExists(jdbcConnectionSource, Golongan.class);
        TableUtils.createTableIfNotExists(jdbcConnectionSource, BahanMakanan.class);
        getListDataFromDb();
        inialDumyData();
    }

    public List<BahanMakanan> getListBahanMakanan() {
        return listBahanMakanan;
    }

    public void setListBahanMakanan(List<BahanMakanan> listBahanMakanan) {
        this.listBahanMakanan = listBahanMakanan;
    }
    
    
    private void inialDumyData (){
        MakananDiKonsumsi makananDiKonsumsi = new MakananDiKonsumsi();
        makananDiKonsumsi.setBahanMakanan(listBahanMakanan.get(0));
        makananDiKonsumsi.setJumlah(10.0);
        makananDiKonsumsi.setWaktuMakan("Siang");
        makananDiKonsumsi.hitungTotalKandunganGizi();
        listMakananDikonsumsi.add(makananDiKonsumsi);
    }
    public void getListDataFromDb() throws SQLException{
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
    
    public void setCurrentBahanMakananByid(Long id){
        BahanMakanan bahanMakanan = new BahanMakanan();
        bahanMakanan.setIdBahanMakanan(id);
        this.setCurrentBahanMakanan(listBahanMakanan.get(listBahanMakanan.indexOf(bahanMakanan)));
    }
    
    public boolean saveData(String waktuMakan,Double jumlah){
        if(currentBahanMakanan == null){
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
    
    public boolean updateData(String waktuMakan, Double jumlah, int index){
        if(currentBahanMakanan == null){
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
    
    public void delete(int index){
        listMakananDikonsumsi.remove(index);
        notifyAllObserver();
    }
    
    public void notifyAllObserver() {
        setChanged();
        notifyObservers();
    }

    public void setMakananDiKonsumsiToView(int index, SimpanMakananDikonsumsiFrame aThis) {
        MakananDiKonsumsi makananDiKonsumsi= listMakananDikonsumsi.get(index);
        currentBahanMakanan = makananDiKonsumsi.getBahanMakanan();
        aThis.textFieldNamaMakanan.setText(currentBahanMakanan.getNamaBahanMakanan());
        aThis.labelSatuanUrt.setText(currentBahanMakanan.getSatuanUrt());
        aThis.textFieldJumlah.setText(makananDiKonsumsi.getJumlah()+"");
    }
}
