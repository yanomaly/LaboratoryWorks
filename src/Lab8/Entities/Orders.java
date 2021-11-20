package Lab8.Entities;

import java.io.Serializable;

public class Orders extends Entity implements Serializable {

    private static Cars car;
    private static Drivers driver;
    private static Integer number = car.getNumber();
    private static String surname = driver.getSurname();
    private static String date;
    private static Double weight;
    private static Double distance;
    private static Double cost;
    private static String from;
    private static String to;
    private static Double customsTax;
    private static Double fuelCost;

    @Override
    public String toString1(){
        return "Car number: " + car.getNumber() + " driver surname: " + driver.getSurname() +
                " date: " + date + " weight: " + weight + "kg distance: " + distance + "km" +
                " cost: " + cost + "$ from: " + from + " to: " + to + " customs tax: " + customsTax + "$" +
                " fuel cost: " + fuelCost + "$";
    }

    @Override
    public String toString2() {
       return number + " " + surname + " " + date + " " +
               weight + " " + distance + " " + cost + " " +
                from + " " + to + " " + customsTax + " " + fuelCost;
    }

    public Orders(String args){
        String[] arrgs = args.split(" ");
        number = Integer.parseInt(arrgs[0]);
        surname = arrgs[1];
        date = arrgs[2];
        weight = Double.parseDouble(arrgs[3]);
        distance = Double.parseDouble(arrgs[4]);
        cost = Double.parseDouble(arrgs[5]);
        from = arrgs[6];
        to = arrgs[7];
        customsTax = Double.parseDouble(arrgs[8]);
        fuelCost = Double.parseDouble(arrgs[9]);
    }

    public Orders(){}

    public Integer getNumber() {
        return number;
    }

    public Integer getDriverNumber() { return driver.getNumber(); }
}
