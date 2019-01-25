package sample;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import library.dao.LanguageDAO;
import library.model.Language;

public class AddlanguageController {

    @FXML
    TextField languageField;

    public void addLanguage(){
        LanguageDAO languageDAO = new LanguageDAO();
        Language language = new Language();
        language.setName(languageField.getText());
        languageDAO.create(language);
    }

}
