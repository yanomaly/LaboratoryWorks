package Lab8.AutoPark;

import Lab8.Entities.Car;
import Lab8.Entities.Driver;
import Lab8.Entities.Order;

import java.io.*;
import java.util.*;

public class APark implements AutoPark {

    private HashMap <Integer, Car> cars = new HashMap<>();
    private HashMap <Integer, Driver> drivers = new HashMap<>();
    private HashMap <Integer, Order> orders = new HashMap<>();

    public APark() throws IOException, ClassNotFoundException {
        ser_r();
        read();
    }

    @Override
    public void read() throws IOException {
        BufferedReader cars_r = new BufferedReader(new FileReader("Cars2.txt"));
        BufferedReader drivers_r = new BufferedReader(new FileReader("Drivers2.txt"));
        BufferedReader orders_r = new BufferedReader(new FileReader("Orders2.txt"));
        String car_temp = cars_r.readLine();
        while(car_temp != null) {
            cars.putIfAbsent(new Car(car_temp).getNumber(), new Car(car_temp));
            car_temp = cars_r.readLine();
        }
        String driver_temp = drivers_r.readLine();
        while(driver_temp != null) {
            drivers.putIfAbsent(new Driver(driver_temp).getNumber(), new Driver(driver_temp));
            driver_temp = drivers_r.readLine();
        }
        String order_temp = orders_r.readLine();
        while(order_temp != null) {
            orders.putIfAbsent(new Order(order_temp).getNumber(), new Order(order_temp));
            order_temp = orders_r.readLine();
        }
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
        for (Car temp: cars.values()) {
            crs2 += temp.toString2() + "\n";
            crs1 += temp.toString1() + "\n";
        }
        for (Driver temp: drivers.values()) {
            drvrs2 += temp.toString2() + "\n";
            drvrs1 += temp.toString1() + "\n";
        }
        for (Order temp: orders.values()) {
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
    public void search() {
        System.out.println("Enter data in this way: car number, driver surname, date, weight, distance, cost from, to, customs tax, fuel cost \n" +
                "if you dont know any information type unk instead of it:");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        Vector<String> temp = new Vector<>(Arrays.asList(data.split(" ")));
        while(temp.indexOf("unk") >= 0)
        temp.remove("unk");
        String result = new String();
        for (Order tmp: orders.values()) {
            int flag = 0;
            List<String> temp_sep = Arrays.asList(tmp.toString2().split(" "));
            for (String tm: temp) {
                if(temp_sep.indexOf(tm) >= 0)
                    flag++;
            }
            if(flag == temp.size() && flag > 0)
                result += tmp.toString1() + "\n";
        }
        if(result.compareTo("") != 0)
        System.out.println("I find this orders:\n" + result);
        else
            System.out.println("Didn't find anything");
    }

    @Override
    public void add(int param) {
        switch (param) {
            case (1):
                System.out.println("Enter number, surname, category, experience," +
                        " address, salary and birth date of driver:");
                Scanner scd = new Scanner(System.in);
                String datad = scd.nextLine();
                if(!drivers.values().contains(new Driver(datad))){
                    drivers.put(new Driver(datad).getNumber(), new Driver(datad));
                    System.out.println("Added successfully!");
                }
                else System.out.println("Wrong input or driver already exists!");
                break;
            case(2):
                System.out.println("Enter number, carrying, make, and mileage of car:");
                Scanner scc = new Scanner(System.in);
                String datac = scc.nextLine();
                if(!cars.values().contains(new Car(datac))){
                    cars.put(new Car(datac).getNumber(), new Car(datac));
                    System.out.println("Added successfully!");
                }
                else System.out.println("Wrong input or car already exists!");
                break;
            case(3):
                System.out.println("Enter car number, driver surname," +
                        " date, weight, distance, cost from, to, customs tax, fuel cost");
                Scanner sco = new Scanner(System.in);
                String datao = sco.nextLine();
                if(!orders.values().contains(new Order(datao))){
                    orders.put(new Order(datao).getNumber(), new Order(datao));
                    System.out.println("Added successfully!");
                }
                else System.out.println("Wrong input or order already exists!");
                break;
        }
    }

    @Override
    public void delete(int param) {
        switch (param) {
            case (1):
                System.out.println("Enter number, surname, category, experience," +
                        " address, salary and birth date of driver:");
                Scanner scd = new Scanner(System.in);
                String datad = scd.nextLine();
                if(drivers.values().contains(new Driver(datad))){
                    drivers.remove(new Driver(datad).getNumber(), new Driver(datad));
                    System.out.println("Deleted successfully!");
                }
                else System.out.println("Wrong input or driver already deleted!");
                break;
            case(2):
                System.out.println("Enter number, carrying, make, and mileage of car:");
                Scanner scc = new Scanner(System.in);
                String datac = scc.nextLine();
                if(cars.values().contains(new Car(datac))){
                    cars.remove(new Car(datac).getNumber(), new Car(datac));
                    System.out.println("Deleted successfully!");
                }
                else System.out.println("Wrong input or car already deleted!");
                break;
            case(3):
                System.out.println("Enter car number, driver surname," +
                        " date, weight, distance, cost from, to, customs tax, fuel cost");
                Scanner sco = new Scanner(System.in);
                String datao = sco.nextLine();
                if(orders.values().contains(new Order(datao))){
                    orders.remove(new Order(datao).getNumber(), new Order(datao));
                    System.out.println("Deleted successfully!");
                }
                else System.out.println("Wrong input or order already deleted!");
                break;
        }
    }

    @Override
    public void change(int param) {
        switch (param) {
            case (1):
                System.out.println("Enter number, surname, category, experience," +
                        " address, salary and birth date of driver:");
                Scanner scd = new Scanner(System.in);
                String datad = scd.nextLine();
                if(drivers.values().contains(new Driver(datad))){
                    System.out.println("Enter new data: ");
                    String datadn = scd.nextLine();
                    drivers.remove(new Driver(datad).getNumber(), new Driver(datad));
                    drivers.put(new Driver(datadn).getNumber(), new Driver(datadn));
                    System.out.println("Changed successfully!");
                }
                else System.out.println("Wrong input or driver didn't exists!");
                break;
            case(2):
                System.out.println("Enter number, carrying, make, and mileage of car:");
                Scanner scc = new Scanner(System.in);
                String datac = scc.nextLine();
                if(cars.values().contains(new Car(datac))){
                    System.out.println("Enter new data: ");
                    String datacn = scc.nextLine();
                    cars.remove(new Car(datac).getNumber(), new Car(datac));
                    cars.put(new Car(datacn).getNumber(), new Car(datacn));
                    System.out.println("Changed successfully!");
                }
                else System.out.println("Wrong input or car didn't exists!");
                break;
            case(3):
                System.out.println("Enter car number, driver surname," +
                        " date, weight, distance, cost from, to, customs tax, fuel cost");
                Scanner sco = new Scanner(System.in);
                String datao = sco.nextLine();
                if(orders.values().contains(new Order(datao))){
                    System.out.println("Enter new data: ");
                    String dataon = sco.nextLine();
                    orders.remove(new Order(datao).getNumber(), new Order(datao));
                    orders.put(new Order(dataon).getNumber(), new Order(dataon));
                    System.out.println("Changed successfully!");
                }
                else System.out.println("Wrong input or order didn't exists!");
                break;
        }
    }

    @Override
    public void show(int param) {
        if(param == 2){
            System.out.println("Cars list: ");
            for (Car temp: cars.values()) {
                System.out.println(temp.toString1() + '\n');
            }
        }
        if(param == 1){
            System.out.println("Drivers list: ");
            for (Driver temp: drivers.values()) {
                System.out.println(temp.toString1() + '\n');
            }
        }
    }

    public HashMap<Integer, Car> getCars() {
        return cars;
    }

    public HashMap<Integer, Driver> getDrivers() {
        return drivers;
    }

    public HashMap<Integer, Order> getOrders() {
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
                        "To search order press 4 \n" +
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

    public void menu() throws IOException {
        show_menu(0);
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        switch (Integer.parseInt(command)){
            case(0):
                write();
                ser_w();
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
                        add(1);
                        menu();
                        break;
                    case(2):
                        delete(1);
                        menu();
                        break;
                    case(3):
                        change(1);
                        menu();
                        break;
                    case(4):
                        show(1);
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
                        add(2);
                        menu();
                        break;
                    case(2):
                        delete(2);
                        menu();
                        break;
                    case(3):
                        change(2);
                        menu();
                        break;
                    case(4):
                        show(2);
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
                        add(3);
                        menu();
                        break;
                    case(2):
                        delete(3);
                        menu();
                        break;
                    case(3):
                        change(3);
                        menu();
                        break;
                    case(4):
                        search();
                        menu();
                        break;
                }
                break;
        }
    }

}
