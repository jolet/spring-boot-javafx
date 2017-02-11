package hr.kingict.java.controller;

import hr.kingict.java.controller.Navigation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WelcomeController {

    @FXML
    public Button counterButton;
    private int counter;

    @Autowired
    private Navigation navigation;

    @FXML
    public void showUserView() {
        navigation.showUserView();
    }

    public String getWelcomeMessage() {
        return "Hello Spring Boot";
    }
}

