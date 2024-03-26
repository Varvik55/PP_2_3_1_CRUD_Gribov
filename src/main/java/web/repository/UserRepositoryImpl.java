package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
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

    }

    @Override
    public User readUser(long id) {
        return null;
    }

    @Override
    public User deleteUser(long id) {
        return null;
    }
}
