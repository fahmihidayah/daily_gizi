/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.MakanDikonsumsiController;
import com.framework.CustomTableModel;
import com.model.BahanMakanan;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author fahmi
 */
public class SimpanMakananDikonsumsiFrame extends  JFrame{
    private JComboBox<Object> comboBoxKategoriMakanan;
    private JTable tableBahanMakanan;
    private CustomTableModel<BahanMakanan> customTableModelBahanMakanan;
    private JTextField textFieldNamaMakanan;
    private JTextField textFieldJumlah;
    private JLabel labelSatuanUrt;
    private MakanDikonsumsiController makanDikonsumsiController;
    private String kategori[] = {"Id Makanan", "Nama Makanan", "Satuan Urt", "Satuan Penukar", "Berat Satuan Urt", "Golongan", "Karbohidrat", "Protein", "Kalori", "Lemak"};

    public SimpanMakananDikonsumsiFrame(MakanDikonsumsiController makanDikonsumsiController) {
        super("Makanan Dikonsumsi");
        this.makanDikonsumsiController = makanDikonsumsiController;
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(getMainPanel());
    }
    
    
    private JPanel getMainPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(getSelectBahanMakananPanel(), BorderLayout.CENTER);
        panel.add(getMakananDikonsumsiPanel(), BorderLayout.SOUTH);
        return panel;
    }
    private JPanel getSelectBahanMakananPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelKategori = new JPanel(new FlowLayout());
        panelKategori.add(new JLabel("Pilih Golongan :"));
        comboBoxKategoriMakanan = new JComboBox<>(makanDikonsumsiController.getListStringGolongan());
        comboBoxKategoriMakanan.addActionListener(new  ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                customTableModelBahanMakanan.filter(comboBoxKategoriMakanan.getSelectedItem().toString(), 5);
            }
        });
        panelKategori.add(comboBoxKategoriMakanan);
        
        JPanel panelTable = new JPanel(new BorderLayout());
        customTableModelBahanMakanan = new CustomTableModel<BahanMakanan>() {

            @Override
            public Object getDataItem(BahanMakanan data, int column) {
                if (column == 0) {
                    return data.getIdBahanMakanan();
                } else if (column == 1) {
                    return data.getNamaBahanMakanan();
                } else if (column == 2) {
                    return data.getSatuanUrt();
                } else if (column == 3) {
                    return data.getSatuanPenukar();
                } else if (column == 4) {
                    return data.getBeratSatuanUrt();
                } else if (column == 5) {
                    return data.getGolongan().getNamaGolongan();
                } else if (column == 6) {
                    return data.getKarbohidrat();
                } else if (column == 7) {
                    return data.getProtein();
                } else if (column == 8) {
                    return data.getKalori();
                } else {
                    return data.getLemak();
                }
            }
        };
        
        customTableModelBahanMakanan.setColumnName(kategori);
        customTableModelBahanMakanan.setListData(makanDikonsumsiController.getListBahanMakanan());
        tableBahanMakanan = new JTable(customTableModelBahanMakanan);
        customTableModelBahanMakanan.createRowSorter(tableBahanMakanan);
        JScrollPane scrollPane = new JScrollPane(tableBahanMakanan);
        panelTable.add(scrollPane);
        
        panel.add(panelKategori, BorderLayout.NORTH);
        panel.add(panelTable, BorderLayout.CENTER);
//        customTableModelBahanMakanan.filter(comboBoxKategoriMakanan.getSelectedItem().toString(), 5);
        return panel;
    }
    
    private JPanel getMakananDikonsumsiPanel(){
        JPanel panel = new JPanel(new SpringLayout());
        panel.add(new JLabel("Nama Makanan"));
        textFieldNamaMakanan = new JTextField();
        panel.add(textFieldNamaMakanan);
        panel.add(new JLabel("Jumlah "));
        
        JPanel panelJumlan = new JPanel(new BorderLayout());
        textFieldJumlah = new JTextField();
        panelJumlan.add(textFieldJumlah, BorderLayout.CENTER);
        labelSatuanUrt = new JLabel("-");
        panelJumlan.add(labelSatuanUrt, BorderLayout.EAST);
        
        panel.add(panelJumlan);
        
        JPanel panelSimpanButton = new JPanel(new FlowLayout());
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sdsd");
            }
        });
        panelSimpanButton.add(buttonSimpan);
        panel.add(panelSimpanButton);
        SpringUtilities.makeGrid(panel, 5, 1, 5, 5, 5, 5);
        return panel;
    }
    
}
