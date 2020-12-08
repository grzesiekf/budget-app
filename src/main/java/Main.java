import finanses.OutgoList;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        OutgoList moja = new OutgoList("moja lista");


        moja.addOutgo("obiad", LocalDate.now(),15.99);
        moja.addOutgo("zakupy",LocalDate.now(), 41.00);
        moja.addOutgo("czekolada",LocalDate.now(), 5.50);

        moja.printOutgoList();

        System.out.println("suma wydatków: "+ moja.outgosSum());

        System.out.println("-------------------------------------");

        OutgoList twoja = new OutgoList("twoja lista");


        twoja.addOutgo("zakupy",LocalDate.now(), 41.00);
        twoja.addOutgo("czekolada",LocalDate.now(), 5.50);

        twoja.printOutgoList();

        System.out.println("suma wydatków: "+ twoja.outgosSum());


    }

}
