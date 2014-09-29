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
public class ProfilUser  implements Serializable{

    private String nama;
    private String jenisKelamin;
    private Double tinggiBadan;
    private Double beratBadan;
    private Integer umur;
    // hitung attribute
    private Double beratBadanRelative;
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

    public void hitungBeratBadanRelative(){
        this.beratBadanRelative = this.beratBadan / (this.tinggiBadan - 100) * 100;
        identifikasiKlasifikasiGizi();
        hitungKaloriHarian();
    }
    
    public void hitungBMI() {
        this.bmi = this.beratBadan / Math.pow(this.tinggiBadan, this.tinggiBadan);
//        this.identifikasiKlasifikas();
    }

//    private void identifikasiKlasifikas() {
//        if (this.bmi < 18.5) {
//            this.klasifikasi = "berat badan kurang";
//        } else if (this.bmi >= 18.5 && this.bmi <= 24) {
//            this.klasifikasi = "berat badan normal";
//        } else if (this.bmi >= 25 && this.bmi <= 29) {
//            this.klasifikasi = "kelebihan berat badan";
//        } else if (this.bmi > 30) {
//            this.klasifikasi = "obesitas";
//        }
//    }
    
    private void identifikasiKlasifikasiGizi(){
        if(this.beratBadanRelative < 90){
            this.klasifikasi = "Kurus (Underweight)";
        }
        else if(this.beratBadanRelative >= 90 && this.beratBadanRelative <= 110){
            this.klasifikasi = "Normal (Ideal)";
        }
        else if(this.beratBadanRelative <= 120){
            this.klasifikasi = "Gemuk (Overweight)";
        }
        else if(this.beratBadanRelative >= 120 && this.beratBadanRelative <= 130){
            this.klasifikasi = "Obesitas Ringan";
        }
        else if(this.beratBadanRelative > 130 && this.beratBadanRelative <= 140){
            this.klasifikasi = "Obesitas Sedang";
        }
        else if(this.beratBadanRelative > 140){
            this.klasifikasi = "Obesitas Berat";
        }
        else {
            this.klasifikasi = "Tidak ada ," + beratBadanRelative;
        }
        
    }

    private void hitungKaloriHarian(){
       if(this.klasifikasi.equalsIgnoreCase("Kurus (Underweight)")){
           this.kaloriHarian = this.beratBadan * 40;
       }
       else if(this.klasifikasi.equalsIgnoreCase("Normal (Ideal)")){
            this.kaloriHarian = this.beratBadan * 30;
       }
       else if(this.klasifikasi.equalsIgnoreCase("Gemuk (Overweight)")){
            this.kaloriHarian = this.beratBadan * 20;
       }
       else {
            this.kaloriHarian = this.beratBadan * 10;
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

    @Override
    public String toString() {
        String returnValue = "";
        returnValue += "Nama : " + this.nama + "\n";
        returnValue += "Umur : " + this.umur + " tahun\n";
        returnValue += "Berat Badan : " + this.beratBadan + " kg\n";
        returnValue += "Tinggi Badan : " + this.tinggiBadan + " cm\n";
        returnValue += "Jenis Kelamin : " + this.jenisKelamin + "\n";
        return returnValue;
        
    }
    
}
