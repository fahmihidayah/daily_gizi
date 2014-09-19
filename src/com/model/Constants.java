/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.text.DecimalFormat;

/**
 *
 * @author fahmi
 */
public interface Constants {
    public static String databaseUrl = "jdbc:mysql://localhost:3306/db_gizi?user=root";
    public static int UPDATE_MODE = 0;
    public static int INSERT_MODE = 1;
    
    public static String KARBOHIDRAT = "Sumber Karbohidrat";
    public static String PROTEIN_HEWANI ="Sumber Protein Hewani";
    public static String PROTEIN_NABATI = "Sumber Protein Nabati";
    public static String SAYURAN = "Sayuran";
    public static String BUAH = "Buah-buahan dan Gula";
    public static String SUSU = "Susu";
    public static String MINYAK_LEMAK = "Minyak/Lemak";
    public static String MAKANAN_TANPA_KALORI = "Makanan Tanpa Kalori";
    
    public static DecimalFormat decimalFormat = new DecimalFormat("##.##");
    
}
