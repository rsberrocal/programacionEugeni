/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Richard
 */
public class informes_fxmlController implements Initializable {
    
    private void printReport(String rep){
        ImprimirInforme imp = new ImprimirInforme();
        imp.mostraInforme(rep);
    }
    @FXML
    private void btPersonesOnAction(ActionEvent event) {
        printReport("persones.jrxml");
    }

    @FXML
    private void btProductesSimpleOnAction(ActionEvent event) {
       
    }

    @FXML
    private void btProductesParOnAction(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
