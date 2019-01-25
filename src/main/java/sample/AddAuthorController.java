package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import library.dao.AuthorDAO;
import library.model.Author;


public class AddAuthorController {
    @FXML
    TextField authorFirstName;
    @FXML
    TextField authorLastName;

    public void addAuthor(){
        AuthorDAO authorDAO = new AuthorDAO();
        Author author = new Author();
        author.setFirstName(authorFirstName.getText());
        author.setLastName(authorLastName.getText());
        authorDAO.create(author);
    }

}
