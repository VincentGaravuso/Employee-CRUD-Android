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

/**
 *
 * @author Vinny
 */
public class FXMLDocumentController implements Initializable
{
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void importBtnClicked(ActionEvent event) 
    {
        
    }

    @FXML
    private void addEmployeeBtnClicked(ActionEvent event) 
    {
        
    }
    
}
