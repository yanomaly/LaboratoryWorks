package Lab8.Entities;

import java.io.Serializable;

public class Cars extends Entity implements Serializable {

    private static Integer number;
    private static Double carrying;
    private static String make;
    private static String stock_mileage;

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

    public Cars(String args){
        String[] arrgs = args.split(" ");
        number = Integer.parseInt(arrgs[0]);
        carrying = Double.parseDouble(arrgs[1]);
        make = arrgs[2];
        stock_mileage = arrgs[3];
    }

    public Cars(){}
}
