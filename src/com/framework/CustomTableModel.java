/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author fahmi
 */
public abstract class CustomTableModel<E> implements  TableModel{

    private List<E> listData;
    private String columnName[];
    
    @Override
    public int getRowCount() {
        return listData.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnName[columnIndex].getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        E data = listData.get(rowIndex);
        return getDataItem(data, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        E data = listData.get(rowIndex);
        setDataItem(data, columnIndex);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    
    public abstract Object getDataItem(E data, int column);
    
    public void setDataItem(E data, int column){
        
    }

    public void setListData(List<E> listData) {
        this.listData = listData;
    }

    public void setColumnName(String[] columnName) {
        this.columnName = columnName;
    }
    
}
