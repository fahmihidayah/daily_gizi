/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.BahanMakananController;
import com.framework.CustomTableModel;
import com.framework.PanelUtilities;
import com.model.BahanMakanan;
import com.model.Constants;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author fahmi
 */
public class BahanMakananPanel extends JPanel implements Constants, Observer {

    private JTextField textFieldCari;
    private JComboBox<String> comboBoxKategori;
    private JTable tableBahanMakanan = new JTable();
    private CustomTableModel<BahanMakanan> customTableModel;
    private BahanMakananController bahanMakananController;
//    private int selectedIndex = 0;
    private Long id = null;
    private String kategori[] = {"Id Makanan", "Nama Makanan", "Satuan Urt", "Satuan Penukar", "Berat Satuan Urt", "Golongan", "Karbohidrat", "Protein", "Kalori", "Lemak"};

    public BahanMakananPanel(BahanMakananController bahanMakananController) {
        super(new BorderLayout());
        this.bahanMakananController = bahanMakananController;
        add(getCariPanel(), BorderLayout.NORTH);
        add(getTableMakananPanel(), BorderLayout.CENTER);
        add(getButtonPanel(), BorderLayout.SOUTH);
        bahanMakananController.addObserver(this);
    }

    private JPanel getCariPanel() {
        JPanel panel = PanelUtilities.getSpringPanel();
        textFieldCari = new JTextField();
        textFieldCari.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                customTableModel.filter(textFieldCari.getText(), comboBoxKategori.getSelectedIndex());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                customTableModel.filter(textFieldCari.getText(), comboBoxKategori.getSelectedIndex());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                customTableModel.filter(textFieldCari.getText(), comboBoxKategori.getSelectedIndex());
            }
        });

        comboBoxKategori = new JComboBox<>(kategori);
        panel.add(new JLabel("Kategori"));
        panel.add(comboBoxKategori);
        panel.add(new JLabel("Cari"));
        panel.add(textFieldCari);
        SpringUtilities.makeGrid(panel, 2, 2, 5, 5, 5, 5);
        return panel;
    }

    private JPanel getTableMakananPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        customTableModel = new CustomTableModel<BahanMakanan>() {
            @Override
            public Object getDataItem(BahanMakanan data, int column) {
                if (column == 0) {
                    return data.getIdBahanMakanan();
                } else if (column == 1) {
                    return data.getNamaBahanMakanan();
                } else if (column == 2) {
                    return data.getSatuanUrt();
                } else if (column == 3) {
                    return data.getSatuanPenukar();
                } else if (column == 4) {
                    return data.getBeratSatuanUrt();
                } else if (column == 5) {
                    return data.getGolongan().getNamaGolongan();
                } else if (column == 6) {
                    return data.getKarbohidrat();
                } else if (column == 7) {
                    return data.getProtein();
                } else if (column == 8) {
                    return data.getKalori();
                } else {
                    return data.getLemak();
                }
            }
        };
        String columnName[] = kategori;
        customTableModel.setColumnName(columnName);
        customTableModel.setListData(bahanMakananController.getListBahanMakanan());
        tableBahanMakanan = new JTable(customTableModel);
        customTableModel.createRowSorter(tableBahanMakanan);
        tableBahanMakanan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                Point p = e.getPoint();
                int selectedIndex = table.rowAtPoint(p);
                id = (Long) table.getValueAt(selectedIndex, 0);
                if (e.getClickCount() == 2) {

//                    JOptionPane.showConfirmDialog(null, "id is " + id, "Pesan", JOptionPane.OK_OPTION);
                    SimpanBahanMakananFrame simpanBahanMakananFrame = new SimpanBahanMakananFrame(bahanMakananController, UPDATE_MODE, (Long) id);
                }
            }
        });

        JScrollPane jScrollPane = new JScrollPane(tableBahanMakanan);
        panel.add(jScrollPane);
        return panel;
    }

    private JPanel getButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton buttonAdd = new JButton("Tambah");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpanBahanMakananFrame bahanMakananFrame = new SimpanBahanMakananFrame(bahanMakananController, INSERT_MODE, null);
            }
        });
//        JButton buttonEdit = new JButton("Ubah");
//        buttonEdit.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//            }
//        });
        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id == null) {
                    JOptionPane.showConfirmDialog(null, "Anda belum memilih data", "Pesan", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data ini?", "Pesan", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    bahanMakananController.deleteBahanMakananById(id);
                    id = null;
                }
            }
        });
        panel.add(buttonAdd);
//        panel.add(buttonEdit);
        panel.add(buttonHapus);
        return panel;
    }

    @Override
    public void update(Observable o, Object arg) {
//         customTableModel.fireTableDataChanged();
        customTableModel.filter("", 0);
    }
}
