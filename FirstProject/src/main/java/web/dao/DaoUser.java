package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface DaoUser {

    public List<User> getUsers();

    public void save(User user);

    public void removeUser(Long id);

    public void upUs(User user);

}
