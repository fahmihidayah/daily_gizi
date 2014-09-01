/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.j256.ormlite.dao.Dao;
import com.model.BahanMakanan;
import javax.swing.JFrame;

/**
 *
 * @author fahmi
 */
public class SimpanBahanMakananFrame extends JFrame{
    private Dao<BahanMakanan, Long> daobaBahanMakanans;

    public SimpanBahanMakananFrame(Dao<BahanMakanan, Long> daobaBahanMakanans) {
        super("Input Bahan Makanan");
        setSize(300, 400);
        
        this.daobaBahanMakanans = daobaBahanMakanans;
    }
    
    
    
}
