package control_examenuf1_rsudario;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

public class ImprimirInforme extends JFrame {

    public void mostraInforme(String informe) {
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
            this.setSize(1200, 660);
            // El setLocationRelativeTo permet posar el JFrame en el centre directament
            this.setLocationRelativeTo(null);

            this.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ImprimirInforme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostraInforme(String informe, Map parametres) {
        try {
            // RNB: Compilem en runtime. (fitxer.jrxml)
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("reports/" + informe));
            // RNB. Ja compilat (fitxer.jasper)
            //JasperReport informe = (JasperReport) JRLoader.loadObjectFromFile(getClass().getResource("informes/report1.jasper").toString());
            JasperPrint printer = JasperFillManager.fillReport(report, parametres, SQLHelper.getInstancia().getConnection());

            JRViewer visor = new JRViewer(printer);

            visor.setOpaque(true);
            visor.setVisible(true);

            this.add(visor);
            this.setSize(1200, 660);
            // El setLocationRelativeTo permet posar el JFrame en el centre directament
            this.setLocationRelativeTo(null);
            this.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ImprimirInforme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
