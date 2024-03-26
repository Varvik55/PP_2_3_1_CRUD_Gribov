package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
            return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();

    }

    @Override
    public void updateUser(User user) {
        User existingUser = entityManager.find(User.class, user.getId());

        if (existingUser != null) {
            existingUser.setAge(user.getAge());
            existingUser.setName(user.getName());
            existingUser.setLastname(user.getLastname());


            entityManager.merge(existingUser);
        } else {
            // Обработка случая, если пользователь не найден
            throw new EntityNotFoundException("Пользователь с ID " + user.getId() + " не найден.");
        }
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User deleteUser(long id) {
        return null;
    }
}
