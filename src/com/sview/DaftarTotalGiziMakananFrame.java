/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.MakanDikonsumsiController;
import com.controller.ProfileController;
import com.framework.CustomTableModel;
import static com.model.Constants.UPDATE_MODE;
import com.model.TotalGiziMakanan;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author fahmi
 */
public class DaftarTotalGiziMakananFrame extends JFrame {

    private ArrayList<TotalGiziMakanan> listTotalGiziMakanan = new ArrayList<>();
    private JTable table;
    private CustomTableModel<TotalGiziMakanan> customTableModel;
    private String columnName[] = {"Nama Tipe", "Karbohidrat / Nasi", "Protein Hewani Rendah Lemak", "Protein Hewani Lemak Sedang Sedang"
    ,"Sayuran B", "Buah", "Madu", "Santan / Minyak" , "Kue Rp", "Energi (Kkal)", "Protein (g)", "Lemak (g)", "Karbohidrat (g)"};
    private MakanDikonsumsiController makanDikonsumsiController;
    private int index = -1;
    
    
    private void iniitialData() {
        TotalGiziMakanan totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("1100 Kal");
        totalGiziMakanan.setTotalBuah(3.0);
        totalGiziMakanan.setTotalEnergi(1125.0);
        totalGiziMakanan.setTotalHewaniLemakSedang(1.5);
        totalGiziMakanan.setTotalKarbohidratAtauNasi(3.0);
        totalGiziMakanan.setTotalHewaniRendahLemak(1.5);
        totalGiziMakanan.setTotalSayuranB(1.5);
        totalGiziMakanan.setTotalMadu(0.0);
        totalGiziMakanan.setTotalMinyak(5.0);
        totalGiziMakanan.setTotalKueRp(0.0);
        totalGiziMakanan.setTotalProtein(31.0);
        totalGiziMakanan.setTotalLemak(34.5);
        totalGiziMakanan.setTotalKarbohidrat(164.0);

        listTotalGiziMakanan.add(totalGiziMakanan);
        totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("1300 Kal");
        totalGiziMakanan.setTotalKarbohidratAtauNasi(3.0);
        totalGiziMakanan.setTotalHewaniRendahLemak(1.0);
        totalGiziMakanan.setTotalHewaniLemakSedang(1.5);
        totalGiziMakanan.setTotalSayuranB(1.5);

        totalGiziMakanan.setTotalBuah(4.0);
        totalGiziMakanan.setTotalMadu(1.0);
        totalGiziMakanan.setTotalMinyak(6.0);
        totalGiziMakanan.setTotalKueRp(0.0);

        totalGiziMakanan.setTotalEnergi(1275.0);

        totalGiziMakanan.setTotalProtein(31.0);
        totalGiziMakanan.setTotalLemak(39.5);
        totalGiziMakanan.setTotalKarbohidrat(188.0);
        listTotalGiziMakanan.add(totalGiziMakanan);
    }
    
    
    public DaftarTotalGiziMakananFrame(MakanDikonsumsiController makanDikonsumsiController) {
        super("Daftar Total Makanan Gizi Profile");
        setSize(1200, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        iniitialData();
        add(getMainPanel());
        setVisible(true);
        this.makanDikonsumsiController = makanDikonsumsiController;
        
    }
    
    private JPanel getMainPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        
        customTableModel = new CustomTableModel<TotalGiziMakanan>() {

            @Override
            public Object getDataItem(TotalGiziMakanan data, int column) {
                if(column == 0){
                    return data.getNamaDiet();
                }
                else if(column == 1){
                    return data.getTotalKarbohidratAtauNasi();
                }
                else if(column == 2){
                    return data.getTotalHewaniRendahLemak();
                }
                else if(column == 3){
                    return data.getTotalHewaniLemakSedang();
                }
                else if(column == 4){
                    return data.getTotalSayuranB();
                }
                else if(column == 5){
                    return data.getTotalBuah();
                }
                else if(column == 6){
                    return data.getTotalMadu();
                }
                else if(column == 7){
                    return data.getTotalMinyak();
                }
                else if(column == 8){
                    return data.getTotalKueRp();
                }
                else if(column == 9){
                    return data.getTotalEnergi();
                }
                else if(column == 10){
                    return data.getTotalProtein();
                }
                else if(column == 11){
                    return data.getTotalLemak();
                }
                else {
                    return data.getTotalKarbohidrat();
                }
            }
        };
        customTableModel.setColumnName(columnName);
        customTableModel.setListData(listTotalGiziMakanan);
        
        table = new JTable(customTableModel);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                Point p = e.getPoint();
                index = table.rowAtPoint(p);
            }
        });
        customTableModel.createRowSorter(table);
        JScrollPane scrol = new JScrollPane(table);
        panel.add(scrol, BorderLayout.CENTER);
        panel.add(getButtonPanel(), BorderLayout.SOUTH);
        return panel;        
    }
    
    private JPanel getButtonPanel(){
        JPanel panel = new JPanel(new FlowLayout());
        
        JButton button = new JButton("Pilih");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(index != -1){
                    makanDikonsumsiController.setSelectedTotalGiziMakanan(listTotalGiziMakanan.get(index));
                    DaftarTotalGiziMakananFrame.this.dispose();
                }
            }
        });
        panel.add(button);
        return panel;
    }
}
