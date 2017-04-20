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

    @FXML
    TextField tfPar;

    private void printReport(String rep) {
        ImprimirInforme imp = new ImprimirInforme();
        imp.mostraInforme(rep);
    }

    private void printReport(String rep, Map par) {
        ImprimirInforme imp = new ImprimirInforme();
        imp.mostraInforme(rep, par);
    }

    @FXML
    private void btPersonesOnAction(ActionEvent event) {
        printReport("persones.jrxml");
    }

    @FXML
    private void btProductesSimpleOnAction(ActionEvent event) {
        printReport("productes.jrxml");
    }

    @FXML
    private void btProductesParOnAction(ActionEvent event) {
        int par;
        Map parametersMap = new HashMap();
        par = Integer.parseInt(tfPar.getText());
        parametersMap.put("stockParameter", par);
        printReport("productesParameter.jrxml",parametersMap);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
