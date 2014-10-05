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
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Bubur", 200.0, 1.0, "gelas" , 0.5, "karbohidrat", "bubur ayam"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Ayam tanpa Kulit", 40.0, 1.0, "potong sedang" , 1.0, "Protein hewani rendah lemak", "sup oyong + jamur"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Sayuran B", 0.0, 0.0, "sekehandak" , 0.0, "", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Buah", 110.0, 1.0, "potong besar" , 1.0, "buah", "pepaya"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Nasi", 100.0, 0.75 , "gelas" , 1.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Ikan", 40.0, 1.0 , "Potong sedang" , 1.0, "Hewani", "Pepes ikan"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Tempe", 50.0, 2.0 , "Potong sedang" , 1.0, "Nabati", "Oseng-oseng tempe"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Sayuran B", 100.0, 1.0 , "Gelas" , 1.0, "Sayuran", "Sayur asem"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Buah", 95.0, 1.0 , "Buah Sedang" , 1.0, "Buah", "Lalapan + sambel"));
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Buah", 50.0, 1.0 , "Buah" , 1.0, "Buah", "Pisang"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Nasi", 50.0, 0.5 , "Gelas" , 0.5, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Daging", 35.0, 1.0, "Potong sedang" , 1.0, "hewani", "Bistik daging"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Tahu", 110.0, 1.0 , "Biji besar" , 1.0, "Nabati", "Sup kacang merah"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Sayuran B", 100.0, 1.0 , "Gelas" , 1.0, "Sayuran", "Setup Wortel + buncis"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Buah ", 110.0, 1.0 , "Potong besar" , 1.0, "Buah", "Apel"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Minyak", 10.0, 2.0 , "Sendok teh" , 2.0, "Minyak", ""));
                
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
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Nasi", 100.0, 0.75, "gelas" , 0.5, "Karbohidrat", "nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Daging", 35.0, 1.0, "potong sedang" , 0.5, "hewani", "bistik jerman"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Sayutan B", 0.0, 1.0, "sekehendak" , 0.5, "minyak", "Sup tomat + jamur"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Minyak", 5.0, 1.0, "sendok teh" , 0.5, "buah", "Semangka"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Buah", 110.0, 0.75, "potong besar" , 0.5, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Nasi", 100.0, 1.0, "gelas" , 0.5, "hewani", "Ayam goreng tepung"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Ayam Tanpakulit", 40.0, 1.0, "potong sedang" , 0.5, "nabati", "sup kacang merah"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Kacang merah", 20.0, 2.0, "sendok makan" , 0.5, "sayuran", "tumis buncis + wortel"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Sayuran B", 100.0, 1.0, "gelas" , 0.5, "buah", "apel"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Buah", 85.0, 1.0, "buah" , 0.5, "minyak", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Minyak", 10.0, 2.0, "sendok teh" , 0.5, "buah", "Jus Jeruk"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Buah", 50.0, 1.0, "buah" , 0.5, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Nasi", 100.0, 0.75, "gelas" , 0.5, "hewani", "Ikan Panggang bumbu kecap"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Ikan", 40.0, 1.0, "potong sedang" , 0.5, "Karbohidrat", "bubur ayam"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Tahu", 110.0, 1.0, "biji besar" , 0.5, "nabati", "Pepes tahu"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Sayuran B", 100.0, 1.0, "gelas" , 0.5, "sayuran", "Cah caisim"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Buah", 110.0, 1.0, "potong sedang" , 0.5, "buah", "Pisang"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Minyak", 5.0, 1.0, "sendok teh" , 0.5, "minyak", ""));
        
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
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Nasi", 100.0, 0.75, "gelas" , 1.0, "Karbohidrat", "nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Telur ayam", 55.0, 1.0, "butis" , 1.0, "hewani", "omlet"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Kacang polong", 10.0,  1.0, "sendok makan" , 1.0, "nabati", "Sup kacang polong + jamur"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Sayuran A", 0.0, 1.0, "sekehandak" , 1.0, "", "salad tomat + ketimun"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Minyak", 5.0, 1.0, "sendok teh" , 1.0, "minyak", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Buah", 110.0, 1.0, "potong besar" , 1.0, "buah", "jeruk"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Nasi", 200.0,  1.0, "gelas" , 2.0, "kabohidrat", "nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Ikan", 40.0,  1.5, "potong sendang" , 1.0, "hewani", "ang sio hi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Tahu", 110.0,  1.0, "biji besar" , 1.0, "nabati", "sup tahu"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Sayuran B", 100.0,  1.0, "gelas" , 1.0, "sayuran", "cah sawi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Buah", 190.0,  1.0, "potong besar" , 1.0, "buah", "melon"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Minyak", 10.0,  2.0, "sendok teh" , 2.0, "minyak", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Buah", 50.0,  1.0, "buah" , 1.0, "buah", "pisang"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Nasi", 100.0, 0.75, "gelas" , 1.0, "Karbohidrat", "nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Ayam Tanpa Kulit", 40.0,  1.0, "potong sedang" , 1.0, "hewani", "ayam laksa"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Tahu", 110.0,  1.0, "biji besar" , 1.0, "nabati", "gadon tahu"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Sayuran B", 100.0,  1.0, "gelas" , 1.0, "sayuran", "sayur kimlo"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Buah", 110.0,  2.0, "buah" , 1.0, "buah", "jeruk"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Minyak", 5.0,  1.0, "sendok teh" ,1.0, "minyak", "nasi"));
        
        
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
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Nasi", 100.0, 0.75, "gelas" , 1.0, "Karbohidrat", "nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Daging", 35.0, 1.0, "potong sedang" , 1.0, "hewani", "daging gepuk"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Tahu", 55.0, 0.5, "biji besar" , 0.5, "Nabati", "tahu masak jamur"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Sayuran A", 0.0 ,0.0, "Sekehendak" , 0.0, "", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Minyak", 5.0, 1.0, "Sendok teh" , 1.0, "Minyak", "sup lobak tomat"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Buah", 90.0, 0.75, "Buah besar" , 1.0, "Buah", "jus mangga"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Ikan", 40.0, 1.0, "potong sedang" , 1.0, "Hewani", "rica-rica tengiri"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Tempe", 50.0, 2.0, "potong sedang" , 1.0, "Nabati", "tempe goreng"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Sayur B", 100.0, 1.0, "gelas" , 1.0, "Sayuran", "tumis kalian"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Buah", 110.0, 2.0, "buah" , 1.0, "Buah", "jeruk"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Minyak", 10.0, 2.0, "Sendok teh" , 2.0, "Minyak", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Buah", 50.0, 1.0, "buah" , 1.0, "Buah", "pisang"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Ayam Tanpa kulit", 40.0, 1.0, "potong sedang" , 1.0, "Hewani", "batok ayam"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Tahu", 110.0, 1.0, "biji besar" , 1.0, "Nabati", "pepes tahu"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Sayuran B", 100.0, 1.0, "gelas" , 1.0, "Sayuran", "sayur asem"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Buah", 110.0, 1.0, "potong besar" , 1.0, "Buah", "pepaya"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Minyak", 5.0, 1.0, "sendok teh" , 1.0, "Minyak", ""));
        
        
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
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Telur ayam", 55.0, 1.0, "butir" , 1.0, "hewani", "telur dadar"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Kacang tolo", 20.0, 2.0, "sendok makan" , 0.5, "nabati", "tumis kacang tolo"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Sayuan A", 0.0, 0.0, "sekehendak" , 0.0, "", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Minyak", 10.0, 2.0, "sendok teh" , 2.0, "minyak", "Sup labu kuning"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Buah", 70.0, 1.0, "potong sedang" , 1.0, "buah", "Jus blewahs"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Ikan", 40.0, 1.0, "potong sedang" , 1.0, "hewani", "Mangut ikan"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Tempe", 50.0, 2.0, "potong sedang" , 1.0, "nabati", "tempe mendoan"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Sayuran B", 100.0, 1.0, "gelas" , 1.0, "sayuran", "sayur asem"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Buah", 95.0, 0.25, "buah sedang" , 1.0, "buah", "nanas"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Minyak", 10.0, 2.0, "sendok teh" , 2.0, "minyak", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Buah", 165.0, 20.0, "buah sedang" , 1.0, "buah", "anggur"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Ayam tanpa kulit", 40.0, 1.0, "potong sedang" , 1.0, "hewani", "ayam goreng"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Tahu", 110.0, 1.0, "biji besar" , 1.0, "nabati", "tahu masak jamur"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Sayuran B", 100.0, 1.0, "gelas" , 1.0, "sayuran", "Tumis kembang kol"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Buah", 110.0, 1.0, "potong besar" , 1.0, "buah", "pepaya"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Minyak", 10.0, 2.0, "sendok teh" , 2.0, "minyak", ""));

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
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Nasi", 150.0, 1.0, "gelas" , 1.5, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Daging", 53.0, 1.0, "butir" , 1.0, "hewani", "Cah daging saos"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Tempe", 50.0, 2.0, "potong sedang" , 1.0, "nabati", "Tiram"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Sayur B", 50.0, 0.5, "gelas" , 0.5, "sayuran", "Tempe goreng tepung"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Minyak", 10.0, 2.0, "sendok teh" , 2.0, "minyak", "Oseng-oseng kacang pangjang + tauge"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Buah", 180.0, 1.0, "buah besar" , 1.0, "buah", "Semangka"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Ikan", 40.0, 1.0, "potong sedang" , 1.0, "hewani", "pepes ikan"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Tempe", 50.0, 2.0, "potong sedang" , 1.0, "nabati", "Tempe mendoan"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Sayuran B", 100.0, 1.0, "gelas" , 1.0, "sayuran", "Sayur lodeh"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Buah", 95.0, 0.25, "buah sedang" , 1.0, "buah", "Nenas"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Minyak", 15.0, 3.0, "sendok teh" , 2.0, "minyak", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Roti", 70.0, 3.0, "potong sedang" , 1.0, "Karbohidrat", "Roti putih"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Margarin", 5.0, 5.0, "gram" , 1.0, "minyak", "Margarin"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Buah", 0.5, 0.5, "gelas" , 1.0, "buah", "Jus sirsak"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Ayam tanpa kulit", 40.0, 1.0, "potong sedang" , 1.0, "hewani", "Opor ayam"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Tahu", 110.0, 1.0, "biji besar" , 1.0, "nabati", "Tahu bacem"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Sayuran B", 50.0, 0.5, "gelas" , 0.5, "sayuran", "Gudek"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Buah", 50.0, 1.0, "buah" , 1.0, "buah", "Pisang"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Minyak", 100.0, 2.0, "sendok teh" , 2.0, "minyak", ""));
        
        
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
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Telur ayam", 55.0, 1.0, "butir" , 1.0, "hewani", "Tahu scamble"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Kacang merah", 20.0, 2.0, "sendok makan" , 1.0, "nabati", "Sup kacang merah"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Sayur B", 50.0, 0.5, "gelas" , 0.5, "sayuran", "Setup buncis"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Minyak", 10.0, 2.0, "sendok teh" , 2.0, "minyak", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Krekers", 25.0, 2.0, "buah besar" , 0.5, "Karbohidrat", "krekers"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Buah", 110.0, 1.0, "potong besar" , 1.0, "buah", "pepaya"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Pagi", "Susu tanpa lemak", 20.0, 4.0, "sendok makan" , 1.0, "susu", "susu"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Ikan", 40.0, 1.0, "potong sedang" , 1.0, "hewani", "Sup bola-bola udang"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Tahu", 110.0, 1.0, "biji besar" , 1.0, "nabati", "perkedel tahu"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Sayur B", 100.0, 1.0, "gelas" , 1.0, "sayuran", "Cap cay sayur"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Buah", 95.0, 0.25, "buah sedang", 1.0 , "buah", "jeruk"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Siang", "Minyak", 15.0, 3.0, "sendok teh" ,1.5, "minyak", ""));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Roti", 35.0, 1.0, "potong sedang" , 1.0, "Karbohidrat", "Roti"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Margarin", 5.0, 1.0, "sendok teh" , 1.0, "Minyak", "Margin"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Snack Sore", "Buah Apel", 85.0, 1.0, "buah" , 1.0, "buah", "Jus apel"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Nasi", 200.0, 1.5, "gelas" , 2.0, "Karbohidrat", "Nasi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Ayam tanpa kulit", 40.0, 1.0, "potong sedang" , 1.0, "hewani", "Ayam goreng"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Tempe", 50.0, 2.0, "potong sedang" , 1.0, "nabati", "Tempe bacem"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Sayuran B", 50.0, 0.5, "gelas" , 0.5, "sayuran", "Cah sawi"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Buah", 85.0, 1.0, "buah" , 1.0, "buah", "Apel"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Malam", "Minyak", 10.0, 2.0, "sendok teh" , 2.0, "minyak", ""));
        
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
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Bubur", 200.0, 1.0, "gelas" , 0.5, "Karbohidrat", "bubur ayam"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Ayam tanpa Kulit", 40.0, 1.0, "potong sedang" , 1.0, "Protein hewani rendah lemak", "sup oyong + jamur"));
        listTotalGiziMakanan.add(totalGiziMakanan);
        
    }
}
