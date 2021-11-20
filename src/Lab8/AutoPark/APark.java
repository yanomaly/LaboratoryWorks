package Lab8.AutoPark;

import Lab8.Entities.Cars;
import Lab8.Entities.Drivers;
import Lab8.Entities.Orders;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class APark implements AutoPark, Serializable {

    private static HashMap <Integer, Cars> cars = new HashMap<>();
    private static HashMap <Integer, Drivers> drivers = new HashMap<>();
    private static HashMap <Integer, Orders> orders = new HashMap<>();

    @Override
    public void read() throws IOException {
        BufferedReader cars_r = new BufferedReader(new FileReader("Cars2.txt"));
        BufferedReader drivers_r = new BufferedReader(new FileReader("Drivers2.txt"));
        BufferedReader orders_r = new BufferedReader(new FileReader("Orders2.txt"));
        String car_temp = cars_r.readLine();
        Cars temp;
        while(car_temp != null) {
            temp = new Cars(car_temp);
            cars.putIfAbsent(temp.getNumber(), temp);
            car_temp = cars_r.readLine();
        }
        String driver_temp = drivers_r.readLine();
        Drivers tempd;
        while(driver_temp != null) {
            tempd = new Drivers(driver_temp);
            drivers.putIfAbsent(tempd.getNumber(), tempd);
            driver_temp = cars_r.readLine();
        }
        String order_temp = orders_r.readLine();
        Orders tempo;
        while(order_temp != null) {
            tempo = new Orders(order_temp);
            orders.putIfAbsent(tempo.getNumber() + tempo.getDriverNumber(), tempo);
            order_temp = orders_r.readLine();
        }
        cars_r.close();
        drivers_r.close();
        orders_r.close();
    }

    @Override
    public void write() throws IOException {
        String crs1 = new String(), drvrs1 = new String(), rdrs1 = new String();
        String crs2 = new String(), drvrs2 = new String(), rdrs2 = new String();
        BufferedWriter cars_w1 = new BufferedWriter(new FileWriter("Cars1.txt"));
        BufferedWriter drivers_w1 = new BufferedWriter(new FileWriter("Drivers1.txt"));
        BufferedWriter orders_w1 = new BufferedWriter(new FileWriter("Orders1.txt"));
        BufferedWriter cars_w2 = new BufferedWriter(new FileWriter("Cars2.txt"));
        BufferedWriter drivers_w2 = new BufferedWriter(new FileWriter("Drivers2.txt"));
        BufferedWriter orders_w2 = new BufferedWriter(new FileWriter("Orders2.txt"));
        for (Cars temp: cars.values()) {
            crs2 += temp.toString2() + "\n";
            crs1 += temp.toString1() + "\n";
        }
        for (Drivers temp: drivers.values()) {
            drvrs2 += temp.toString2() + "\n";
            drvrs1 += temp.toString1() + "\n";
        }
        for (Orders temp: orders.values()) {
            rdrs2 += temp.toString2() + "\n";
            rdrs1 += temp.toString1() + "\n";
        }
        cars_w1.write(crs1);
        drivers_w1.write(drvrs1);
        orders_w1.write(rdrs1);
        cars_w2.write(crs2);
        drivers_w2.write(drvrs2);
        orders_w2.write(rdrs2);
        cars_w1.close();
        drivers_w1.close();
        orders_w1.close();
        cars_w2.close();
        drivers_w2.close();
        orders_w2.close();
    }

    @Override
    public void ser_r() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("project.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        APark temp = (APark) objectInputStream.readObject();
        cars = temp.getCars();
        drivers = temp.getDrivers();
        orders = temp.getOrders();
    }

    @Override
    public void ser_w() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("project.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    @Override
    public void search(Object obj) {
        System.out.println("sear");
    }

    @Override
    public void add(Object obj) {
        System.out.println("add");
    }

    @Override
    public void delete(Object obj) {
        System.out.println("del");
    }

    @Override
    public void change(Object obj) {
        System.out.println("ch");
    }

    @Override
    public void show(Object obj) {

    }

    public HashMap<Integer, Cars> getCars() {
        return cars;
    }

    public HashMap<Integer, Drivers> getDrivers() {
        return drivers;
    }

    public HashMap<Integer, Orders> getOrders() {
        return orders;
    }

    public void show_menu(int param){
        switch (param){
            case(1):
                System.out.println("To add driver press 1 \n" +
                        "To delete driver press 2 \n" +
                        "To change driver press 3 \n" +
                        "To show drivers list press 4 \n" +
                        "To go to main menu press 0 \n");
                break;
            case(2):
                System.out.println("To add car press 1 \n" +
                        "To delete car press 2 \n" +
                        "To change car press 3 \n" +
                        "To show cars list press 4 \n" +
                        "To go to main menu press 0 \n");
                break;
            case(3):
                System.out.println("To add order press 1 \n" +
                        "To delete order press 2 \n" +
                        "To change order press 3 \n" +
                        "To show orders list press 4 \n" +
                        "To go to main menu press 0 \n");
                break;
            default:
                System.out.println("To work with drivers press 1 \n" +
                        "To work with cars press 2 \n" +
                        "To work with orders press 3 \n" +
                        "To exit press 0 \n");
                break;
        }
    }

    public void menu() throws IOException, ClassNotFoundException {
        ser_r();
        read();
        show_menu(0);
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        switch (Integer.parseInt(command)){
            case(0):
                ser_w();
                write();
                System.exit(0);
                break;
            case(1):
                show_menu(1);
                Scanner sc1 = new Scanner(System.in);
                String command1 = sc1.next();
                switch (Integer.parseInt(command1)){
                    case(0):
                        menu();
                        break;
                    case(1):
                        add(drivers);
                        menu();
                        break;
                    case(2):
                        delete(drivers);
                        menu();
                        break;
                    case(3):
                        change(drivers);
                        menu();
                        break;
                    case(4):
                        show(drivers);
                        menu();
                        break;
                }
                break;
            case(2):
                show_menu(2);
                Scanner sc2 = new Scanner(System.in);
                String command2 = sc2.next();
                switch (Integer.parseInt(command2)){
                    case(0):
                        menu();
                        break;
                    case(1):
                        add(cars);
                        menu();
                        break;
                    case(2):
                        delete(cars);
                        menu();
                        break;
                    case(3):
                        change(cars);
                        menu();
                        break;
                    case(4):
                        show(cars);
                        menu();
                        break;
                }
                break;
            case(3):
                show_menu(3);
                Scanner sc3 = new Scanner(System.in);
                String command3 = sc3.next();
                switch (Integer.parseInt(command3)){
                    case(0):
                        menu();
                        break;
                    case(1):
                        add(orders);
                        menu();
                        break;
                    case(2):
                        delete(orders);
                        menu();
                        break;
                    case(3):
                        change(orders);
                        menu();
                        break;
                    case(4):
                        show(orders);
                        menu();
                        break;
                }
                break;
        }
    }

}
