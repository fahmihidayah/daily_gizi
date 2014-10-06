/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.MakanDikonsumsiController;
import com.custom.CustomJButton;
import com.framework.CustomTableModel;
import com.model.BahanMakanan;
import com.model.Constants;
import static com.model.Constants.UPDATE_MODE;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class SimpanMakananDikonsumsiFrame extends  JFrame implements  Constants{
    public JComboBox<Object> comboBoxKategoriMakanan, comboBoxWaktuMakan;
     public JTable tableBahanMakanan;
    public CustomTableModel<BahanMakanan> customTableModelBahanMakanan;
    public JTextField textFieldNamaMakanan;
    public JTextField textFieldJumlah;
    public JLabel labelSatuanUrt;
    private MakanDikonsumsiController makanDikonsumsiController;
    private String kategori[] = {"Id Makanan", "Nama Makanan", "Satuan Urt", "Satuan Penukar", "Berat Satuan Urt", "Golongan", "Karbohidrat", "Protein", "Kalori", "Lemak"};
    private Object waktuMakanStr[] = {"Pagi", "Siang", "Malam"};
    
    private int mode;
    private int index;
    
    public SimpanMakananDikonsumsiFrame(MakanDikonsumsiController makanDikonsumsiController, int mode, int index) {
        super("Makanan Dikonsumsi");
        this.makanDikonsumsiController = makanDikonsumsiController;
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(getMainPanel());
        this.mode = mode;
        this.index = index;
        if(mode == UPDATE_MODE && index >= 0){
            makanDikonsumsiController.setMakananDiKonsumsiToView(index, this);
        }
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
                    return data.getIdBahanMakanan() ;
                } else if (column == 1) {
                    return data.getNamaBahanMakanan() ;
                } else if (column == 2) {
                    return data.getSatuanUrt()+ "";
                } else if (column == 3) {
                    return data.getSatuanPenukar()+ "";
                } else if (column == 4) {
                    return data.getBeratSatuanUrt()+ "";
                } else if (column == 5) {
                    return data.getGolongan().getNamaGolongan()+ "";
                } else if (column == 6) {
                    return data.getKarbohidrat()+ "";
                } else if (column == 7) {
                    return data.getProtein()+ "";
                } else if (column == 8) {
                    return data.getKalori()+ "";
                } else {
                    return data.getLemak()+ "";
                }
            }
        };
        
        customTableModelBahanMakanan.setColumnName(kategori);
        customTableModelBahanMakanan.setListData(makanDikonsumsiController.getListBahanMakanan());
        tableBahanMakanan = new JTable(customTableModelBahanMakanan);
        tableBahanMakanan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                Point p = e.getPoint();
                int selectedIndex = table.rowAtPoint(p);
                Long id = (Long) table.getValueAt(selectedIndex, 0);
                makanDikonsumsiController.setCurrentBahanMakananByid(id);
                textFieldNamaMakanan.setText(makanDikonsumsiController.getCurrentBahanMakanan().getNamaBahanMakanan());
                labelSatuanUrt.setText(makanDikonsumsiController.getCurrentBahanMakanan().getSatuanUrt());
            }
        });
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
        JPanel panelNamaMakanan = new JPanel(new SpringLayout());
        textFieldNamaMakanan = new JTextField();
        panelNamaMakanan.add(textFieldNamaMakanan);
        panelNamaMakanan.add(new JPanel());
        SpringUtilities.makeGrid(panelNamaMakanan, 1, 2, 5,5, 5, 5);
        panel.add(panelNamaMakanan);
        
        //
        panel.add(new JLabel("Waktu Makan"));
        JPanel panelWaktuMakan = new JPanel(new SpringLayout());
        comboBoxWaktuMakan = new JComboBox<>(waktuMakanStr);
        panelWaktuMakan.add(comboBoxWaktuMakan);
        panelWaktuMakan.add(new JPanel());
        SpringUtilities.makeGrid(panelWaktuMakan, 1, 2, 5, 5, 5, 5);
        panel.add(panelWaktuMakan);
                
        panel.add(new JLabel("Jumlah "));
        
        JPanel panelJumlan = new JPanel(new SpringLayout());
        textFieldJumlah = new JTextField(30);
        panelJumlan.add(textFieldJumlah, BorderLayout.CENTER);
        labelSatuanUrt = new JLabel("-");
        panelJumlan.add(labelSatuanUrt, BorderLayout.EAST);
        SpringUtilities.makeGrid(panelJumlan, 1, 2, 5, 5, 5, 5);
        panel.add(panelJumlan);
        
        JPanel panelSimpanButton = new JPanel(new FlowLayout());
        JButton buttonSimpan = new CustomJButton("Simpan");
        buttonSimpan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(mode == INSERT_MODE){
                    makanDikonsumsiController.saveData(comboBoxWaktuMakan.getSelectedItem().toString(), Double.parseDouble(textFieldJumlah.getText()));    
                }else {
                    makanDikonsumsiController.updateData(comboBoxWaktuMakan.getSelectedItem().toString(), Double.parseDouble(textFieldJumlah.getText()), index);
                }
                
            }
        });
        panelSimpanButton.add(buttonSimpan);
        panel.add(panelSimpanButton);
        SpringUtilities.makeGrid(panel, 7, 1, 5, 5, 5, 5);
        return panel;
    }
    
}
