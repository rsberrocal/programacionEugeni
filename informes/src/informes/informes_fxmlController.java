/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Richard
 */
public class informes_fxmlController implements Initializable {
    // TextField on es posa el valor per filtrar el stock
    @FXML
    TextField tfPar;
    
    // Funcio per imprimir els informes sense parametres
    private void printReport(String rep) {
        ImprimirInforme imp = new ImprimirInforme();
        imp.mostraInforme(rep);
    }
    // Funcio per imprimir els informes amb parametres
    private void printReport(String rep, Map par) {
        ImprimirInforme imp = new ImprimirInforme();
        imp.mostraInforme(rep, par);
    }
    //Event alhora de pulsar el boto de Persones 
    @FXML
    private void btPersonesOnAction(ActionEvent event) {
        printReport("persones.jrxml");
    }
    //Event alhora de pulsar el boto de Productes 
    @FXML
    private void btProductesSimpleOnAction(ActionEvent event) {
        printReport("productes.jrxml");
    }
    //Event alhora de pulsar el boto de Productes amb parametres
    @FXML
    private void btProductesParOnAction(ActionEvent event) {
        int par;
        //Es crea un mapa per posar el valor del parametre
        Map parametres = new HashMap();
        //Posem el nom del parametres i agafem el valor que es troba en el TextField
        parametres.put("stockParameters", Integer.parseInt(tfPar.getText()));
        printReport("productesParameter.jrxml", parametres);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
