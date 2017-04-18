/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author infot
 */
public class ImprimirInforme extends JFrame {

    public void mostraInforme(String informe) throws FileNotFoundException {
        try {
            // RNB: Compilem en runtime. (fitxer.jrxml)
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("reports/" + informe));
            // RNB. Ja compilat (fitxer.jasper)
            //JasperReport informe = (JasperReport) JRLoader.loadObjectFromFile(getClass().getResource("informes/report1.jasper").toString());
            JasperPrint printer = JasperFillManager.fillReport(report, null, SQLHelper.getInstancia().getConnection());
            JRViewer visor = new JRViewer(printer);

            visor.setOpaque(true);
            visor.setVisible(true);

            this.add(visor);
            this.setSize(640, 480);

            this.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ImprimirInforme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
