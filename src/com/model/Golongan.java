/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Objects;

/**
 *
 * @author fahmi
 */
@DatabaseTable(tableName = "GOLONGAN")
public class Golongan {
    @DatabaseField(generatedId = true, columnName = "ID_GOLONGAN", allowGeneratedIdInsert = true)
    private Long idGolongan;
    @DatabaseField(columnName = "TIPE_GOLONGAN")
    private String tipeGolongan;
    @DatabaseField(columnName = "NAMA_GOLONGAN")
    private String namaGolongan;

    public Long getIdGolongan() {
        return idGolongan;
    }

    public void setIdGolongan(Long idGolongan) {
        this.idGolongan = idGolongan;
    }

    public String getTipeGolongan() {
        return tipeGolongan;
    }

    public void setTipeGolongan(String tipeGolongan) {
        this.tipeGolongan = tipeGolongan;
    }

    public String getNamaGolongan() {
        return namaGolongan;
    }

    public void setNamaGolongan(String namaGolongan) {
        this.namaGolongan = namaGolongan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idGolongan);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Golongan other = (Golongan) obj;
        if (!Objects.equals(this.idGolongan, other.idGolongan)) {
            return false;
        }
        return true;
    }
    
    
}
