package finanses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OutgoList {

    private String listName;
    private List<Outgo> outgoes = new ArrayList<>();


    public OutgoList(String listName) {
        this.listName = listName;

    }

    public double outgosSum() {
        return outgoes
                .stream()
                .map(Outgo::getValue)
                .reduce(Double::sum)
                .map(sum -> Math.round(sum * 100) / 100.0)
                .orElse(0.0);
    }

    public void printOutgoList() {
        System.out.println(listName);
        outgoes.forEach(System.out::println);
    }

    public void addOutgo(String outgoName, LocalDate date, double outgoValue) {
        outgoes.add(new Outgo(outgoName,date, outgoValue));
    }
}
