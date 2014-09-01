/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.model.ProfilUser;
import com.oracle_source.layout.SpringUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author fahmi
 */
public class ProfilePanel extends JPanel {

    private JLabel labelNama, labelJenisKelamin, labelTinggiBadan, labelBeratBadan, labelUmur;
    private JButton buttonEdit;

    private ProfilUser profilUser ;
    
    public ProfilePanel(ProfilUser profilUser) {
        super(new SpringLayout());
        labelNama = new JLabel("Nama ");
        labelBeratBadan = new JLabel("Berat Badan ");
        labelJenisKelamin = new JLabel("Jenis Kelamin");
        labelTinggiBadan = new JLabel("Tinggi Badan");
        labelUmur = new JLabel("Umur");
        buttonEdit = new JButton("Edit");
        this.profilUser = profilUser;
        buttonEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                EditProfileFrame editProfileFrame = new EditProfileFrame();
            }
        });
        
        add(labelNama);
        add(labelJenisKelamin);
        add(labelTinggiBadan);
        add(labelBeratBadan);
        add(labelUmur);
        add(buttonEdit);
        SpringUtilities.makeGrid(this, 6, 1, 10, 10, 10, 10);    
    }

    public ProfilUser getProfilUser() {
        return profilUser;
    }

    public void setProfilUser(ProfilUser profilUser) {
        this.profilUser = profilUser;
    }
    
    public void setUserProfileToView(){
        if(this.profilUser != null){
            labelNama.setText(profilUser.getNama());
        }
    }
    
}
