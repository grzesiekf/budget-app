import dao.UserDao;
import model.User;


public class AccountManager {

    private final UserDao userDao = UserDao.getInstance();

    public boolean login(String name, String password) {
        User user = userDao.getByName(name);

        if (password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }

    }

    public void logout() {

    }


}
