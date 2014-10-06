/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.BahanMakananController;
import com.controller.MakanDikonsumsiController;
import com.controller.ProfileController;
import com.model.ProfilUser;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import static java.awt.image.ImageObserver.WIDTH;
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
    private MakanDikonsumsiController makanDikonsumsiController;
    private ProfileController profileController = new ProfileController();
 
    public MainFrame()  {
        setTitle("Manajemen Gizi Harian Untuk Penderita Diabetes");
        setSize(800, 500);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            bahanMakananController = new BahanMakananController();
            makanDikonsumsiController = new MakanDikonsumsiController(profileController.getProfilUser());
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.GREEN);
        add(mainPanel);
        setMainTabbedPane();
        setVisible(true);
    }
    
    private void setMainTabbedPane(){
        mainTabbedPane = new JTabbedPane();
        mainTabbedPane.setBackground(Color.GREEN);
        
        JPanel profilepanel = new ProfilePanel(profileController);
        mainTabbedPane.add("Profil Pengguna",  profilepanel);
        mainTabbedPane.add("Daftar Makanan" , new BahanMakananPanel(bahanMakananController));
        mainTabbedPane.add("Analisa Konsumsi Kalori Hari ini", new AnalisaKaloriPanel(bahanMakananController, makanDikonsumsiController, profileController));
        mainTabbedPane.setForegroundAt(0, Color.BLUE);
        mainTabbedPane.setForegroundAt(1, Color.BLUE);
        mainTabbedPane.setForegroundAt(2, Color.BLUE);
        mainPanel.add(mainTabbedPane, BorderLayout.CENTER);
    }
    
    
}
