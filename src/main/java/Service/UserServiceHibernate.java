package Service;

import DAO.UserHibernateDAO;
import Model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class UserServiceHibernate {

    private static UserServiceHibernate userServiceHibernate;

    private SessionFactory sessionFactory;

    private UserServiceHibernate() {
    }

    public static UserServiceHibernate getInstance() {
        if (userServiceHibernate == null) {
            userServiceHibernate = new UserServiceHibernate();
        }
        return userServiceHibernate;
    }

    public boolean addUsers(User user) {
        UserHibernateDAO userHibernateDAO = new UserHibernateDAO();
        userHibernateDAO.addUser(user);
        return true;
    }

    public List<User> getAllUser() {
        return new UserHibernateDAO().getAllUsers();
    }

    public String getNameById(Long id) {
        return new UserHibernateDAO().getUserById(id).getName();
    }

    public User getUserByID(Long id) {
        return new UserHibernateDAO().getUserById(id);
    }

    public void changeUserData(Long id, User user) {
        new UserHibernateDAO().updateUser(id, user);
    }

    public void deleteUser(Long id) {
        new UserHibernateDAO().deleteUser(id);
    }

}
