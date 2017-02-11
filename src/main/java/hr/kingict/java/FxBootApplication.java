package hr.kingict.java;

import hr.kingict.java.controller.Navigation;
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
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

/**
 * App lifecycle: main() -> init() -> start() *Fx GUI Thread* -> stop()
 * Spring boot apps take program arguments so in main() they are saved to savedArgs to be picked later
 * from init() call where spring context starts up. start() method is called afterwards from gui thread.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "hr.kingict.java.repository")
public class FxBootApplication extends Application {

    private static String[] savedArgs;
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private Navigation navigation;

    public static void main(String[] args) {
        savedArgs = args;
        Application.launch(args);
    }

    @Override
    public void init() {
        applicationContext = SpringApplication.run(getClass(), savedArgs);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage stage) {
        navigation.setStage(stage);
        navigation.showWelcomeView();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        applicationContext.close();
        System.exit(0);
    }
}
