package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.dao.UserDAO;
import library.model.User;

import java.io.IOException;

public class LoginController {
    @FXML
    TextField loginInput;
    @FXML
    PasswordField passwordInput;

    public LoginController(){

    }

    public void changeScene(ActionEvent event) throws IOException {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.setScene(new Scene(FXMLLoader.load(LoginController.class.getResource("/profile.xml")),800,800));
    }

    @FXML
    private void handleButtonClick(ActionEvent event) throws IOException {
        System.out.println("Handle login");
        System.out.println(loginInput.getText());
        if(loginInput.getText() != null && !loginInput.getText().isEmpty() &&
            passwordInput.getText() != null && !passwordInput.getText().isEmpty()) {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getByLogin(loginInput.getText());
            if (user != null) {
                System.out.println(user.getLogin());
                if(user.getPassword().equals(passwordInput.getText())) {
                    System.out.println(user.getPassword());
                    System.out.println(passwordInput.getText());
                    Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    stageTheEventSourceNodeBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("/profile.fxml")),800,800));
                }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setContentText("Nie znaleziono użytkownika o podanym loginie");
            alert.showAndWait();
        }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setContentText("Wprowadź login i hasło do formularza");
            alert.showAndWait();
        }
    }
}
