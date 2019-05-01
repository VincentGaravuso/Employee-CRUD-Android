/*
 * Vincent Garavuso - R01656356 - I certify that this is my own original work
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Vinny
 */
public class FXMLDocumentController implements Initializable {

    private FadeTransition fade = new FadeTransition(
            Duration.millis(5000)
    );
    EmployeeManager em = new EmployeeManager();
    @FXML
    private Label label;
    @FXML
    private TextField txtEmployeeID;
    @FXML
    private Button btnImport;
    @FXML
    private TableView<Employee> tbvEmployeeList;
    @FXML
    private TableColumn<Employee, String> columnID;
    @FXML
    private TableColumn<Employee, String> columnLastName;
    @FXML
    private TableColumn<Employee, String> columnFirstName;
    @FXML
    private TableColumn<Employee, String> columnDate;
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
    public Label lblError;
    @FXML
    private Rectangle recEmployeeID;
    @FXML
    private Rectangle recFirstName;
    @FXML
    private Rectangle recLastName;
    @FXML
    private Rectangle recMonth;
    @FXML
    private Rectangle recDay;
    @FXML
    private Rectangle recYear;
    @FXML
    private Label lblSuccess;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        columnFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("HireDate"));
        fade.setNode(lblSuccess);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setCycleCount(1);
        fade.setAutoReverse(false);
    }

    @FXML
    private void addEmployeeBtnClicked(ActionEvent event) throws IOException {

        lblError.setText("");
        lblSuccess.setText("Successfully Added");
        int empID = 0, year = 0, month = 0, day = 0;
        String fName = "", lName = "";

        if (intValidation(txtEmployeeID) == true) {
            lblEmployeeID.setTextFill(Color.web("#000000"));
            recEmployeeID.setVisible(false);
            empID = Integer.parseInt(txtEmployeeID.getText());
        } else {
            recEmployeeID.setVisible(true);
            lblEmployeeID.setTextFill(Color.web("#ff0000"));
        }
        if (stringValidation(txtFirstName) == true) {
            lblFirstName.setTextFill(Color.web("#000000"));
            recFirstName.setVisible(false);
            fName = txtFirstName.getText();
        } else {
            recFirstName.setVisible(true);
            lblFirstName.setTextFill(Color.web("#ff0000"));
        }
        if (stringValidation(txtLastName) == true) {
            lblLastName.setTextFill(Color.web("#000000"));
            recLastName.setVisible(false);
            lName = txtLastName.getText();
        } else {
            recLastName.setVisible(true);
            lblLastName.setTextFill(Color.web("#ff0000"));
        }
        if (intValidation(txtMonth) == true) {
            lblDate.setTextFill(Color.web("#000000"));
            recMonth.setVisible(false);
            month = Integer.parseInt(txtMonth.getText());
        } else {
            recMonth.setVisible(true);
            lblDate.setTextFill(Color.web("#ff0000"));
        }
        if (intValidation(txtDay) == true) {
            lblDate.setTextFill(Color.web("#000000"));
            recDay.setVisible(false);
            day = Integer.parseInt(txtDay.getText());
        } else {
            recDay.setVisible(true);
            lblDate.setTextFill(Color.web("#ff0000"));
        }
        if (intValidation(txtYear) == true) {

            lblDate.setTextFill(Color.web("#000000"));
            recYear.setVisible(false);
            year = Integer.parseInt(txtYear.getText());
        } else {
            recYear.setVisible(true);
            lblDate.setTextFill(Color.web("#ff0000"));
        }
        if (!recEmployeeID.isVisible() && !recFirstName.isVisible()
                && !recLastName.isVisible() && !recMonth.isVisible()
                && !recDay.isVisible() && !recYear.isVisible()) {
            if (em.addEmployee(fName, lName, empID, year, month, day) == false) {
                lblError.setText("No two employees can have the same ID.");
            } else {
                updateList();
                lblSuccess.setVisible(true);
                fade.playFromStart();
                txtEmployeeID.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtMonth.setText("");
                txtDay.setText("");
                txtYear.setText("");
            }

        }

    }

    private void updateList() {
        tbvEmployeeList.getItems().clear();
        for (Employee e : em.empList) {
            tbvEmployeeList.getItems().add(e);
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
            lblError.setText("Error: You've entered illegal characters in a text field. Please remove \"" + invalidCharacters + "\" from the highlighted field or enter a different value.");
            return false;
        } else {
            return true;
        }
    }

    @FXML
    private void importBtnClicked(ActionEvent event) throws IOException
    {
        em.importer();
        updateList();
    }
}
