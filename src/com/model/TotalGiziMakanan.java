/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import static com.model.Constants.decimalFormat;
import java.util.ArrayList;

/**
 *
 * @author fahmi
 */
public class TotalGiziMakanan {

    private String namaDiet;
    private Double jenisEnergi = 0.0;
    private Double karbohidrat = 0.0;
    private Double proteinHewaniRendahLemak = 2.0;
    private Double proteinHewaniLemakSedang = 1.0;
    private Double nabati = 0.0;
    private String sayuranA = "S";
    private Double sayuranB = 2.0;
    private Double buah = 4.0;
    private Double susuTanpaLemak = 1.0;
    private Double minyak = 0.0;
    private Double totalEnergi = 0.0;
    private Double totalProtein = 0.0;
    private Double totalLemak = 0.0;
    private Double totalKarbohidrat = 0.0;
    private ArrayList<AcuanMakananSehari> listAcuanMakanaSehari = new ArrayList<>();
    private ArrayList<ContohMakananSehari> listContohMakananSehari = new ArrayList<>();

    public Double getJenisEnergi() {
        return jenisEnergi;
    }

    public void setJenisEnergi(Double jenisEnergi) {
        this.jenisEnergi = jenisEnergi;
    }

    public String getNamaDiet() {
        return namaDiet;
    }

    public void setNamaDiet(String namaDiet) {
        this.namaDiet = namaDiet;
    }

    public Double getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(Double karbohidrat) {
        this.karbohidrat = karbohidrat;
    }

    public Double getProteinHewaniRendahLemak() {
        return proteinHewaniRendahLemak;
    }

    public void setProteinHewaniRendahLemak(Double proteinHewaniRendahLemak) {
        this.proteinHewaniRendahLemak = proteinHewaniRendahLemak;
    }

    public Double getProteinHewaniLemakSedang() {
        return proteinHewaniLemakSedang;
    }

    public void setProteinHewaniLemakSedang(Double proteinHewaniLemakSedang) {
        this.proteinHewaniLemakSedang = proteinHewaniLemakSedang;
    }

    public Double getNabati() {
        return nabati;
    }

    public void setNabati(Double nabati) {
        this.nabati = nabati;
    }

    public String getSayuranA() {
        return sayuranA;
    }

    public void setSayuranA(String sayuranA) {
        this.sayuranA = sayuranA;
    }

    public Double getSayuranB() {
        return sayuranB;
    }

    public void setSayuranB(Double sayuranB) {
        this.sayuranB = sayuranB;
    }

    public Double getBuah() {
        return buah;
    }

    public void setBuah(Double buah) {
        this.buah = buah;
    }

    public Double getSusuTanpaLemak() {
        return susuTanpaLemak;
    }

    public void setSusuTanpaLemak(Double susuTanpaLemak) {
        this.susuTanpaLemak = susuTanpaLemak;
    }

    public Double getMinyak() {
        return minyak;
    }

    public void setMinyak(Double minyak) {
        this.minyak = minyak;
    }

    public Double getTotalEnergi() {
        return totalEnergi;
    }

    public void setTotalEnergi(Double totalEnergi) {
        this.totalEnergi = totalEnergi;
    }

    public Double getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(Double totalProtein) {
        this.totalProtein = totalProtein;
    }

    public Double getTotalLemak() {
        return totalLemak;
    }

    public void setTotalLemak(Double totalLemak) {
        this.totalLemak = totalLemak;
    }

    public Double getTotalKarbohidrat() {
        return totalKarbohidrat;
    }

    public void setTotalKarbohidrat(Double totalKarbohidrat) {
        this.totalKarbohidrat = totalKarbohidrat;
    }

    public ArrayList<AcuanMakananSehari> getListAcuanMakanaSehari() {
        return listAcuanMakanaSehari;
    }

    public void setListAcuanMakanaSehari(ArrayList<AcuanMakananSehari> listAcuanMakanaSehari) {
        this.listAcuanMakanaSehari = listAcuanMakanaSehari;
    }

    public ArrayList<ContohMakananSehari> getListContohMakananSehari() {
        return listContohMakananSehari;
    }

    public void setListContohMakananSehari(ArrayList<ContohMakananSehari> listContohMakananSehari) {
        this.listContohMakananSehari = listContohMakananSehari;
    }

    @Override
    public String toString() {
        String totalGizi = "Energi  : " + decimalFormat.format(getTotalEnergi()) + " Kal \n";
        totalGizi += "Protein : " + decimalFormat.format(getTotalProtein()) + " gr \n";
        totalGizi += "Lemak : " + decimalFormat.format(getTotalLemak()) + " gr \n";
        totalGizi += "Karbohidrat :" + decimalFormat.format(getTotalKarbohidrat()) + " gr \n";
        return totalGizi;
    }

    public static class AcuanMakananSehari {

        private String namaMakanan;
        private String satuanMakanan;

        public AcuanMakananSehari(String namaMakanan, String satuanMakanan) {
            this.namaMakanan = namaMakanan;
            this.satuanMakanan = satuanMakanan;
        }

        public String getNamaMakanan() {
            return namaMakanan;
        }

        public void setNamaMakanan(String namaMakanan) {
            this.namaMakanan = namaMakanan;
        }

        public String getSatuanMakanan() {
            return satuanMakanan;
        }

        public void setSatuanMakanan(String satuanMakanan) {
            this.satuanMakanan = satuanMakanan;
        }
    }

    public static class ContohMakananSehari {

        private String waktu;
        private Double berat;
        private Double urt;
        private String satuanUrt;
        private Double penukar;
        private String satuanPenukar;
        private String contohMenu;

        public String getWaktu() {
            return waktu;
        }

        public void setWaktu(String waktu) {
            this.waktu = waktu;
        }

        public Double getBerat() {
            return berat;
        }

        public void setBerat(Double berat) {
            this.berat = berat;
        }

        public Double getUrt() {
            return urt;
        }

        public void setUrt(Double urt) {
            this.urt = urt;
        }

        public String getSatuanUrt() {
            return satuanUrt;
        }

        public void setSatuanUrt(String satuanUrt) {
            this.satuanUrt = satuanUrt;
        }

        public Double getPenukar() {
            return penukar;
        }

        public void setPenukar(Double penukar) {
            this.penukar = penukar;
        }

        public String getSatuanPenukar() {
            return satuanPenukar;
        }

        public void setSatuanPenukar(String satuanPenukar) {
            this.satuanPenukar = satuanPenukar;
        }

        public String getContohMenu() {
            return contohMenu;
        }

        public void setContohMenu(String contohMenu) {
            this.contohMenu = contohMenu;
        }

        public ContohMakananSehari(String waktu, Double berat, Double urt, String satuanUrt, Double penukar, String satuanPenukar, String contohMenu) {
            this.waktu = waktu;
            this.berat = berat;
            this.urt = urt;
            this.satuanUrt = satuanUrt;
            this.penukar = penukar;
            this.satuanPenukar = satuanPenukar;
            this.contohMenu = contohMenu;
        }
    }
}
