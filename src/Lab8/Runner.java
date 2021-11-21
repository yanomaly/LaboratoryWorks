package Lab8;

import Lab8.AutoPark.APark;
import Lab8.Entities.Order;

import java.io.*;
import java.util.Vector;

public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new APark().menu();

//        APark a = new APark();
//        FileOutputStream outputStream = new FileOutputStream("project.ser");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(a);
//        objectOutputStream.close();
    }
}
