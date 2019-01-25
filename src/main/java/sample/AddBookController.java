package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.dao.*;
import library.model.*;

import java.io.IOException;
import java.util.Set;

public class AddBookController {
    @FXML
    TextField titleTextField;
    @FXML
    TextField editionTextField;
    @FXML
    TextArea descriptionTextArea;
    @FXML
    ListView<Author> authorListView;
    @FXML
    ListView<Language> languageListView;
    @FXML
    ListView<Category> categoryListView;
    @FXML
    ListView<Publisher> publisherListView;

    public void initialize(){

        AuthorDAO authorDAO = new AuthorDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        LanguageDAO languageDAO = new LanguageDAO();
        PublisherDAO publisherDAO = new PublisherDAO();
        authorListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //languageListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        categoryListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //publisherListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        if(authorDAO.getAll() != null){
            authorListView.getItems().addAll((ObservableList)authorDAO.getAll());
        }

        if(categoryDAO.getAll() != null){
            categoryListView.getItems().addAll((ObservableList)categoryDAO.getAll());
        }

        if(languageDAO.getAll() != null){
            languageListView.getItems().addAll((ObservableList)languageDAO.getAll());
        }

        if(publisherDAO.getAll() != null){
            publisherListView.getItems().addAll((ObservableList)publisherDAO.getAll());
        }


    }

    public void addBook(){
        BookDAO bookDAO = new BookDAO();
        Book book = new Book();

        Set<Author> authors = (Set)authorListView.getSelectionModel().getSelectedItems();
        book.setAuthors(authors);

        book.setLanguage(languageListView.getSelectionModel().getSelectedItem());

        book.setPublisher(publisherListView.getSelectionModel().getSelectedItem());

        book.setCategories((Set<Category>)categoryListView.getSelectionModel().getSelectedItems());

        book.setTitle(titleTextField.getText());

        book.setDescription(descriptionTextArea.getText());

        book.setEdition(Integer.parseInt(editionTextField.getText()));
        bookDAO.create(book);
    }


}
