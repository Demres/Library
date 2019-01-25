package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import library.dao.CategoryDAO;
import library.dao.PublisherDAO;
import library.model.Category;
import library.model.Publisher;

public class AddPublisherController {

    @FXML
    TextField publisherNameField;
    @FXML
    TextField publisherLocationField;

    public void addPublisher(){

        PublisherDAO publisherDAO = new PublisherDAO();
        Publisher publisher = new Publisher();
        publisher.setName(publisherNameField.getText());
        publisher.setLocation(publisherLocationField.getText());
    }

}
