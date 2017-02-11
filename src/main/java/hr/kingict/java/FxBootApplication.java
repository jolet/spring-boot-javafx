package hr.kingict.java;

import hr.kingict.java.controller.WelcomeController;
import hr.kingict.java.service.GreetingService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
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
        System.out.print(welcomeController.getWelcomeMessage() + "\n");
//        Parent welcomePane = FXMLLoader.load(getClass().getResource("/welcome.fxml"));
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
