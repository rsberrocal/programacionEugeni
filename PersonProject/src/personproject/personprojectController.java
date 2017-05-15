/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personproject;

import Entity.Manager;
import Entity.Person;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author infot
 */
public class personprojectController implements Initializable {

    @FXML
    private TextArea taPrintPerson;
    @FXML
    private TextField tfDNINumber;

    @FXML
    private TextField tfDNILetter;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfSalary;

    private Manager m = new Manager();

    private void alerts(String header, String text) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(text);

        alert.showAndWait();
    }

    @FXML
    private void btLetterOnAction(ActionEvent event) {
        Person p = new Person();
        char c;
        if (tfDNINumber.getText().length() < 8) {
            alerts("Numbers Error", "You need at least 8 digits to get your letter");
        } else {
            p.setDni(Integer.parseInt(tfDNINumber.getText()));
            c = p.getLetter();
            tfDNILetter.setText(String.valueOf(c));
        }
    }

    @FXML
    private void tfDNINumberTyped(KeyEvent event) {
        Pattern pattern = Pattern.compile("\\d");
        if (tfDNINumber.getText().length() >= 8) {
            event.consume();
        }
        if (pattern.matcher(event.getCharacter()).matches()) {

        } else {
            event.consume();
        }
    }

    @FXML
    private void btAddOnAction(ActionEvent event) {
        if (tfName.getText().isEmpty() && tfSalary.getText().isEmpty() && tfDNINumber.getText().isEmpty() && tfDNILetter.getText().isEmpty()) {
            alerts("Fields missing", "Fields Name, Salary and DNI are missing");
            tfName.requestFocus();
        } else if (tfName.getText().isEmpty() && tfSalary.getText().isEmpty()) {
            alerts("Fields missing", "Fields Name and Salary are missing");
            tfName.requestFocus();
        } else if (tfSalary.getText().isEmpty() && tfDNINumber.getText().isEmpty() && tfDNILetter.getText().isEmpty()) {
            alerts("Fields missing", "Fields Salary and DNI are missing");
            tfSalary.requestFocus();
        } else if (tfName.getText().isEmpty() && tfDNINumber.getText().isEmpty() && tfDNILetter.getText().isEmpty()) {
            alerts("Fields missing", "Fields Name and DNI are missing");
            tfName.requestFocus();
        } else if (tfName.getText().isEmpty()) {
            alerts("Field missing", "Field Name is missing");
            tfName.requestFocus();
        } else if (tfSalary.getText().isEmpty()) {
            alerts("Field missing", "Field Salary is missing");
            tfSalary.requestFocus();
        } else if (tfDNINumber.getText().isEmpty() && tfDNILetter.getText().isEmpty()) {
            alerts("Field missing", "Field DNI is missing");
            tfDNINumber.requestFocus();
        } else {
            Person p = new Person(tfName.getText(), Double.parseDouble(tfSalary.getText()), Integer.parseInt(tfDNINumber.getText()));
            this.m.addPerson(p);
            taPrintPerson.appendText("\nName: " + p.getName() + "\nSalary: " + p.getSalary() + "€\nDNI: " + p.getDni() + p.getLetter() + " \nTotal: " + m.getTotalSalary());
        }

    }

    @FXML
    private void btExit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
