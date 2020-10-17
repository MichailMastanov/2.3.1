package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class DaoUserImpl implements DaoUser {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getUsers() {
        List<User> users = entityManager.createQuery("FROM User").getResultList();
        return users;
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public void upUs(User user) {
        entityManager.merge(user);
    }

}

