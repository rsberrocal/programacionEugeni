/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author infot
 */
public class informes_fxmlController implements Initializable {
    
    public static boolean comprovaDir(String dir) {
        boolean flag;
        Path path = Paths.get(dir);
        return flag = Files.exists(path);
    }
    
    public static void printInforme(String inf) {
        ImprimirInforme imp = new ImprimirInforme();
        imp.mostraInforme(inf);
    }
    
    @FXML
    private void personesOnAction(ActionEvent event) {
        printInforme("Persones.jrxml");
    }

    @FXML
    private void productesOrdenatsOnAction(ActionEvent event) {
    }

    @FXML
    private void productesOnAction(ActionEvent event) {               

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
