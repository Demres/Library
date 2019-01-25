package sample;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import library.dao.CategoryDAO;
import library.dao.LanguageDAO;
import library.model.Category;
import library.model.Language;

public class AddCategoryController {

    @FXML
    TextField categoryField;

    public void addLanguage(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName(categoryField.getText());
        categoryDAO.create(category);
    }
}
