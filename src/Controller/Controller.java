package Controller;

import DAO.DBCountries;
import Model.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.Optional;

public class Controller implements Initializable {

    public TableColumn idColumn;
    public TableColumn nameColumn;
    public TableView dataTable;

    @Override    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void showMe(ActionEvent actionEvent)
    {
        ObservableList<User> userList = DBCountries.getAllCountries();

        for(User x : userList)
        {
            System.out.println("User ID : " + x.getUserID() + " User Name : " + x.getUserName());
        }
    }
}
