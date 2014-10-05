/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Objects;

/**
 *
 * @author fahmi
 */
@DatabaseTable(tableName = "MAKANAN_DIKONSUMSI")
public class MakananDiKonsumsi {

    @DatabaseField(generatedId = true, columnName = "ID_MAKANAN_DIKONSUMSI")
    private Long idMakananDikonsumsi;
    @DatabaseField(columnName = "BAHAN_MAKANAN", canBeNull = true, foreign = true)
    private BahanMakanan bahanMakanan;
    @DatabaseField(columnName = "JUMLAH")
    private Double jumlah;
    @DatabaseField(columnName = "WAKTU_MAKAN")
    private String waktuMakan;
    // kurang table informasi total nutrisi
    // kandungan nutrisi disamakan dengan kandungan nutrisi yang ada dibahan makanan
    
    @DatabaseField(columnName = "BERAT_TOTAL")
    private Double beratTotal = 0.0;
    @DatabaseField(columnName = "KARBOHIDRAT")
    private Double karbohidrat = 0.0;
    @DatabaseField(columnName = "PROTEIN")
    private Double protein = 0.0;
    @DatabaseField(columnName = "KALORI")
    private Double kalori = 0.0;
    @DatabaseField(columnName = "LEMAK")
    private Double lemak = 0.0;

    public Long getIdMakananDikonsumsi() {
        return idMakananDikonsumsi;
    }

    public void setIdMakananDikonsumsi(Long idMakananDikonsumsi) {
        this.idMakananDikonsumsi = idMakananDikonsumsi;
    }

    public BahanMakanan getBahanMakanan() {
        return bahanMakanan;
    }

    public void setBahanMakanan(BahanMakanan bahanMakanan) {
        this.bahanMakanan = bahanMakanan;
    }

    public Double getJumlah() {
        return jumlah;
    }

    /**
     * modifed method. ditambah hitung total kandungan gizi
     * @param jumlah 
     */
    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
        this.hitungTotalKandunganGizi();
    }

    public String getWaktuMakan() {
        return waktuMakan;
    }

    public void setWaktuMakan(String waktuMakan) {
        this.waktuMakan = waktuMakan;
    }

    public Double getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(Double karbohidrat) {
        this.karbohidrat = karbohidrat;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getKalori() {
        return kalori;
    }

    public void setKalori(Double kalori) {
        this.kalori = kalori;
    }

    public Double getLemak() {
        return lemak;
    }

    public void setLemak(Double lemak) {
        this.lemak = lemak;
    }

    public Double getBeratTotal() {
        return beratTotal;
    }

    public void setBeratTotal(Double beratTotal) {
        this.beratTotal = beratTotal;
    }
    

    /**
     * helper method untuk menghitung total kandungan gizi
     */
    public void hitungTotalKandunganGizi(){
         this.karbohidrat = hitungKandungan(bahanMakanan.getKarbohidrat());
         this.protein = hitungKandungan(bahanMakanan.getProtein());
         this.lemak = hitungKandungan(bahanMakanan.getLemak());
         this.kalori = hitungKandungan(bahanMakanan.getKalori());
         this.beratTotal = hitungKandungan(bahanMakanan.getBeratSatuanUrt());
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idMakananDikonsumsi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MakananDiKonsumsi other = (MakananDiKonsumsi) obj;
        if (!Objects.equals(this.idMakananDikonsumsi, other.idMakananDikonsumsi)) {
            return false;
        }
        return true;
    }
    /**
     * helper method untuk menghitung kandungan gizi. 
     * Rumusnya : 
     * 
     * kandungan gizi x jumlah
     * -----------------------
     * satuan penukar
     * @param kandungan
     * @return 
     */
    private Double hitungKandungan(Double kandungan){
        
        return  kandungan * this.jumlah / ((this.bahanMakanan.getSatuanPenukar() == 0)? 1: this.bahanMakanan.getSatuanPenukar());
    }
}
