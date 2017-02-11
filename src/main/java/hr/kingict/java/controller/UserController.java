package hr.kingict.java.controller;

import hr.kingict.java.model.User;
import hr.kingict.java.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class UserController implements Initializable {
    @FXML public GridPane userGridPane;
    @FXML public TextField nameTextField;
    @FXML public TextField meritTextField;

    @Autowired
    private UserService userService;

    @Autowired
    private Navigation navigation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initData();
    }

    private void initData() {
        userGridPane.getChildren().clear();
        addHeaderRow(userGridPane);
        List<User> users = userService.getUsers();
        users.forEach(user ->
                userGridPane.addRow(user.getId().intValue(), new Label(user.getName()), new Label(user.getMerit())));
    }

    @FXML
    public void navigateBack() {
        navigation.showWelcomeView();
    }

    @FXML
    public void saveUser() {
        userService.save(new User(nameTextField.getText(), meritTextField.getText()));
        initData();
    }

    private void addHeaderRow(GridPane userGridPane) {
        userGridPane.addRow(0, new Label("Name"), new Label("Known for"));
    }
}

