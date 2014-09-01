/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.model.BahanMakanan;
import static com.model.Constants.databaseUrl;
import com.model.Golongan;
import com.model.MakananDiKonsumsi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fahmi
 */
public class MakanDikonsumsiController {
    private JdbcConnectionSource jdbcConnectionSource;
    private Dao<BahanMakanan, Long> daoBahanMakanan;
    private List<BahanMakanan> listBahanMakanan;
    
    private ArrayList<MakananDiKonsumsi> listMakananDikonsumsi = new ArrayList<>();
    
    public MakanDikonsumsiController() throws SQLException {
        jdbcConnectionSource = new JdbcConnectionSource(databaseUrl);
        daoBahanMakanan = DaoManager.createDao(jdbcConnectionSource, BahanMakanan.class);
        TableUtils.createTableIfNotExists(jdbcConnectionSource, Golongan.class);
        TableUtils.createTableIfNotExists(jdbcConnectionSource, BahanMakanan.class);
        getListBahanMakananFromDb();
    }

    public List<BahanMakanan> getListBahanMakanan() {
        return listBahanMakanan;
    }

    public void setListBahanMakanan(List<BahanMakanan> listBahanMakanan) {
        this.listBahanMakanan = listBahanMakanan;
    }
    
    public void getListBahanMakananFromDb() throws SQLException{
        this.listBahanMakanan = daoBahanMakanan.queryForAll();
    }

    public ArrayList<MakananDiKonsumsi> getListMakananDikonsumsi() {
        return listMakananDikonsumsi;
    }

    public void setListMakananDikonsumsi(ArrayList<MakananDiKonsumsi> listMakananDikonsumsi) {
        this.listMakananDikonsumsi = listMakananDikonsumsi;
    }
    
    
}
