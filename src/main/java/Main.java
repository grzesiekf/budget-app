import dao.UserDao;
import db.MySessionFactory;
import dao.OutgoDao;
import model.Outgo;
import model.User;
import java.time.LocalDate;



public class Main {

    OutgoDao outgoDao = OutgoDao.getInstance();
    UserDao userDao = UserDao.getInstance();

    public void run1() {
        User user = new User();
        Outgo outgo1 = new Outgo();

        user.setName("Grzechu");
        user.setPassword("aaaa");

        userDao.persist(user);

        outgo1.setOwner(user);
        outgo1.setName("pizza");
        outgo1.setValue(10.99);
        outgo1.setDate(LocalDate.now());

        outgoDao.persist(outgo1);

        printOutgos();
    }
    public void run()
    {
        System.out.println("User:");
        userDao.getAll().forEach(System.out::println);
        System.out.println();
    }

    public void printOutgos() {
        System.out.println("Outgos:");
        outgoDao.getAll().forEach(System.out::println);
        System.out.println();
    }


    public static void main(String[] args) {
        MySessionFactory.init();
        Main main = new Main();
        main.run();

    }
}
