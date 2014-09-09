/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unittest;

import com.model.MakananDiKonsumsiReport;
import com.model.ProfilUser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fahmi
 */
public class UnitTest2 {
    public static void main(String args[]) throws JRException{
        ArrayList<MakananDiKonsumsiReport> listMakananDiKonsumsiReports = new ArrayList<>();
        listMakananDiKonsumsiReports.add(new MakananDiKonsumsiReport("abc", "senin", 1.2, 1.3, 1.4));
        listMakananDiKonsumsiReports.add(new MakananDiKonsumsiReport("abc", "senin", 1.2, 1.3, 1.4));
        listMakananDiKonsumsiReports.add(new MakananDiKonsumsiReport("abc", "selasa", 1.2, 1.3, 1.4));
        listMakananDiKonsumsiReports.add(new MakananDiKonsumsiReport("abc", "selasa", 1.2, 1.3, 1.4));
        listMakananDiKonsumsiReports.add(new MakananDiKonsumsiReport("abc", "rabu", 1.2, 1.3, 1.4));
        listMakananDiKonsumsiReports.add(new MakananDiKonsumsiReport("abc", "rabu", 1.2, 1.3, 1.4));
        
        ProfilUser profilUser = new ProfilUser();
        profilUser.setNama("Fahmi");
        profilUser.setUmur(23);
        profilUser.setTinggiBadan(170.0);
        profilUser.setBeratBadan(70.0);
        profilUser.setJenisKelamin("Laki-laki");
        
        InputStream streamRep = JRLoader.getFileInputStream("gizi_report.jasper");
        JRBeanCollectionDataSource jRDataSource = new JRBeanCollectionDataSource(listMakananDiKonsumsiReports);
        Map<String, Object> map = new HashMap<>();
        
        map.put(JRParameter.REPORT_DATA_SOURCE, jRDataSource);
        map.put("PROFILE_USER", profilUser.toString());
        JasperPrint report = JasperFillManager.fillReport(streamRep, map, jRDataSource);
        JasperViewer jv = new JasperViewer(report);
        jv.setVisible(true);
    }
    
   
}
