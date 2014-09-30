/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fahmi
 */
public class JasperReportHandler {

    private String jasperFile;
    private Map<String, Object> dataJasper = new HashMap<>();
    private JRBeanCollectionDataSource jrbcds;

    public JasperReportHandler(String jasperFile, ArrayList listData) {
        this.jasperFile = jasperFile;
        putReportDataSource(listData);
    }

    private void putReportDataSource(ArrayList listData) {
        jrbcds = new JRBeanCollectionDataSource(listData);
        dataJasper.put(JRParameter.REPORT_DATA_SOURCE, jrbcds);
    }

    public void putParameter(String key, String parameter) {
        dataJasper.put(key, parameter);
    }
    
    public void putParameter(String key, Double parameter) {
        dataJasper.put(key, parameter);
    }

    public void showReport() throws JRException {
        if (jasperFile != null) {
            InputStream streamRep = JRLoader.getFileInputStream(jasperFile);
            JasperPrint report = JasperFillManager.fillReport(streamRep, dataJasper, jrbcds);
            JasperViewer jv = new JasperViewer(report);
            jv.setVisible(true);
        }
    }

    public JasperPrint getJasperPrint() throws JRException {
        InputStream streamRep = JRLoader.getFileInputStream(jasperFile);
        JasperPrint report = JasperFillManager.fillReport(streamRep, dataJasper, jrbcds);
        return report;
    }

    public void margeJasperPrint(JasperReportHandler reportHandler, int page){
        
        try {
            JasperPrint jp = getJasperPrint();
            jp.addPage(reportHandler.getJasperPrint().getPages().get(page));
            JasperViewer jv = new JasperViewer(jp, false);
                
        jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(JasperReportHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
