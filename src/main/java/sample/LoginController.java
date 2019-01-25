package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

    public void switchToCategory(ActionEvent event)throws IOException{
        Stage stageTheEventSourceNodeBelongs = (Stage) ((MenuItem)event.getTarget()).getParentPopup().getOwnerNode().getScene().getWindow();
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(FXMLLoader.load(getClass().getResource("addCategory.fxml")));
    }

    public void switchToLanguage(ActionEvent event)throws IOException{
        Stage stageTheEventSourceNodeBelongs = (Stage) ((MenuItem)event.getTarget()).getParentPopup().getOwnerNode().getScene().getWindow();
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(FXMLLoader.load(getClass().getResource("addLanguage.fxml")));
    }

    public void switchToAuthor(ActionEvent event)throws IOException{
        Stage stageTheEventSourceNodeBelongs = (Stage) ((MenuItem)event.getTarget()).getParentPopup().getOwnerNode().getScene().getWindow();
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(FXMLLoader.load(getClass().getResource("addAuthor.fxml")));
    }

    public void switchToReservation(ActionEvent event)throws IOException{
        Stage stageTheEventSourceNodeBelongs = (Stage) ((MenuItem)event.getTarget()).getParentPopup().getOwnerNode().getScene().getWindow();
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(FXMLLoader.load(getClass().getResource("addReservation.fxml")));
    }

    public void switchToBook(ActionEvent event)throws IOException{
        Stage stageTheEventSourceNodeBelongs = (Stage) ((MenuItem)event.getTarget()).getParentPopup().getOwnerNode().getScene().getWindow();
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(FXMLLoader.load(getClass().getResource("addBook.fxml")));
    }

    public void switchToProfile(ActionEvent event)throws IOException{
        Stage stageTheEventSourceNodeBelongs = (Stage) ((MenuItem)event.getTarget()).getParentPopup().getOwnerNode().getScene().getWindow();
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(FXMLLoader.load(getClass().getResource("profile.fxml")));
    }


    @FXML
    private void handleButtonClick(ActionEvent event) throws IOException {
        System.out.println("Handle login");
        System.out.println(loginInput.getText());
        /*if(loginInput.getText() != null && !loginInput.getText().isEmpty() &&
            passwordInput.getText() != null && !passwordInput.getText().isEmpty()) {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getByLogin(loginInput.getText());
            if (user != null) {
                System.out.println(user.getLogin());
                if(user.getPassword().equals(passwordInput.getText())) {
                    System.out.println(user.getPassword());
                    System.out.println(passwordInput.getText());
                    switchToProfile();
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
        }*/
    }
}
