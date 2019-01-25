package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.dao.AuthorDAO;
import library.dao.CategoryDAO;
import library.dao.LanguageDAO;
import library.model.Author;
import library.model.Category;
import library.model.Language;

import java.io.IOException;

public class AddBookController {

    TextField titleTextField;
    TextField editionTextField;
    TextArea descriptionTextArea;
    ListView<Author> authorListView;
    ListView<Language> languageListView;
    ListView<Category> categoryListView;

    public void initialize(){

        AuthorDAO authorDAO = new AuthorDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        LanguageDAO languageDAO = new LanguageDAO();
       // authorListView.getItems().addAll((ObservableList)authorDAO.getAll());
        //categoryListView.getItems().addAll((ObservableList)categoryDAO.getAll());
        //languageListView.getItems().addAll((ObservableList)languageDAO.getAll());


    }

}
