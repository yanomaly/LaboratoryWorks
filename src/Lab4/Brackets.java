package Lab4;
//Толстой Ян 8 группа 2 курс
//Скобки
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class Brackets {

    private Vector<String> data = new Vector<>();

    public void read() throws IOException {
        //считывание из файла
        BufferedReader input_stream = new BufferedReader(new FileReader("src/Lab4/Lab7.Resources/input.txt"));
        String input_temp = input_stream.readLine();
        while(input_temp != null) {
            data.add(input_temp);
            input_temp = input_stream.readLine();
        }
        input_stream.close();
    }

    public void delete_brackets(){
        for (int i = 0; i < data.size(); i++) {
            String arr[] = data.get(i).split("");
            int     count = 0,
                    flag = 0, flag_previous = 0,
                    index_open[] = new int[arr.length],
                    index_close[] = new int[arr.length];
            //Перебор всех символов строки
            for (int j = 0; j < arr.length; j++) {
                //Включение счётчика скобок при обнаружении открывающейся
                if(arr[j].compareTo("(") == 0) {
                    int check = 1;
                    int open_length = 0, close_length = 0;
                    //Подсчёт количества открывающихся и закрывающихся скобок
                    while (flag > 0 || check == 1) {
                        if(arr[j].compareTo("(") == 0){
                            flag_previous = flag;
                            flag = 1;
                            if(flag - flag_previous >= 0) {
                                count++;
                                index_open[open_length] = j;
                                open_length++;
                            }
                        }
                        if(arr[j].compareTo(")") == 0){
                            flag_previous = flag;
                            flag = 2;
                            if(flag - flag_previous >= 0) {
                                count--;
                                index_close[close_length] = j;
                                close_length++;
                            }
                        }
                        j++;
                        if(flag - flag_previous < 0 || j >= arr.length) {
                            flag = 0;
                            check = 0;
                            j -= 2;
                        }
                    }
                    //Удаление символов в зависимости от количества скобок
                    if(count == 0 && open_length == 1 && close_length == 1)
                        Arrays.fill(arr, index_open[0], index_close[0] + 1, "");
                    if(count == 0 && open_length > 1 && close_length > 1) {
                        Arrays.fill(arr, index_open[0], index_open[1], "");
                        Arrays.fill(arr, index_close[open_length - 2] + 1, index_close[close_length - 1] + 1, "");
                    }

                    if(count > 0 && close_length == 1)
                        Arrays.fill(arr, index_open[open_length - 1], index_close[0] + 1, "");
                    if(count > 0 && close_length > 1){
                        Arrays.fill(arr, index_open[open_length - 2], index_open[open_length - 1] - 1, "");
                        Arrays.fill(arr, index_close[close_length - 2] + 1, index_close[close_length - 1] + 1, "");
                    }

                    if(count < 0 && open_length == 1)
                        Arrays.fill(arr, index_open[0], index_close[0] + 1, "");
                    if(count < 0 && open_length > 1){
                        Arrays.fill(arr, index_open[open_length - 2], index_open[open_length - 1], "");
                        Arrays.fill(arr, index_close[close_length - 2] + 1, index_close[close_length - 1] + 1, "");
                    }

                            count = 0;
                            flag = 0; flag_previous = 0;
                            index_open = new int[arr.length];
                            index_close = new int[arr.length];
                }
            }
            data.remove(i);
            String result = "";
            for (String temp: arr)
                result += temp;
            data.add(i, result);
        }
    }

    public static void main(String[] args) throws IOException {
        Brackets run = new Brackets();
        run.read();
        for (String temp:run.data)
            System.out.println(temp);
        run.delete_brackets();
        for (String temp:run.data)
            System.out.println(temp);
    }
}

