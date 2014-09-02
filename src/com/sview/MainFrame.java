/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.BahanMakananController;
import com.model.ProfilUser;
import com.oracle_source.layout.SpringUtilities;
import com.view.ProfilPanel;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author fahmi
 */
public class MainFrame extends JFrame{
    private JTabbedPane mainTabbedPane;
    private JPanel mainPanel;
    
    private BahanMakananController bahanMakananController;
    private ProfilUser profilUser;

    public MainFrame()  {
        setTitle("Manajemen Gizi Harian Untuk Penderita Diabetes");
        setSize(800, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            bahanMakananController = new BahanMakananController();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);
        
        setMainTabbedPane();
    }
    
    private void setMainTabbedPane(){
        mainTabbedPane = new JTabbedPane();
        
        
        mainTabbedPane.add("Profil Pengguna",  new ProfilePanel(profilUser));
        mainTabbedPane.add("Daftar Makanan" , new BahanMakananPanel(bahanMakananController));
        mainTabbedPane.add("Analisa Konsumsi Kalori Hari ini", new JPanel());
        mainPanel.add(mainTabbedPane, BorderLayout.CENTER);
    }
    
    
}
