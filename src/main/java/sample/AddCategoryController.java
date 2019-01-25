package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import library.dao.CategoryDAO;
import library.dao.LanguageDAO;
import library.model.Category;
import library.model.Language;

public class AddCategoryController {

    @FXML
    TextField categoryField;

    public AddCategoryController() {
        categoryField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                categoryField.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
    }

    @FXML
    private void addCategory(){
        if(categoryField.getText() != null && !categoryField.getText().isEmpty()) {
            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = new Category();
            category.setName(categoryField.getText());
            if(categoryDAO.exists(category)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setContentText("Podana kategoria już istnieje");
                alert.showAndWait();
            } else {
                categoryDAO.create(category);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setContentText("Uzupełnij nazwę kategorii");
            alert.showAndWait();
        }

    }
}
