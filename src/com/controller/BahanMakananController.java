/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.model.BahanMakanan;
import com.model.Constants;
import com.model.Golongan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fahmi
 */
public class BahanMakananController implements Constants {

    private JdbcConnectionSource jdbcConnectionSource;
    private Dao<BahanMakanan, Long> daoBahanMakanan;
    private Dao<Golongan, Long> daoGolongan;
    private List<BahanMakanan> listBahanMakanan = new ArrayList<>();
    private List<Golongan> listGolongan = new ArrayList<>();
    
    public BahanMakananController() throws SQLException {
        jdbcConnectionSource = new JdbcConnectionSource(databaseUrl);
        daoBahanMakanan = DaoManager.createDao(jdbcConnectionSource, BahanMakanan.class);
        daoGolongan = DaoManager.createDao(jdbcConnectionSource, Golongan.class);
        TableUtils.createTableIfNotExists(jdbcConnectionSource, Golongan.class);
        TableUtils.createTableIfNotExists(jdbcConnectionSource, BahanMakanan.class);
        copyListGolongan();
        copyListBahanMakanan();
    }

    public void createBahanMakanan(BahanMakanan bahanMakanan) {
        try {
            daoBahanMakanan.create(bahanMakanan);
            copyListBahanMakanan();
        } catch (SQLException ex) {
            Logger.getLogger(BahanMakananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editBahanMakanan(BahanMakanan bahanMakanan) {
        try {
            daoBahanMakanan.update(bahanMakanan);
            copyListBahanMakanan();
        } catch (SQLException ex) {
            Logger.getLogger(BahanMakananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<BahanMakanan> readListBahanMakanan() throws SQLException {
        return daoBahanMakanan.queryForAll();
    }

    public void deleteBahanMakananById(Long id) {
        try {
            daoBahanMakanan.deleteById(id);
            copyListBahanMakanan();
        } catch (SQLException ex) {
            Logger.getLogger(BahanMakananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<BahanMakanan> getListBahanMakanan() {
        return listBahanMakanan;
    }

    public void setListBahanMakanan(List<BahanMakanan> listBahanMakanan) {
        this.listBahanMakanan = listBahanMakanan;
    }
    
    public void copyListBahanMakanan() throws SQLException{
        List<BahanMakanan> listBahanMakananTemp = readListBahanMakanan();
        this.listBahanMakanan.clear();
        this.listBahanMakanan.addAll(listBahanMakananTemp);
    }
    
    public void copyListGolongan() throws SQLException {
        List<Golongan> listGolongan = daoGolongan.queryForAll();
        this.listGolongan.clear();
        this.listGolongan.addAll(listGolongan);
    }

    public List<Golongan> getListGolongan() {
        return listGolongan;
    }

    public void setListGolongan(List<Golongan> listGolongan) {
        this.listGolongan = listGolongan;
    }
    
    
}
