/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.ArrayList;

/**
 *
 * @author fahmi
 */
public class DataSingleton {
    protected static DataSingleton instance;
    private ProfilUser profilUser = new ProfilUser();
    private ArrayList<BahanMakanan> listBahanMakanan = new ArrayList<>();
    private ArrayList<Golongan> listGolongan = new ArrayList<>();
    private ArrayList<TotalGiziMakanan> listTotalGiziMakanan = new ArrayList<>();
    private TotalGiziMakanan totalGiziMakanan = null;
    
    public static DataSingleton getInstance(){
        if(instance == null){
            instance = new  DataSingleton();
        }
        return instance;
    }
    
    protected DataSingleton(){
        
    }

    public ArrayList<BahanMakanan> getListBahanMakanan() {
        return listBahanMakanan;
    }

    public ArrayList<Golongan> getListGolongan() {
        return listGolongan;
    }

    public void setListGolongan(ArrayList<Golongan> listGolongan) {
        this.listGolongan.clear();
        this.listGolongan.addAll(listGolongan);
    }

    
    public void setListBahanMakanan(ArrayList<BahanMakanan> listBahanMakanan) {
        this.listBahanMakanan.clear();
        this.listBahanMakanan.addAll(listBahanMakanan);
    }

    public ProfilUser getProfilUser() {
        return profilUser;
    }

    public void setProfilUser(ProfilUser profilUser) {
        this.profilUser = profilUser;
    }

    public ArrayList<TotalGiziMakanan> getListTotalGiziMakanan() {
        return listTotalGiziMakanan;
    }

    public void setListTotalGiziMakanan(ArrayList<TotalGiziMakanan> listTotalGiziMakanan) {
        this.listTotalGiziMakanan = listTotalGiziMakanan;
    }

    public TotalGiziMakanan getTotalGiziMakanan() {
        return totalGiziMakanan;
    }

    public void setTotalGiziMakanan(TotalGiziMakanan totalGiziMakanan) {
        this.totalGiziMakanan = totalGiziMakanan;
    }
    
}
