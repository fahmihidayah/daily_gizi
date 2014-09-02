/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.BahanMakananController;
import com.j256.ormlite.dao.Dao;
import com.model.BahanMakanan;
import com.model.Constants;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author fahmi
 */
public class SimpanBahanMakananFrame extends JFrame implements Constants{
    
    private BahanMakananController bahanMakananController;
    private int mode;
    private int index;
    private JTextField textFieldNamaBahanMakanan, textFieldSatuanUrt, textFieldSatuanPenakar, textFieldBeratSatuanUrt,
            textFieldKarbohidrat, textFieldProtein,textFieldKalori,textFieldLemak;
    private JComboBox<Object> comboBoxGolongan;
    
    /**
     * butuh mode update 0, insert 1;
     * index update antara 0-n, insert -1
     */
    public SimpanBahanMakananFrame(BahanMakananController bahanMakananController, int mode, int index) {
        super("Input Bahan Makanan");
        setSize(300, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        this.bahanMakananController = bahanMakananController;
        this.mode = mode;        
        this.index = index;
        initialComponent();
    }
    
    private void initialComponent(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(getInputPanel() , BorderLayout.CENTER);
        panel.add(getButtonPanel() , BorderLayout.SOUTH);
        add(panel);
    }
    
    private JPanel getInputPanel(){
        JPanel panel = new JPanel(new SpringLayout());
        
        panel.add(new JLabel("Nama Bahan Makanan"));
        textFieldNamaBahanMakanan = new JTextField();
        panel.add(textFieldNamaBahanMakanan);
        
        panel.add(new JLabel("Satuan Urt"));
        textFieldSatuanUrt = new JTextField();
        panel.add(textFieldSatuanUrt);
        
        panel.add(new JLabel("Satuan Penukar"));
        textFieldSatuanPenakar = new JTextField();
        panel.add(textFieldSatuanPenakar);
        
        panel.add(new JLabel("Berat Satuan Urt "));
        textFieldBeratSatuanUrt = new  JTextField();
        panel.add(textFieldBeratSatuanUrt);
        
        panel.add(new JLabel("Golongan"));
        comboBoxGolongan = new JComboBox<>(bahanMakananController.getListStringGolongan());
        panel.add(comboBoxGolongan);
        
        panel.add(new JLabel("Karbohidrat"));
        textFieldKarbohidrat = new JTextField();
        panel.add(textFieldKarbohidrat);
        
        panel.add(new JLabel("Protein"));
        textFieldProtein  = new JTextField();
        panel.add(textFieldProtein);
        
        panel.add(new JLabel("Kalori"));
        textFieldKalori  = new JTextField();
        panel.add(textFieldKalori);
        
        panel.add(new JLabel("Lemak"));
        textFieldLemak  = new JTextField();
        panel.add(textFieldLemak);
        
        SpringUtilities.makeGrid(panel, 9, 2, 5, 5, 5, 5);
        
        return panel;
    }
    
    private JPanel getButtonPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        JButton buttonSimpan = new JButton("Simpan");
        
        buttonSimpan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(mode == UPDATE_MODE){
                    // edit
                }
                else {
                    // insert
                }
            }
        });
        panel.add(buttonSimpan, BorderLayout.CENTER);
        return panel;
    }
    
    
    
    
    
    
}
