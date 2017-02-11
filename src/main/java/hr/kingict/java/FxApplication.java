package hr.kingict.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by josip.kovacek on 28.9.2016..
 */
public class FxApplication extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane helloFxPane = new Pane(new Button("Hello JavaFx"));
        primaryStage.setScene(new Scene(helloFxPane));
        primaryStage.show();
    }
}
