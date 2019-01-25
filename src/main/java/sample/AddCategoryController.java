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

    @FXML
    private void addCategory(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName(categoryField.getText());
        System.out.println(category.getName());
        categoryDAO.create(category);
    }
}
