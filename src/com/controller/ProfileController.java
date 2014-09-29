/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.DataSingleton;
import com.model.ProfilUser;
import com.model.TotalGiziMakanan;
import com.sview.EditProfileFrame;
import com.sview.ProfilePanel;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author fahmi
 */
public class ProfileController extends Observable {

    private ProfilUser profilUser = DataSingleton.getInstance().getProfilUser();
    private ArrayList<TotalGiziMakanan> listTotalGiziMakanan = DataSingleton.getInstance().getListTotalGiziMakanan();

    public ProfileController() {
        initialListTotalGiziMakanan();
    }
    
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
        profilUser.hitungBeratBadanRelative();
        
        Double kaloriHarian = profilUser.getKaloriHarian();
        if(kaloriHarian <= 1100){
            DataSingleton.getInstance().setTotalGiziMakanan(DataSingleton.getInstance().getListTotalGiziMakanan().get(0));
        }
        else if(kaloriHarian <= 1300){
            DataSingleton.getInstance().setTotalGiziMakanan(DataSingleton.getInstance().getListTotalGiziMakanan().get(1));
        }
        else if(kaloriHarian <= 1500){
            DataSingleton.getInstance().setTotalGiziMakanan(DataSingleton.getInstance().getListTotalGiziMakanan().get(2));
        }
        else if(kaloriHarian <= 1700){
            DataSingleton.getInstance().setTotalGiziMakanan(DataSingleton.getInstance().getListTotalGiziMakanan().get(3));
        }
        else if(kaloriHarian <= 1900){
            DataSingleton.getInstance().setTotalGiziMakanan(DataSingleton.getInstance().getListTotalGiziMakanan().get(4));
        }
        else if(kaloriHarian <= 2100){
            DataSingleton.getInstance().setTotalGiziMakanan(DataSingleton.getInstance().getListTotalGiziMakanan().get(5));
        }
        else if(kaloriHarian <= 2300){
            DataSingleton.getInstance().setTotalGiziMakanan(DataSingleton.getInstance().getListTotalGiziMakanan().get(6));
        }
        else {
            DataSingleton.getInstance().setTotalGiziMakanan(DataSingleton.getInstance().getListTotalGiziMakanan().get(7));
        }
        System.out.println(DataSingleton.getInstance().getTotalGiziMakanan().getNamaDiet());
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
        profilPanel.labelKlasifikasi.setText("Klasifikasi : " + profilUser.getKlasifikasi());
        profilPanel.labelKebutuhanKaloriHarian.setText("Kebutuhan Kalori Harian : " + profilUser.getKaloriHarian() + " Kal");
    }
    
    private void initialListTotalGiziMakanan(){
        TotalGiziMakanan totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("Standar Diet Diabetes Militus 1100 Kal");
        totalGiziMakanan.setJenisEnergi(1100.0);
        totalGiziMakanan.setTotalKarbohidrat(2.0);
        totalGiziMakanan.setNabati(2.0);
        totalGiziMakanan.setSusuTanpaLemak(0.0);
        totalGiziMakanan.setMinyak(3.0);
        totalGiziMakanan.setTotalEnergi(1024.0);
        totalGiziMakanan.setTotalProtein(41.0);
        totalGiziMakanan.setTotalLemak(30.0);
        totalGiziMakanan.setTotalKarbohidrat(152.0);
        
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Bubur/Nasi", "2 penukar karbohidrat"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Ayam tanpa kulit", "2 penukar hewani (Protein rendah lemak)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Daging", "1 penukar hewani (Protein lemak sedang)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Tempe/Tahu", "2 penukar nabati"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur A", "Sekehandak"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur B", "2 penukar sayuran"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Buah", "4 penukar buah"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Minyak", "3 penukar minyak"));
        
        listTotalGiziMakanan.add(totalGiziMakanan);
        
        totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("Standar Diet Diabetes Militus 1300 Kal");
        totalGiziMakanan.setJenisEnergi(1300.0);
        totalGiziMakanan.setTotalKarbohidrat(3.0);
        totalGiziMakanan.setNabati(2.0);
        totalGiziMakanan.setSusuTanpaLemak(0.0);
        totalGiziMakanan.setMinyak(4.0);
        totalGiziMakanan.setTotalEnergi(1263.0);
        totalGiziMakanan.setTotalProtein(45.0);
        totalGiziMakanan.setTotalLemak(35.0);
        totalGiziMakanan.setTotalKarbohidrat(192.0);
        
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Nasi", "3 penukar karbohidrat"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Ayam tanpa kulit / ikan", "2 penukar hewani (Protein rendah lemak)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Daging", "1 penukar hewani (Protein lemak sedang)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Kacang merah / Tahu", "2 penukar nabati"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur A", "Sekehandak"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur B", "2 penukar sayuran"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Buah", "4 penukar buah"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Minyak", "4 penukar minyak"));
        
        listTotalGiziMakanan.add(totalGiziMakanan);
        
        totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("Standar Diet Diabetes Militus 1500 Kal");
        totalGiziMakanan.setJenisEnergi(1500.0);
        totalGiziMakanan.setTotalKarbohidrat(4.0);
        totalGiziMakanan.setNabati(2.5);
        totalGiziMakanan.setSusuTanpaLemak(0.0);
        totalGiziMakanan.setMinyak(4.0);
        totalGiziMakanan.setTotalEnergi(1476.0);
        totalGiziMakanan.setTotalProtein(51.0);
        totalGiziMakanan.setTotalLemak(36.0);
        totalGiziMakanan.setTotalKarbohidrat(235.0);
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Nasi", "4 penukar karbohidrat"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Ayam tanpa kulit / ikan", "2 penukar hewani (Protein rendah lemak)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Daging", "1 penukar hewani (Protein lemak sedang)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Kacang polong / Tahu", "2.5 penukar nabati"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur A", "Sekehandak"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur B", "2 penukar sayuran"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Buah", "4 penukar buah"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Minyak", "4 penukar minyak"));
        
        listTotalGiziMakanan.add(totalGiziMakanan);
        
        totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("Standar Diet Diabetes Militus 1700 Kal");
        totalGiziMakanan.setJenisEnergi(1700.0);
        totalGiziMakanan.setTotalKarbohidrat(5.0);
        totalGiziMakanan.setNabati(2.5);
        totalGiziMakanan.setSusuTanpaLemak(0.0);
        totalGiziMakanan.setMinyak(4.0);
        totalGiziMakanan.setTotalEnergi(1652.0);
        totalGiziMakanan.setTotalProtein(55.0);
        totalGiziMakanan.setTotalLemak(36.0);
        totalGiziMakanan.setTotalKarbohidrat(275.0);
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Nasi", "5 penukar karbohidrat"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Ayam tanpa kulit / ikan", "2 penukar hewani (Protein rendah lemak)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Daging", "1 penukar hewani (Protein lemak sedang)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Kacang tolo / Tahu", "2.5 penukar nabati"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur A", "Sekehandak"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur B", "2 penukar sayuran"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Buah", "4 penukar buah"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Minyak", "4 penukar minyak"));
        
        listTotalGiziMakanan.add(totalGiziMakanan);
        
        totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("Standar Diet Diabetes Militus 1900 Kal");
        totalGiziMakanan.setJenisEnergi(1900.0);
        totalGiziMakanan.setTotalKarbohidrat(6.0);
        totalGiziMakanan.setNabati(2.5);
        totalGiziMakanan.setSusuTanpaLemak(0.0);
        totalGiziMakanan.setMinyak(6.0);
        totalGiziMakanan.setTotalEnergi(1918.0);
        totalGiziMakanan.setTotalProtein(59.0);
        totalGiziMakanan.setTotalLemak(46.0);
        totalGiziMakanan.setTotalKarbohidrat(315.0);
        
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Nasi", "6 penukar karbohidrat"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Ayam tanpa kulit / ikan", "2 penukar hewani (Protein rendah lemak)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Telur", "1 penukar hewani (Protein lemak sedang)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Kacang tolo / tempe / Tahu", "2.5 penukar nabati"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur A", "Sekehandak"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur B", "2 penukar sayuran"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Buah", "4 penukar buah"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Minyak", "6 penukar minyak"));
        
        listTotalGiziMakanan.add(totalGiziMakanan);
        
        totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("Standar Diet Diabetes Militus 2100 Kal");
        totalGiziMakanan.setJenisEnergi(2100.0);
        totalGiziMakanan.setTotalKarbohidrat(6.5);
        totalGiziMakanan.setNabati(3.0);
        totalGiziMakanan.setSusuTanpaLemak(0.0);
        totalGiziMakanan.setMinyak(7.0);
        totalGiziMakanan.setTotalEnergi(2089.0);
        totalGiziMakanan.setTotalProtein(64.0);
        totalGiziMakanan.setTotalLemak(53.0);
        totalGiziMakanan.setTotalKarbohidrat(339.0);
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Nasi", "6.5 penukar karbohidrat"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Ayam tanpa kulit / ikan", "2 penukar hewani (Protein rendah lemak)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Daging", "1 penukar hewani (Protein lemak sedang)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Tempe / Tahu", "3 penukar nabati"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur A", "Sekehandak"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur B", "2 penukar sayuran"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Buah", "4 penukar buah"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Minyak", "7 penukar minyak"));
        listTotalGiziMakanan.add(totalGiziMakanan);
        
        totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("Standar Diet Diabetes Militus 2300 Kal");
        totalGiziMakanan.setJenisEnergi(2300.0);
        totalGiziMakanan.setTotalKarbohidrat(7.5);
        totalGiziMakanan.setNabati(3.0);
        totalGiziMakanan.setSusuTanpaLemak(1.0);
        totalGiziMakanan.setMinyak(7.0);
        totalGiziMakanan.setTotalEnergi(2310.0);
        totalGiziMakanan.setTotalProtein(75.0);
        totalGiziMakanan.setTotalLemak(63.0);
        totalGiziMakanan.setTotalKarbohidrat(379.0);
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Nasi / krekers / roti", "7.5 penukar karbohidrat"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Ayam tanpa kulit / ikan", "2 penukar hewani (Protein rendah lemak)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Telur", "1 penukar hewani (Protein lemak sedang)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Tempe / Tahu / Kacang merah", "3 penukar nabati"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur A", "Sekehandak"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur B", "2 penukar sayuran"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Buah", "4 penukar buah"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Susu Tanpa Lemak", "1 penukar susu"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Minyak", "7 penukar minyak"));
        listTotalGiziMakanan.add(totalGiziMakanan);
        
        totalGiziMakanan = new TotalGiziMakanan();
        totalGiziMakanan.setNamaDiet("Standar Diet Diabetes Militus 2500 Kal");
        totalGiziMakanan.setJenisEnergi(2500.0);
        totalGiziMakanan.setTotalKarbohidrat(8.0);
        totalGiziMakanan.setNabati(5.0);
        totalGiziMakanan.setSusuTanpaLemak(1.0);
        totalGiziMakanan.setMinyak(7.0);
        totalGiziMakanan.setTotalEnergi(2503.0);
        totalGiziMakanan.setTotalProtein(87.0);
        totalGiziMakanan.setTotalLemak(69.0);
        totalGiziMakanan.setTotalKarbohidrat(413.0);
        
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Nasi / roti", "8 penukar karbohidrat"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Ayam tanpa kulit / ikan", "2 penukar hewani (Protein rendah lemak)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Daging", "1 penukar hewani (Protein lemak sedang)"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Tempe / Tahu / Kacang-kacangan", "5 penukar nabati"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur A", "Sekehandak"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Sayur B", "2 penukar sayuran"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Buah", "4 penukar buah"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Susu Tanpa Lemak", "1 penukar susu"));
        totalGiziMakanan.getListAcuanMakanaSehari().add(new TotalGiziMakanan.AcuanMakananSehari("Minyak", "7 penukar minyak"));
        listTotalGiziMakanan.add(totalGiziMakanan);
        
    }
}
