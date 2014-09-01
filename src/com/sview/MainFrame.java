/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
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

    public MainFrame()  {
        setTitle("Manajemen Gizi Harian Untuk Penderita Diabetes");
        setSize(800, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);
        setMainTabbedPane();
    }
    
    private void setMainTabbedPane(){
        mainTabbedPane = new JTabbedPane();
        ProfilePanel profilePanel = new ProfilePanel();
        
        mainTabbedPane.add("Profil Pengguna",   profilePanel);
        mainTabbedPane.add("Daftar Makanan" , new BahanMakananPanel());
        mainPanel.add(mainTabbedPane, BorderLayout.CENTER);
    }
    
    
}
