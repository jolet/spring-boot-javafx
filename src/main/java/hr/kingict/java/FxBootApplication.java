package hr.kingict.java;

import hr.kingict.java.controller.WelcomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FxBootApplication extends Application {

    @Autowired
    private WelcomeController welcomeController;

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void init() {
        SpringApplication.run(getClass()).getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent welcomePane = loadFxml("/welcome.fxml");
        primaryStage.setScene(new Scene(welcomePane));
        primaryStage.show();
    }

    private Parent loadFxml(String view) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        loader.setControllerFactory(param -> welcomeController);
        try {
            loader.load();
        } catch (IOException ex) {
            System.out.println("IOException while loading resource");
        }
        return loader.getRoot();
    }
}
