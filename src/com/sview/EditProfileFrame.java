/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.framework.PanelUtilities;
import com.model.ProfilUser;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    private ProfilUser profilUser;
    
    private void initialComponent() {
        textFieldBeratBadan = new JTextField();
        textFieldNama = new JTextField();
        textFieldTinggiBadan = new JTextField();
        textFieldUmur = new JTextField();
        comboBoxJenisKelamin = new JComboBox<>(jenisKelamin);
        buttonSave = new JButton("Simpan");
    }

    public EditProfileFrame(ProfilUser profilUser) {
        super("Edit Profile");
        this.profilUser = profilUser;
        setSize(300, 250);
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
        mainPanel.add(new JLabel("Berat Badan"));
        mainPanel.add(textFieldBeratBadan);
        mainPanel.add(new JLabel("Tinggi Badan"));
        mainPanel.add(textFieldTinggiBadan);
        mainPanel.add(new JLabel("Umur"));
        mainPanel.add(textFieldUmur);
        mainPanel.add(buttonSave);
        buttonSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                profilUser.setNama(textFieldNama.getText());
                profilUser.setBeratBadan(Double.parseDouble(textFieldBeratBadan.getText()));
                profilUser.setJenisKelamin(comboBoxJenisKelamin.getSelectedItem().toString());
                profilUser.setTinggiBadan(Double.parseDouble(textFieldTinggiBadan.getText()));
                profilUser.setUmur(Integer.parseInt(textFieldUmur.getText()));
                JOptionPane.showConfirmDialog(null, "Sukses edit user", "Pesan", JOptionPane.OK_OPTION);
            }
        });
        mainPanel.add(new JPanel());
        SpringUtilities.makeGrid(mainPanel, 6, 2, 5, 5, 5, 5);
        add(mainPanel);
    }
    
    
}
