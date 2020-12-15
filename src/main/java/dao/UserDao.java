package dao;

import model.User;


public class UserDao extends AbstractDao<User> {

    private static volatile UserDao instance;

    public static UserDao getInstance() {
        if(instance == null) {
            synchronized(UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    private UserDao() {
        super(User.class);
    }

}
