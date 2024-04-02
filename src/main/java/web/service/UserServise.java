package web.service;

import web.model.User;

import java.util.List;

public interface UserServise {
    List<User> getAllUsers();

   void createOrUpdate (User user);

    User readUser(long id);

    User deleteUser(long id);
}
