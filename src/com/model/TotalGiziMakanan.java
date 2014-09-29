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
    private ArrayList<AcuanMakananSehari> listAcuanMakanaSehari = new ArrayList<>();
    private ArrayList<ContohMakananSehari> listContohMakananSehari = new ArrayList<>();

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
        String totalGizi = "Energi  : " + decimalFormat.format(getTotalEnergi()) +" Kal \n";
        totalGizi += "Protein : " +decimalFormat.format(getTotalProtein()) + " gr \n";
        totalGizi += "Lemak : " + decimalFormat.format(getTotalLemak()) + " gr \n";
        totalGizi += "Karbohidrat :" + decimalFormat.format(getTotalKarbohidrat()) + " gr \n";
        return totalGizi;
    }
    
    
    public static class AcuanMakananSehari{
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
    
    public static class ContohMakananSehari{
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
