/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unittest;

import com.controller.BahanMakananController;
import com.model.BahanMakanan;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fahmi
 */
public class UnitTest1 {
    public static void main(String args[]) throws JRException{
         try {
            BahanMakananController bahanMakananController = new BahanMakananController();
//            BahanMakanan bahanMakanan = new BahanMakanan();
//            Golongan golongan = new Golongan();
//            golongan.setNamaGolongan("Buah-buahan dan Gula");
//            golongan.setTipeGolongan("Golongan V");
//            bahanMakanan.setGolongan(golongan);
//            bahanMakanan.setKalori(50.0);
//            bahanMakanan.setKarbohidrat(12.0);
//            bahanMakanan.setSatuanUrt("Buah Sedang");
//            bahanMakanan.setBeratSatuanUrt(125.0);
//            bahanMakanan.setSatuanPenukar(15.0);
//            bahanMakanan.setNamaBahanMakanan("Anggur");
//            bahanMakananController.createBahanMakanan(bahanMakanan);
            List<BahanMakanan> listBahanMakanan = bahanMakananController.getListBahanMakanan();
            InputStream streamRep = JRLoader.getFileInputStream("/home/fahmi/works/ireport-file/r_0.jasper");
            JRDataSource jRDataSource = new JRBeanCollectionDataSource(listBahanMakanan);
            Map<String, Object> map = new HashMap<>();
            map.put(JRParameter.REPORT_DATA_SOURCE, jRDataSource);
             JasperPrint report = JasperFillManager.fillReport(streamRep, map, jRDataSource);
             JasperViewer jv = new  JasperViewer(streamRep, false);
             jv.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(UnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
