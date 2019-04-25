/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author Vinny
 */
public class FXMLDocumentController implements Initializable {

    EmployeeManager em = new EmployeeManager();
    @FXML
    private Label label;
    @FXML
    private TextField txtEmployeeID;
    @FXML
    private Button btnImport;
    @FXML
    private TableColumn<?, ?> columnID;
    @FXML
    private TableColumn<?, ?> columnLastName;
    @FXML
    private TableColumn<?, ?> columnFirstName;
    @FXML
    private TableColumn<?, ?> columnDate;
    @FXML
    private Button btnAddEmployee;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtYear;
    @FXML
    private TextField txtDay;
    @FXML
    private TextField txtMonth;
    @FXML
    private TextField txtLastName;
    @FXML
    private Label lblEmployeeID;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblDateFormat;
    @FXML
    private Label lblError;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void importBtnClicked(ActionEvent event) {

    }

    @FXML
    private void addEmployeeBtnClicked(ActionEvent event) {

        if (stringValidation(txtEmployeeID) == true) {

            String empID = txtEmployeeID.getText();
        }
        if (stringValidation(txtFirstName) == true) {
            String fName = txtFirstName.getText();
        }
        if (stringValidation(txtLastName) == true) {

            String lName = txtLastName.getText();
        }
        if (intValidation(txtMonth) == true) {

            int month = Integer.parseInt(txtMonth.getText());
        }
        if (stringValidation(txtDay) == true) {

            int day = Integer.parseInt(txtDay.getText());
        }
        if (stringValidation(txtYear) == true) {

            int year = Integer.parseInt(txtYear.getText());
        }

    }

    private boolean intValidation(TextField txt) {
        if (txt.getText().isEmpty() || txt.getText() == null) {
            lblError.setText("Error: You can not leave any fields blank.");
            return false;
        }
        try {
            int x = Integer.parseInt(txt.getText());
            return true;
        } catch (NumberFormatException e) {
            lblError.setText("Error: " + txt.getText() + " is not an integer.");
            return false;
        }
    }

    private boolean stringValidation(TextField txt) {
        if (txt.getText().isEmpty() || txt.getText() == null) {
            lblError.setText("Error: You can not leave any fields blank.");
            return false;
        } else if (txt.getText().matches(".*\\d.*")) {
            String invalidCharacters = txt.getText().replaceAll("[^0-9]", "");
            lblError.setText("Error: You've entered illegal characters (" + invalidCharacters + ").");
            return false;
        } else {
            return true;
        }
    }

}
