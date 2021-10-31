package Lab6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Sequrity {

    static Vector<Short> data = new Vector<>();
    static Vector<Short> encryption = new Vector<>();
    static Vector<String> anti_encryption = new Vector<>();

    public static void read() throws IOException {
        FileReader input_stream = new FileReader("C:\\Users\\famil\\IdeaProjects\\Programming\\src\\Lab6\\Lab7.Resources\\Inp");
        data.add((short)input_stream.read());
        while(input_stream.ready()) {
            data.add((short)input_stream.read());
        }
        input_stream.close();
    }


    public static void cipher(short key){
        for (Short temp: data) {
            short crypt = (short)(Integer.parseInt(Integer.toBinaryString(temp), 2)^Integer.parseInt(Integer.toBinaryString(key), 2));
            encryption.add(crypt);
        }
    }

    public static void anti_cipher(int key) {
            for (Short temp: encryption) {
                String crypt = Character.toString((char)(temp^Integer.parseInt(Integer.toBinaryString(key), 2)));
                anti_encryption.add(crypt);
            }
    }

    public static void write() throws IOException {
        FileOutputStream output_stream = new FileOutputStream("output.txt");
        for (Short temp: encryption) {
            String tmp[] = Short.toString(temp).split("");
            for (String tm: tmp) {
                output_stream.write(Integer.parseInt(tm));
            }
        }
    }


    public static void main(String[] args) throws IOException {

        Sequrity.read();
        for (Short temp: data) {
            System.out.println(temp + " " + (char)temp.intValue());
        }

        System.out.println(" ");

        Sequrity.cipher((short)123);
        for (Short temp: encryption) {
            System.out.println(temp);
        }

        System.out.println(" ");

        anti_cipher((short)123);
        for (String temp: anti_encryption) {
            System.out.print(temp);
        }

        write();
    }
}
