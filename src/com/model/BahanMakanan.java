/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fahmi
 */
@DatabaseTable(tableName = "BAHAN_MAKANAN")
public class BahanMakanan implements Serializable{

    @DatabaseField(generatedId = true, columnName = "ID_BAHAN_MAKANAN")
    private Long idBahanMakanan;
    @DatabaseField(columnName = "NAMA_BAHAN_MAKANAN")
    private String namaBahanMakanan;
    @DatabaseField(columnName = "SATUAN_URT")
    private String satuanUrt;
    @DatabaseField(columnName = "SATUAN_PENUKAR")
    private Double satuanPenukar;
    @DatabaseField(columnName = "BERAT_SATUAN_URT")
    private Double beratSatuanUrt;
    @DatabaseField(columnName = "ID_GOLOGAN", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Golongan golongan;
    // kurang kandungan nutrisi,
    // field kandungan nutrisi disamakan dengan kandugnan nutrisi pada makanan yang dikonsumsi
    @DatabaseField(columnName = "KARBOHIDRAT")
    private Double karbohidrat = 0.0;
    @DatabaseField(columnName = "PROTEIN")
    private Double protein = 0.0;
    @DatabaseField(columnName = "KALORI")
    private Double kalori = 0.0;
    @DatabaseField(columnName = "LEMAK")
    private Double lemak = 0.0;

    public Long getIdBahanMakanan() {
        return idBahanMakanan;
    }

    public void setIdBahanMakanan(Long idBahanMakanan) {
        this.idBahanMakanan = idBahanMakanan;
    }

    public String getNamaBahanMakanan() {
        return namaBahanMakanan;
    }

    public void setNamaBahanMakanan(String namaBahanMakanan) {
        this.namaBahanMakanan = namaBahanMakanan;
    }

    public String getSatuanUrt() {
        return satuanUrt;
    }

    public void setSatuanUrt(String satuanUrt) {
        this.satuanUrt = satuanUrt;
    }

    public Double getSatuanPenukar() {
        return satuanPenukar;
    }

    public void setSatuanPenukar(Double satuanPenukar) {
        this.satuanPenukar = satuanPenukar;
    }

    public Double getBeratSatuanUrt() {
        return beratSatuanUrt;
    }

    public void setBeratSatuanUrt(Double beratSatuanUrt) {
        this.beratSatuanUrt = beratSatuanUrt;
    }

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.idBahanMakanan);
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
        final BahanMakanan other = (BahanMakanan) obj;
        if (!Objects.equals(this.idBahanMakanan, other.idBahanMakanan)) {
            return false;
        }
        return true;
    }
}
