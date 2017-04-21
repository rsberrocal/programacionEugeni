/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control_examenuf1_rsudario;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author infot
 */
public class Control_examenUF1_rsudarioExemple extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        control_examenUF1_rsudario control = new control_examenUF1_rsudario();

        stage.setScene(new Scene(control));        
        stage.setWidth(420);
        stage.setHeight(200);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
