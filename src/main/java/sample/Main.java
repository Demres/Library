package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.HibernateUtil;

public class Main extends Application {
   // public Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        primaryStage.setTitle("Library");
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();

        //BorderPane borderPane = (BorderPane)(root);
        //borderPane.setBottom(new Button("Click me"));


    }


    public static void main(String[] args) {
        launch(args);
    }
}
