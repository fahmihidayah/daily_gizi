/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.ProfileController;
import com.custom.CustomJButton;
import com.model.ProfilUser;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
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
public class ProfilePanel extends JPanel implements  Observer{

    public JLabel labelNama, labelJenisKelamin, labelTinggiBadan, labelBeratBadan, labelUmur
            , labelKlasifikasi, labelKebutuhanKaloriHarian;
    private JButton buttonEdit;

//    private ProfilUser profilUser ;
    private ProfileController profileController;
    
    public ProfilePanel(ProfileController profileController) {
        super(new BorderLayout());
        this.profileController = profileController;
        profileController.addObserver(this);
        add(getProfilePanel(), BorderLayout.CENTER);
        add(getButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel getProfilePanel(){
        JPanel panel = new JPanel(new SpringLayout());
        labelNama = new JLabel("Nama ");
        labelBeratBadan = new JLabel("Berat Badan ");
        labelJenisKelamin = new JLabel("Jenis Kelamin");
        labelTinggiBadan = new JLabel("Tinggi Badan");
        labelUmur = new JLabel("Umur");
        labelKlasifikasi = new JLabel("Klasifikasi");
        labelKebutuhanKaloriHarian = new JLabel("Kebutuhan Kalori Harian");
        panel.add(labelNama);
        panel.add(labelJenisKelamin);
        panel.add(labelTinggiBadan);
        panel.add(labelBeratBadan);
        panel.add(labelUmur);
        panel.add(labelKlasifikasi);
        panel.add(labelKebutuhanKaloriHarian);
        SpringUtilities.makeGrid(panel, 7, 1, 10, 10, 10, 10);   
        return panel;
    }
    
    public JPanel getButtonPanel(){
        JPanel panel = new JPanel(new FlowLayout());
        buttonEdit = new CustomJButton("Edit");
        buttonEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                EditProfileFrame editProfileFrame = new EditProfileFrame(profileController);
            }
        });
        panel.add(buttonEdit);
        return panel;
    }
    
    public void setUserProfileToView(){
        profileController.showProfileUserToView(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        setUserProfileToView();
    }
    
}
