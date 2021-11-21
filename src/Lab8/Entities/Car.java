package Lab8.Entities;

public class Car extends Entity {

    private Integer number;
    private Double carrying;
    private String make;
    private String stock_mileage;

    @Override
    public String toString1(){
      return "Number: " + number + " carrying: " + carrying + "kg" +
              " make: " + make + " mileage: " + stock_mileage;
    }

    @Override
    public String toString2(){
        return number + " " + carrying + " " +
                make + " " + stock_mileage;
    }

    public Integer getNumber() {
        return number;
    }

    public Car(String args){
        String[] arrgs = args.split(" ");
        number = Integer.parseInt(arrgs[0]);
        carrying = Double.parseDouble(arrgs[1]);
        make = arrgs[2];
        stock_mileage = arrgs[3];
    }

    public Car(){}
}
