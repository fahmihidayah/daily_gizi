/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.BahanMakananController;
import com.controller.MakanDikonsumsiController;
import com.framework.CustomTableModel;
import com.model.MakananDiKonsumsi;
import com.model.ProfilUser;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

/**
 *
 * @author fahmi
 */
public class AnalisaKaloriPanel extends JPanel{
    JTable tableMakananDikonsumsi ;
    JLabel labelKeterangan; 
    CustomTableModel<MakananDiKonsumsi> customTableModelMakananDikonsumsi;
    
    private BahanMakananController bahanMakananController;
    private MakanDikonsumsiController makanDikonsumsiController;
    private ProfilUser profilUser;

    public AnalisaKaloriPanel(BahanMakananController bahanMakananController, MakanDikonsumsiController makanDikonsumsiController, ProfilUser profilUser) {
        super(new BorderLayout());
        this.bahanMakananController = bahanMakananController;
        this.makanDikonsumsiController = makanDikonsumsiController;
        this.profilUser = profilUser;
        
        add(getTableMakananDikonsumsiPanel(), BorderLayout.CENTER);
        add(getKeteranganAndPreviewPanel() , BorderLayout.SOUTH);
    }
    
    private JPanel getTableMakananDikonsumsiPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        String [] columnName = {"Nama Makanan", "Jumlah"};
        customTableModelMakananDikonsumsi = new CustomTableModel<MakananDiKonsumsi>() {

            @Override
            public Object getDataItem(MakananDiKonsumsi data, int column) {
                if(column == 0){
                    return data.getBahanMakanan().getNamaBahanMakanan();
                }
                else {
                    return data.getJumlah();
                }
            }
        };
        customTableModelMakananDikonsumsi.setColumnName(columnName);
        customTableModelMakananDikonsumsi.setListData(makanDikonsumsiController.getListMakananDikonsumsi());
        JScrollPane scrollPane = new JScrollPane(tableMakananDikonsumsi);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton buttonTambah = new JButton("Tambah");
        buttonTambah.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Tambah", "Pesan", JOptionPane.OK_OPTION);
            }
        });
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(buttonTambah);
        panel.add(flowPanel, BorderLayout.SOUTH);
        return panel;
    }
    
    
    private JPanel getKeteranganAndPreviewPanel(){
        JPanel panel = new JPanel(new SpringLayout());
        
        JPanel keteranganPanel = new JPanel(new BorderLayout());
        keteranganPanel.setBorder(new TitledBorder("Keterangan"));
        labelKeterangan = new JLabel("Keterangan dll");
        keteranganPanel.add(labelKeterangan);
        
        JPanel priviewPanel = new JPanel(new FlowLayout());
        JButton buttonPriviewPanel = new JButton("Priveiew Report");
        buttonPriviewPanel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        priviewPanel.add(buttonPriviewPanel);
        panel.add(keteranganPanel);
        panel.add(priviewPanel);
        SpringUtilities.makeGrid(panel, 2, 1, 5, 5, 5, 5);
        return panel;
    }
    
}
