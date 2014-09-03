/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.ProfilUser;
import com.sview.EditProfileFrame;
import com.sview.ProfilePanel;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author fahmi
 */
public class ProfileController extends Observable {

    private ProfilUser profilUser;

    public ProfilUser getProfilUser() {
        return profilUser;
    }

    /**
     * set profile user to view
     *
     * @param editProfileFrame
     */
    public void setProfileUserFromView(EditProfileFrame editProfileFrame) {
        if (profilUser == null) {
            profilUser = new ProfilUser();
        }
        profilUser.setNama(editProfileFrame.textFieldNama.getText());
        profilUser.setBeratBadan(Double.parseDouble(editProfileFrame.textFieldBeratBadan.getText()));
        profilUser.setJenisKelamin(editProfileFrame.comboBoxJenisKelamin.getSelectedItem().toString());
        profilUser.setTinggiBadan(Double.parseDouble(editProfileFrame.textFieldTinggiBadan.getText()));
        profilUser.setUmur(Integer.parseInt(editProfileFrame.textFieldUmur.getText()));
        JOptionPane.showConfirmDialog(null, "Sukses edit user", "Pesan", JOptionPane.OK_OPTION);
        setChanged();
        notifyObservers();
    }

    /**
     * show profile user to view
     *
     * @param profilPanel
     */
    public void showProfileUserToView(ProfilePanel profilPanel) {
        profilPanel.labelNama.setText("Nama : " + profilUser.getNama());
        profilPanel.labelJenisKelamin.setText("Jenis Kelamin : " + profilUser.getJenisKelamin());
        profilPanel.labelBeratBadan.setText("Berat Badan : " + profilUser.getBeratBadan() + " Kg");
        profilPanel.labelTinggiBadan.setText("Tinggi Badan : " + profilUser.getTinggiBadan() + " Cm");
        profilPanel.labelUmur.setText("Umur : " + profilUser.getUmur() + " Tahun");
    }
}
