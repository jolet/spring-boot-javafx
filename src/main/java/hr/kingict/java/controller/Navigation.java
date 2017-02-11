package hr.kingict.java.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Navigation {
    private static final Logger LOG = LoggerFactory.getLogger(Navigation.class);
    private static final String WELCOME_VIEW = "/fxml/welcome.fxml";
    private static final String USER_VIEW = "/fxml/user.fxml";
    private static final String APP_CSS = "/css/application.css";
    private Stage stage;

    @Autowired
    private WelcomeController welcomeController;

    @Autowired
    private UserController userController;

    public void showWelcomeView() {
        show(WELCOME_VIEW);
    }

    public void showUserView() {
        show(USER_VIEW);
    }

    private void show(String view) {
        Scene scene = new Scene(loadFxml(view), 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private Parent loadFxml(String view) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        loader.setControllerFactory(param -> getViewController(view));
        try {
            loader.load();
        } catch (IOException ex) {
            LOG.error("IOException while loading resource {}: ", view, ex);
        }
        Parent root = loader.getRoot();
        root.getStylesheets().add(getClass().getResource(APP_CSS).toExternalForm());
        return root;
    }

    private Object getViewController(String view) {
        if (USER_VIEW.equals(view)) {
            return userController;
        }
        return welcomeController;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
