/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unittest;

import com.framework.JasperReportHandler;
import com.model.TotalGiziMakanan;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author fahmi
 */
public class UnitTest4 {
    public static void main(String args[]) throws JRException{
        ArrayList<TotalGiziMakanan> listTotalGiziMakanan = new ArrayList<>();
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
        
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Bubur", 200.0, 1.0, "gelas" , 0.5, "Karbohidrat", "bubur ayam"));
        totalGiziMakanan.getListContohMakananSehari().add(new TotalGiziMakanan.ContohMakananSehari("Pagi", "Ayam tanpa Kulit", 40.0, 1.0, "potong sedang" , 1.0, "Protein hewani rendah lemak", "sup oyong + jamur"));
        
        listTotalGiziMakanan.add(totalGiziMakanan);
        
        JasperReportHandler jasperReportHandler = new JasperReportHandler("gizi_standar_dm.jasper", listTotalGiziMakanan.get(0).getListContohMakananSehari());
        jasperReportHandler.putParameter("NAMA_DIET", "ASD");
        jasperReportHandler.putParameter("KANDUNGAN_GIZI", "ASD");
        jasperReportHandler.putParameter("TOTAL_BAHAN_MAKANAN", "ASD");
        jasperReportHandler.showReport();
    }
}
