/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unittest;

import com.controller.BahanMakananController;
import com.model.BahanMakanan;
import com.model.Golongan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fahmi
 */
public class UnitTest {
    public static void main(String args[]){
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
            System.out.println(listBahanMakanan.size());
            for (BahanMakanan bahanMakanan1 : listBahanMakanan) {
                System.out.println(bahanMakanan1.getNamaBahanMakanan() + bahanMakanan1.getGolongan().getNamaGolongan());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
