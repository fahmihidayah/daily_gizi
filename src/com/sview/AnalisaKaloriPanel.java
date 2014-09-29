/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.BahanMakananController;
import com.controller.MakanDikonsumsiController;
import com.controller.ProfileController;
import com.framework.CustomTableModel;
import com.model.Constants;
import static com.model.Constants.UPDATE_MODE;
import com.model.MakananDiKonsumsi;
import com.model.ProfilUser;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author fahmi
 */
public class AnalisaKaloriPanel extends JPanel implements Observer, Constants{
    JTable tableMakananDikonsumsi ;
    JLabel labelKeterangan; 
    CustomTableModel<MakananDiKonsumsi> customTableModelMakananDikonsumsi;
    
    private BahanMakananController bahanMakananController;
    private MakanDikonsumsiController makanDikonsumsiController;
    private ProfileController profileController;

    private int selectedIndex = -1;
    public AnalisaKaloriPanel(BahanMakananController bahanMakananController, MakanDikonsumsiController makanDikonsumsiController, ProfileController profilUser) {
        super(new BorderLayout());
        this.bahanMakananController = bahanMakananController;
        this.makanDikonsumsiController = makanDikonsumsiController;
        this.profileController = profilUser;
        
        add(getTableMakananDikonsumsiPanel(), BorderLayout.CENTER);
        add(getKeteranganAndPreviewPanel() , BorderLayout.SOUTH);
        makanDikonsumsiController.addObserver(this);
    }
    
    private JPanel getTableMakananDikonsumsiPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        String [] columnName = {"Nama Makanan", "Jumlah" , "Waktu Makan" , "Total Karbohidrat", "Total Protein", "Total Kalori", "Total Lemak"};
        customTableModelMakananDikonsumsi = new CustomTableModel<MakananDiKonsumsi>() {

            @Override
            public Object getDataItem(MakananDiKonsumsi data, int column) {
                if(column == 0){
                    return data.getBahanMakanan().getNamaBahanMakanan();
                }
                else if (column == 1){
                    return data.getJumlah()+ "";
                }
                else if (column == 2){
                    return data.getWaktuMakan() + "";
                }
                else if (column == 3){
                    return data.getKarbohidrat()+ "";
                }
                else if (column == 4){
                    return data.getProtein()+ "";
                }
                else if (column == 5){
                    return data.getKalori()+ "";
                }
                else if (column == 6){
                    return data.getLemak()+ "";
                }
                else {
                    return "";
                }
            }
        };
        customTableModelMakananDikonsumsi.setColumnName(columnName);
        customTableModelMakananDikonsumsi.setListData(makanDikonsumsiController.getListMakananDikonsumsi());
        tableMakananDikonsumsi = new JTable(customTableModelMakananDikonsumsi);
        tableMakananDikonsumsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                Point p = e.getPoint();
                selectedIndex = table.rowAtPoint(p);
                if (e.getClickCount() == 2) {
                    SimpanMakananDikonsumsiFrame simpanMakananDikonsumsiFrame = new SimpanMakananDikonsumsiFrame(makanDikonsumsiController, UPDATE_MODE, selectedIndex);
                }
            }
        });
        customTableModelMakananDikonsumsi.createRowSorter(tableMakananDikonsumsi);
        JScrollPane scrollPane = new JScrollPane(tableMakananDikonsumsi);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton buttonTambah = new JButton("Tambah");
        buttonTambah.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showConfirmDialog(null, "Tambah", "Pesan", JOptionPane.OK_OPTION);
                SimpanMakananDikonsumsiFrame simpanMakananDikonsumsiFrame = new SimpanMakananDikonsumsiFrame(makanDikonsumsiController, INSERT_MODE, -1);
            }
        });
        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    JOptionPane.showConfirmDialog(null, "Anda belum memilih data", "Pesan", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data ini?", "Pesan", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    makanDikonsumsiController.delete(selectedIndex);
                    selectedIndex = -1;
                }
            }
        });
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(buttonTambah);
        flowPanel.add(buttonHapus);
        panel.add(flowPanel, BorderLayout.SOUTH);
        return panel;
    }
    
    
    private JPanel getKeteranganAndPreviewPanel(){
        JPanel panel = new JPanel(new SpringLayout());
        
        JPanel keteranganPanel = new JPanel(new BorderLayout());
        keteranganPanel.setBorder(new TitledBorder("Keterangan"));
        labelKeterangan = new JLabel(makanDikonsumsiController.getKeteranganNutrisi());
        keteranganPanel.add(labelKeterangan, BorderLayout.CENTER);
//        JButton buttonListGiziIdeal = new JButton("Daftar Nutrisi Diet");
//        
//        JPanel panelButton = new JPanel(new FlowLayout());
//        buttonListGiziIdeal.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {   
//                DaftarTotalGiziMakananFrame daftarTotalGiziMakananFrame = new DaftarTotalGiziMakananFrame(makanDikonsumsiController);
//            }
//        });
//        panelButton.add(buttonListGiziIdeal);
//        keteranganPanel.add(panelButton, BorderLayout.SOUTH);
        
        JPanel priviewPanel = new JPanel(new FlowLayout());
        JButton buttonPriviewPanel = new JButton("Priveiew Report");
        buttonPriviewPanel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    makanDikonsumsiController.showPriviewReport();
            }
        });
        
        priviewPanel.add(buttonPriviewPanel);
        panel.add(keteranganPanel);
        panel.add(priviewPanel);
        SpringUtilities.makeGrid(panel, 2, 1, 5, 5, 5, 5);
        return panel;
    }

    @Override
    public void update(Observable o, Object arg) {
        customTableModelMakananDikonsumsi.filter("", 0);
        makanDikonsumsiController.hitungTotalNutrisi();
        labelKeterangan.setText(makanDikonsumsiController.getKeteranganNutrisi());
    }
    
}
