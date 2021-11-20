package Lab8.AutoPark;

import java.io.IOException;
import java.io.Serializable;

public interface AutoPark extends Serializable {
    void read() throws IOException;
    void write() throws IOException;
    void ser_r() throws IOException, ClassNotFoundException;
    void ser_w() throws IOException;
    void search(Object obj);
    void add(Object obj);
    void delete(Object obj);
    void change(Object obj);
    void show(Object obj);
}
