/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.custom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author fahmi
 */
public class CusomJPanel extends JPanel{
    public CusomJPanel(LayoutManager layout) {
        super(layout);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        setBackground(Color.GREEN);
    }

    
    
    

    
}
