/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;
import static com.model.Constants.decimalFormat;
/**
 *
 * @author fahmi
 */
public class TotalGiziMakanan {
    private String namaDiet;
    private Double totalKarbohidratAtauNasi = 0.0;
    private Double totalHewaniRendahLemak= 0.0;
    private Double totalHewaniLemakSedang= 0.0;
    private Double totalSayuranB= 0.0;
    private Double totalBuah= 0.0;
    private Double totalMadu= 0.0;
    private Double totalSantanAtauMinyak= 0.0;
    private Double totalKueRp= 0.0;
    private Double totalEnergi= 0.0;
    private Double totalProtein= 0.0;
    private Double totalLemak= 0.0;
    private Double totalKarbohidrat= 0.0;

    public String getNamaDiet() {
        return namaDiet;
    }

    public void setNamaDiet(String namaDiet) {
        this.namaDiet = namaDiet;
    }

    public Double getTotalKarbohidratAtauNasi() {
        return totalKarbohidratAtauNasi;
    }

    public void setTotalKarbohidratAtauNasi(Double totalKarbohidratAtauNasi) {
        this.totalKarbohidratAtauNasi = totalKarbohidratAtauNasi;
    }

    public Double getTotalHewaniRendahLemak() {
        return totalHewaniRendahLemak;
    }

    public void setTotalHewaniRendahLemak(Double totalHewaniRendahLemak) {
        this.totalHewaniRendahLemak = totalHewaniRendahLemak;
    }

    public Double getTotalHewaniLemakSedang() {
        return totalHewaniLemakSedang;
    }

    public void setTotalHewaniLemakSedang(Double totalHewaniLemakSedang) {
        this.totalHewaniLemakSedang = totalHewaniLemakSedang;
    }

    public Double getTotalSayuranB() {
        return totalSayuranB;
    }

    public void setTotalSayuranB(Double totalSayuranB) {
        this.totalSayuranB = totalSayuranB;
    }

    public Double getTotalBuah() {
        return totalBuah;
    }

    public void setTotalBuah(Double totalBuah) {
        this.totalBuah = totalBuah;
    }

    public Double getTotalMadu() {
        return totalMadu;
    }

    public void setTotalMadu(Double totalMadu) {
        this.totalMadu = totalMadu;
    }

    public Double getTotalSantanAtauMinyak() {
        return totalSantanAtauMinyak;
    }

    public void setTotalSantanAtauMinyak(Double totalSantanAtauMinyak) {
        this.totalSantanAtauMinyak = totalSantanAtauMinyak;
    }

    public Double getTotalKueRp() {
        return totalKueRp;
    }

    public void setTotalKueRp(Double totalKueRp) {
        this.totalKueRp = totalKueRp;
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

    @Override
    public String toString() {
        String totalGizi = "Energi  : " + decimalFormat.format(getTotalEnergi()) +" Kal \n";
        totalGizi += "Protein : " +decimalFormat.format(getTotalProtein()) + " gr \n";
        totalGizi += "Lemak : " + decimalFormat.format(getTotalLemak()) + " gr \n";
        totalGizi += "Karbohidrat :" + decimalFormat.format(getTotalKarbohidrat()) + " gr \n";
        return totalGizi;
    }
    
}
