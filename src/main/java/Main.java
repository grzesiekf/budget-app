import dao.OutgoDao;
import dao.UserDao;
import db.MySessionFactory;
import model.User;

import java.util.Scanner;


public class Main {

    OutgoDao outgoDao = OutgoDao.getInstance();
    UserDao userDao = UserDao.getInstance();

    public void updateUser(int id) {

        User user = userDao.get(id);
        user.setPassword("cccc");
        userDao.update(user);
        userDao.getAll().forEach(System.out::println);
    }

    public void authorization() {
        AccountManager accountManager = new AccountManager();
        Scanner scanner = new Scanner(System.in);
        char again = 'y';
        while (again == 'y') {
            System.out.println("login: ");
            String name = scanner.nextLine();
            System.out.println("password: ");
            String password = scanner.nextLine();
            if (accountManager.login(name, password)) {
                System.out.println("logged in");
                return;
            } else {
                System.out.println("wrong username or password, try again");
                System.out.println("try again? y/n");
                again = scanner.next().charAt(0);
            }
        }

    }

    public void run() {
        authorization();

    }

    public void printOutgoes() {
        System.out.println("Outgoes:");
        outgoDao.getAll().forEach(System.out::println);
        System.out.println();
    }


    public static void main(String[] args) {
        MySessionFactory.init();
        Main main = new Main();

        main.run();

    }
}
