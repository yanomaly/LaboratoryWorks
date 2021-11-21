package Lab8.Entities;

public class Order extends Entity {

    private Integer carNumber;
    private String surname;
    private String date;
    private Double weight;
    private Double distance;
    private Double cost;
    private String from;
    private String to;
    private Double customsTax;
    private Double fuelCost;

    @Override
    public String toString1(){
        return "Car number: " + carNumber + " driver surname: " + surname +
                " date: " + date + " weight: " + weight + "kg distance: " + distance + "km" +
                " cost: " + cost + "$ from: " + from + " to: " + to + " customs tax: " + customsTax + "$" +
                " fuel cost: " + fuelCost + "$";
    }

    @Override
    public String toString2() {
       return carNumber + " " + surname + " " + date + " " +
               weight + " " + distance + " " + cost + " " +
                from + " " + to + " " + customsTax + " " + fuelCost;
    }

    public Order(String args){
        String[] arrgs = args.split(" ");
        carNumber = Integer.parseInt(arrgs[0]);
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

    public Integer getNumber() {
        return carNumber;
    }

}
