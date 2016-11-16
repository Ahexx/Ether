package pl.ether.forms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.ether.Main.Main;

public class MainForm extends Application {

    private Parent a;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void run(String... strings) {
        launch(strings);
    }

    @Override
    public void stop() throws Exception {
        Main.stop();
        super.stop();
    }
}