/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


/**
 *
 * @author fahmi
 */
public class PanelUtilities {
    
    public static JPanel getSpringPanel(){
        return new JPanel(new SpringLayout());
    }
    
    public static JPanel getBorderPanel(){
        return new JPanel(new BorderLayout());
    }
    
}
