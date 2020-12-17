import dao.UserDao;
import model.User;


public class AccountManager {

    private final UserDao userDao = UserDao.getInstance();

    public User login(String name, String password) {
        User user = userDao.getByName(name);

        if (user != null && password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }

    }

    public void logout() {

    }


}
