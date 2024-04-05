package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
@Service
@Transactional
public class UserServiseImpl implements UserServise{
    private final UserRepository userRepository;

    public UserServiseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void createOrUpdate(User user) {
        if (user.getId()==null){
            userRepository.createUser(user);
        }else {
            userRepository.updateUser(user);
        }
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }


    public void updateUser(User user) {
       userRepository.createUser(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User readUser(long id) {
        return userRepository.readUser(id);
    }

    @Override
    public User deleteUser(long id) {

        if (null == userRepository.readUser(id)) {
            throw new NullPointerException("User not found");
        }
        return userRepository.deleteUser(id);
    }
}
