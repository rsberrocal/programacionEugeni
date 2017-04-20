/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantillaexamendi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Richard
 */
public class plantillaExamenDI extends AnchorPane {
    
    @FXML
    private Label label;
    
    
    public plantillaExamenDI() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("plantilla.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    //Se elimina el initialize
    //@Override
    //public void initialize(URL url, ResourceBundle rb) {
        // TODO
    //}    
    
}
