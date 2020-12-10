import finanses.OutgoList;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private String username;
    private String password;

    private double budget;
    private double savings;

    private List<OutgoList> userOutgoesLists = new ArrayList<>();

     public Account(String username, String password)
     {
         this.username=username;
         this.password=password;
     }

    //TODO lista wydatków bieżący miesiąc
    //TODO planowane wydatki
    //TODO historia wydatków



}
