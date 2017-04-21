/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control_examenuf1_rsudario;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author infot
 */
public class control_examenUF1_rsudario extends AnchorPane {

    @FXML
    TextField tfMinim, tfMaxim;

    //Constructor
    public control_examenUF1_rsudario() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("control_examenUF1_rsudario.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    // Funcio per imprimir els informes amb parametres
    private void printReport(String rep, Map par) {
        ImprimirInforme imp = new ImprimirInforme();
        imp.mostraInforme(rep, par);
    }

    @FXML
    private void btImprimirOnAction(ActionEvent event) {
        int par;
        //Es crea un mapa per posar el valor del parametre
        Map parametres = new HashMap();
        //Posem el nom del parametres i agafem el valor que es troba en el TextField
        parametres.put("Min", Integer.parseInt(tfMinim.getText()));
        parametres.put("Max", Integer.parseInt(tfMaxim.getText()));
        printReport("productes.jrxml", parametres);
    }

    @FXML
    private void tfMinMax(KeyEvent event) {
        Pattern pattern = Pattern.compile("\\d");
        if (pattern.matcher(event.getCharacter()).matches()) {

        } else {
            event.consume();
        }
    }

}
