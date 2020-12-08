package finanses;

import java.time.LocalDate;

public class Outgo {

     private String name;
     private LocalDate date;
     private double value;

     public Outgo(String name,LocalDate date, double value)
     {
         this.name = name;
         this.date = date;
         this.value = value;
     }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + " " + date + " " + value;
    }


}
