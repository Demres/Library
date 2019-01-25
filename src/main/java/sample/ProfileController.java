package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import library.model.Book;

import java.io.IOException;

public class ProfileController {

    @FXML
    TableView profileTableView;

    public void initialize(){

        profileTableView.setItems(getItems());
    }

    private ObservableList<Book> getItems(){
        return null;
    }

    public void changeScene(ActionEvent event) throws IOException {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ((BorderPane)stageTheEventSourceNodeBelongs.getScene().getRoot()).setCenter(FXMLLoader.load(getClass().getResource("addBook.fxml")));
        //stageTheEventSourceNodeBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("addBook.fxml")),800,800));
    }
}
