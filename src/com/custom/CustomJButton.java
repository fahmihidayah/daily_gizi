/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.custom;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author fahmi
 */
public class CustomJButton extends  JButton{

    public CustomJButton(String text) {
        super(text);
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
    }
    
}
