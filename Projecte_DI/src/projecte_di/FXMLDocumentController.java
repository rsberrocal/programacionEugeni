/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_di;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import projecte_di.Entitats.GestorPersones;
import projecte_di.Entitats.Persona;

/**
 *
 * @author Tito_Berny
 */
public class FXMLDocumentController implements Initializable {
    
    private int LIMIT = 8;
    @FXML
    private TextField tfNIF;
    @FXML
    private TextField tfDNI;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfSou;
    @FXML
    private Button bSortir;
    @FXML
    private TextArea taLlistat;

    GestorPersones gp = new GestorPersones();
    Persona p = new Persona();
    List<Persona> lista = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tfDNI.lengthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    // Comprova si el nou caràcter és major que el LIMIT
                    if (tfDNI.getText().length() >= LIMIT) {
                        // Si és el caracter del LIMIT llavors estableix setText
                        // a l'anterior caràcter                        
                        tfDNI.setText(tfDNI.getText().substring(0, LIMIT));
                    }
                }
            }
        });
        // TODO
    }    
    
    @FXML
    private void souNumeroKeyTyped(KeyEvent k) {   //Solo numeros en tfSou

        if (!k.getCharacter().matches("\\d")) {
            k.consume();
        }
    }
    
    @FXML
    private void txtNumeroKeyTyped(KeyEvent k) {  //Solo numeros en tfDNI

        if (!k.getCharacter().matches("\\d")) {
            k.consume();
        }
    }
    
    @FXML
    private void calcularlletra (ActionEvent event) {  //calcula letra del DNI y la pone en tfNIF
        if (tfDNI.getText().length() == LIMIT) {
                    int dni = Integer.parseInt(tfDNI.getText());
                    char lletra = p.getNif(dni);
                    String s = String.valueOf(lletra);
                    tfNIF.setText(s);
        }
    }
    
    @FXML 
    private void bAfegir(ActionEvent event) {                   //Sale del programa 
        
        GestorPersones gp1 = new GestorPersones();
        if (!tfNom.getText().isEmpty()){                        //si el tfnom no esta vacio
            
            String nom = tfNom.getText();                       //recoje los tf
            taLlistat.setText("hola");
            int sou = Integer.parseInt(tfSou.getText());
            int dni = Integer.parseInt(tfDNI.getText());
            String lletra = tfNIF.getText();
            Persona per1 = new Persona(dni, nom, sou);           //crea un objeto con los valores
            lista = gp1.emmagatzemar_persones(lista, per1);      //guarda el objeto en la lista global
     
            taLlistat.setText(Integer.toString(gp.calcular_sous(lista)));       //muestra el sou en ta
        }
        // TODO add your handling code here:
    }
    
    @FXML 
    private void bSortir(ActionEvent event) {       //Sale del programa                                    
        System.exit(0);
        // TODO add your handling code here:
    }
         
}
