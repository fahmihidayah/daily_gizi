/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author fahmi
 */
public class MakananDiKonsumsiReport {
    private String bahanMakanan;
    private String waktuMakan;
    private Double beratTotal;
    private Double kalori;
    private Double karbohidrat;
    private Double protein;
    private Double lemak;

    public MakananDiKonsumsiReport(String bahanMakanan, String waktuMakan, Double beratTotal, Double kalori, Double karbohidrat, Double lemak, Double protein) {
        this.bahanMakanan = bahanMakanan;
        this.waktuMakan = waktuMakan;
        this.beratTotal = beratTotal;
        this.kalori = kalori;
        this.karbohidrat = karbohidrat;
        this.protein = protein;
        this.lemak = lemak;
    }
    
    public MakananDiKonsumsiReport(MakananDiKonsumsi makananDiKonsumsi){
        this(makananDiKonsumsi.getBahanMakanan().getNamaBahanMakanan(), makananDiKonsumsi.getWaktuMakan(), makananDiKonsumsi.getBeratTotal(), makananDiKonsumsi.getKalori(), makananDiKonsumsi.getKarbohidrat(), makananDiKonsumsi.getLemak(), makananDiKonsumsi.getProtein());
    }
    public String getBahanMakanan() {
        return bahanMakanan;
    }

    public void setBahanMakanan(String bahanMakanan) {
        this.bahanMakanan = bahanMakanan;
    }

    public String getWaktuMakan() {
        return waktuMakan;
    }

    public void setWaktuMakan(String waktuMakan) {
        this.waktuMakan = waktuMakan;
    }

    public Double getBeratTotal() {
        return beratTotal;
    }

    public void setBeratTotal(Double beratTotal) {
        this.beratTotal = beratTotal;
    }

    public Double getKalori() {
        return kalori;
    }

    public void setKalori(Double kalori) {
        this.kalori = kalori;
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

    public Double getLemak() {
        return lemak;
    }

    public void setLemak(Double lemak) {
        this.lemak = lemak;
    }
    
    
    
}
