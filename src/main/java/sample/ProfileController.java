package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import library.model.Book;

import java.io.IOException;

public class ProfileController {

    @FXML
    TableView profileTableView;

    public void initialize(){

        //profileTableView.setItems(getItems());
    }

    private ObservableList<Book> getItems(){
        return null;
    }

    public void changeScene(ActionEvent event) throws IOException {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("addUser.fxml"));
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(anchorPane);
        //stageTheEventSourceNodeBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("addUser.fxml")),800,800));
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
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(FXMLLoader.load(getClass().getResource("addUser.fxml")));
    }
}
