package hr.kingict.java.service;


import hr.kingict.java.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);
}
