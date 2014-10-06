/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sview;

import com.controller.ProfileController;
import com.custom.CustomJButton;
import com.framework.PanelUtilities;
import com.model.ProfilUser;
import com.oracle_source.layout.SpringUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author fahmi
 */
public class EditProfileFrame extends JFrame {

    public JTextField textFieldNama, textFieldTinggiBadan, textFieldBeratBadan, textFieldUmur;
    public JComboBox<String> comboBoxJenisKelamin;
    public String[] jenisKelamin = {"Laki-Laki", "Perempuan"};
    private JButton buttonSave;
    private ProfileController profilController;

    private void initialComponent() {
        textFieldBeratBadan = new JTextField();
        textFieldNama = new JTextField();
        textFieldTinggiBadan = new JTextField();
        textFieldUmur = new JTextField();
        comboBoxJenisKelamin = new JComboBox<>(jenisKelamin);
        buttonSave = new CustomJButton("Simpan");
    }

    public EditProfileFrame(ProfileController profileController) {
        super("Edit Profile");
        this.profilController = profileController;
        setSize(300, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        initialComponent();
        getInputPanel();
        getContentPane().setBackground(Color.GREEN);
        add(getMainPanel());
    }

    private JPanel getMainPanel() {
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.GREEN);
        panel.add(getInputPanel(), BorderLayout.CENTER);
        panel.add(getButtonPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel getInputPanel() {
        JPanel panel = PanelUtilities.getSpringPanel();

        panel.add(new JLabel("Nama"));
        panel.add(textFieldNama);
        panel.add(new JLabel("Jenis Kelamin"));
        panel.add(comboBoxJenisKelamin);
        panel.add(new JLabel("Berat Badan"));
        panel.add(textFieldBeratBadan);
        panel.add(new JLabel("Tinggi Badan"));
        panel.add(textFieldTinggiBadan);
        panel.add(new JLabel("Umur"));
        panel.add(textFieldUmur);
        SpringUtilities.makeGrid(panel, 5, 2, 5, 5, 5, 5);
        return panel;
    }

    private JPanel getButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(buttonSave);
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    profilController.setProfileUserFromView(EditProfileFrame.this);
                }catch(Exception ex){
                    JOptionPane.showConfirmDialog(null, "Kesalahan input data", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        return panel;
    }
}
