package hr.kingict.java.controller;

import hr.kingict.java.service.GreetingService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class WelcomeController implements Initializable {

    @FXML
    public Button welcomeButton;

    @Autowired
    private GreetingService greetingService;


    public String getWelcomeMessage() {
        return greetingService.getWelcomeGreeting();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcomeButton.setText(greetingService.getWelcomeGreeting());
    }
}
