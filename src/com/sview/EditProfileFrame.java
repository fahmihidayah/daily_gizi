/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.framework.PanelUtilities;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
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
public class EditProfileFrame extends JFrame {

    private JTextField textFieldNama, textFieldTinggiBadan, textFieldBeratBadan, textFieldUmur;
    private JComboBox<String> comboBoxJenisKelamin;
    private String [] jenisKelamin = {"Laki-Laki", "Perempuan"};
    private JButton buttonSave;
    
    private void initialComponent() {
        textFieldBeratBadan = new JTextField();
        textFieldNama = new JTextField();
        textFieldTinggiBadan = new JTextField();
        textFieldUmur = new JTextField();
        comboBoxJenisKelamin = new JComboBox<>(jenisKelamin);
        buttonSave = new JButton("Simpan");
    }

    public EditProfileFrame() {
        super("Edit Profile");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        settingComponent();
       
    }
    
    private void settingComponent(){
        initialComponent();
        JPanel mainPanel = PanelUtilities.getSpringPanel();
        
        mainPanel.add(new JLabel("Nama"));
        mainPanel.add(textFieldNama);
        mainPanel.add(new JLabel("Jenis Kelamin"));
        mainPanel.add(comboBoxJenisKelamin);
        mainPanel.add(new JLabel("Tinggi Badan"));
        mainPanel.add(textFieldTinggiBadan);
        mainPanel.add(new JLabel("Umur"));
        mainPanel.add(textFieldUmur);
        mainPanel.add(buttonSave);
        mainPanel.add(new JPanel());
        SpringUtilities.makeGrid(mainPanel, 5, 2, 5, 5, 5, 5);
        add(mainPanel);
    }
    
    
}
