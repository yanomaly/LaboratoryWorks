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

    @Override
    public boolean equals(Object o) {
        Order order = (Order) o;
        return carNumber.compareTo(order.carNumber) == 0 && surname.compareTo(order.surname) == 0 &&
                date.compareTo(order.date) == 0 && weight.compareTo(order.weight) == 0 &&
                distance.compareTo(order.distance) == 0 && cost.compareTo(order.cost) == 0 &&
                from.compareTo(order.from) == 0 && to.compareTo(order.to) == 0 &&
                customsTax.compareTo(order.customsTax) == 0 && fuelCost.compareTo(order.fuelCost) == 0;
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
