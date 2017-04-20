/**
 * GNU General Public License <http://www.gnu.org/licenses/>
 *
 * CFGS Desenvolupament d'Aplicacions Multiplataforma Departament d'Informàtica
 * IES Eugeni d'Ors - Vilafranca del Penedès
 *
 * Curs 2016 - 2017
 *
 * Mòdul M7 - Desenvolupament d'Interfícies Pràctica:
 *
 * @author Rubén Nadal <rnadal27@xtec.cat>
 * @version 1.0
 *
 */
package informes;

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

/**
 *
 * @author Rubén Nadal <rnadal27@xtec.cat>
 */
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
            this.setSize(800, 660);
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
            this.setSize(800, 660);
            // El setLocationRelativeTo permet posar el JFrame en el centre directament
            this.setLocationRelativeTo(null);
            this.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ImprimirInforme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
