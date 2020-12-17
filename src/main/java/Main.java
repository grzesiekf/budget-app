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

    public User authorize() {
        AccountManager accountManager = new AccountManager();
        char again = 'y';
        while (again == 'y') {
            Scanner scanner = new Scanner(System.in);
            System.out.println("login: ");
            String name = scanner.nextLine();
            System.out.println("password: ");
            String password = scanner.nextLine();
            User user = accountManager.login(name, password);
            if (user != null) {
                System.out.println("logged in");
                return user;

            } else {
                System.out.println("wrong username or password, try again or exit");
                System.out.println("try again? y/n");
                again = scanner.next().charAt(0);
            }
        }
        return null;
    }

    public void run() {
        System.out.println("log in to go next");
        User user = authorize();
        if (user == null) return;
        System.out.println();
        int i = 0;
        while (i != 4) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("==========================================");
            System.out.println("==================MENU====================");
            System.out.println("==========================================");
            System.out.println("1. Print user info");
            System.out.println("2. Print user outgoes");
            System.out.println("3. Add outgo");
            System.out.println("4. Exit");
            i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println(user);
                    break;
                case 2:
                    printOutgoes();
                    break;
                case 3:
                    System.out.println("to do");
                    break;
            }
        }
    }

    public void printOutgoes() {
        System.out.println("Outgoes:");
        outgoDao.getAll().forEach(System.out::println);
        System.out.println();
    }


    public static void main(String[] args) {
        MySessionFactory.init();
        Main application = new Main();
        application.run();
    }
}
