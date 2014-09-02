/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Observable;

/**
 *
 * @author fahmi
 * 
 */
public class ProfilUser extends Observable implements Serializable{

    private String nama;
    private String jenisKelamin;
    private Double tinggiBadan;
    private Double beratBadan;
    private Integer umur;
    // hitung attribute
    private String tingkatAktifitas;
    private Double beratBadanIdeal;
    private Double bmi;
    private Double kaloriHarian;
    private String klasifikasi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Double getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(Double tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public Double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(Double beratBadan) {
        this.beratBadan = beratBadan;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Double getBeratBadanIdeal() {
        return beratBadanIdeal;
    }

    public void setBeratBadanIdeal(Double beratBadanIdeal) {
        this.beratBadanIdeal = beratBadanIdeal;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getKaloriHarian() {
        return kaloriHarian;
    }

    public void setKaloriHarian(Double kaloriHarian) {
        this.kaloriHarian = kaloriHarian;
    }

    public String getKlasifikasi() {
        return klasifikasi;
    }

    public void setKlasifikasi(String klasifikasi) {
        this.klasifikasi = klasifikasi;
    }

    public String getTingkatAktifitas() {
        return tingkatAktifitas;
    }

    public void setTingkatAktifitas(String tingkatAktifitas) {
        this.tingkatAktifitas = tingkatAktifitas;
    }

    public void hitungBeratBadanIdeal() {
        if (jenisKelamin.equalsIgnoreCase("laki-laki")) {
            this.beratBadanIdeal = (this.tinggiBadan - 100) - ((10 * this.tinggiBadan / 100) - 100);
        } else {
            this.beratBadanIdeal = (this.tinggiBadan - 100) - ((15 * this.tinggiBadan / 100) - 100);
        }
    }

    public void hitungBMI() {
        this.bmi = this.beratBadan / Math.pow(this.tinggiBadan, this.tinggiBadan);
        this.identifikasiKlasifikas();
    }

    private void identifikasiKlasifikas() {
        if (this.bmi < 18.5) {
            this.klasifikasi = "berat badan kurang";
        } else if (this.bmi >= 18.5 && this.bmi <= 24) {
            this.klasifikasi = "berat badan normal";
        } else if (this.bmi >= 25 && this.bmi <= 29) {
            this.klasifikasi = "kelebihan berat badan";
        } else if (this.bmi > 30) {
            this.klasifikasi = "obesitas";
        }
    }

    public void hitungKebutuhanKaloriHarian() {
        double kebutuhanKaloriHarian;
        if (jenisKelamin.equalsIgnoreCase("perempuan")) {
            kebutuhanKaloriHarian = 655 + (9.6 * beratBadanIdeal) + (1.8 * tinggiBadan) - (4.7 * umur);
            if (tingkatAktifitas.equalsIgnoreCase("ringan")) {
                kebutuhanKaloriHarian *= 1.55;
            } else if (tingkatAktifitas.equalsIgnoreCase("sedang")) {
                kebutuhanKaloriHarian *= 1.70;
            } else {
                kebutuhanKaloriHarian *= 2;
            }
        } else {
            kebutuhanKaloriHarian = 66.5 + (13.7 * beratBadanIdeal) + (5 * tinggiBadan) - (6.8 * umur);
            if (tingkatAktifitas.equalsIgnoreCase("ringan")) {
                kebutuhanKaloriHarian *= 1.56;
            } else if (tingkatAktifitas.equalsIgnoreCase("sedang")) {
                kebutuhanKaloriHarian *= 1.76;
            } else {
                kebutuhanKaloriHarian *= 2.1;
            }
        }
        setKaloriHarian(kaloriHarian);
    }
    
    public void notifyAllObserver(){
        setChanged();
        notifyObservers();
    }
}
