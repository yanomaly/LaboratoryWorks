package Lab7;

import java.io.*;
import java.security.NoSuchAlgorithmException;

public class Runner {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("run.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        LibraryV1 run = (LibraryV1) objectInputStream.readObject();
//        LibraryV1 run = new LibraryV1();
        run.show_menu(args);
    }

}
