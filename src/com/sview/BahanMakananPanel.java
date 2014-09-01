/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.BahanMakananController;
import com.framework.CustomTableModel;
import com.framework.PanelUtilities;
import com.model.BahanMakanan;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author fahmi
 */
public class BahanMakananPanel extends JPanel{
    private JTextField textFieldCari;
    private JComboBox<String> comboBoxKategori;
    private JTable tableBahanMakanan = new JTable();
    
    private BahanMakananController bahanMakananController;
    
    public BahanMakananPanel() {
        super(new BorderLayout());
        try {
            bahanMakananController = new BahanMakananController();
        } catch (SQLException ex) {
            Logger.getLogger(BahanMakananPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        add(getCariPanel(), BorderLayout.NORTH);
        add(getTableMakananPanel(), BorderLayout.CENTER);
        add(getAddButtonPanel(), BorderLayout.SOUTH);
    }
    
    private JPanel getCariPanel(){
        JPanel panel = PanelUtilities.getSpringPanel();
        textFieldCari = new JTextField();
        String kategori [] = {"Nama Makanan", "Golongan"};
        comboBoxKategori = new JComboBox<>(kategori);
        panel.add(new JLabel("Kategori"));
        panel.add(comboBoxKategori);
        panel.add(new JLabel("Cari"));
        panel.add(textFieldCari);
        SpringUtilities.makeGrid(panel, 2, 2, 5, 5, 5, 5);
        return panel;
    }
    
    private JPanel getTableMakananPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        CustomTableModel<BahanMakanan> customTableModel = new CustomTableModel<BahanMakanan>() {

            @Override
            public Object getDataItem(BahanMakanan data, int column) {
                if(column == 0){
                    return  data.getIdBahanMakanan();
                }
                else {
                    return data.getNamaBahanMakanan();
                }
            }
        };
        String columnName[]= {"Id Makanan", "Nama Makanan"};
        customTableModel.setColumnName(columnName);
        customTableModel.setListData(bahanMakananController.getListBahanMakanan());
        
        tableBahanMakanan = new JTable(customTableModel);
        JScrollPane jScrollPane = new JScrollPane(tableBahanMakanan);
        panel.add(jScrollPane);
        return panel;
    }
    
    private JPanel getAddButtonPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        JButton buttonAdd = new JButton("Tambah");
        buttonAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "cobha", "heyy?", JOptionPane.YES_NO_OPTION);
            }
        });
        panel.add(buttonAdd, BorderLayout.CENTER);
        return panel;
    }
    
    
}
