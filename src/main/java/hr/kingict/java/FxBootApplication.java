package hr.kingict.java;

import hr.kingict.java.service.GreetingService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FxBootApplication extends Application {

    @Autowired
    private GreetingService greetingService;

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void init() {
        SpringApplication.run(getClass()).getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane helloFxPane = new Pane(new Button(greetingService.getWelcomeGreeting()));
        primaryStage.setScene(new Scene(helloFxPane));
        primaryStage.show();
    }
}
