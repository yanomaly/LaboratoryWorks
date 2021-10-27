package Lab6;
//Толстой Ян 8 группа 2 курс
//Разработать программу для проверки текстового файла на наличие слов латинского и русского алфавита.
//Программа должна создать и записать в разных два файла (соответственно) найденные слова и номера
//строк с которых они начинаются.
import java.io.*;
import java.util.Vector;
import java.util.regex.Pattern;

public class Words_check {

    Vector<String> data = new Vector<>();
    Vector<String> words = new Vector<>();
    Vector<Integer> strings = new Vector<>();

    public void read() throws IOException {
        BufferedReader input_stream = new BufferedReader(new FileReader("C:\\Users\\famil\\IdeaProjects\\Programming\\src\\Lab6\\Resources\\Inp"));
        String input_temp = input_stream.readLine();
        while(input_temp != null) {
            data.add(input_temp);
            input_temp = input_stream.readLine();
        }
        input_stream.close();
    }

    public void search(){
        int str = 0;
        for (String temp: data) {
            String[] temp_arr = temp.split(" ");
            for (String temp_a: temp_arr) {
                if(Pattern.compile("[A-Za-z]+|[А-Яа-я]+").matcher(temp_a).matches()){
                    words.add(temp_a);
                    strings.add(str);
                }
            }
            str++;
        }
    }

    public void write() throws IOException {
        String wrds = new String(), strngs = new String();
        BufferedWriter words_w = new BufferedWriter(new FileWriter("Words.txt"));
        BufferedWriter strings_w = new BufferedWriter(new FileWriter("Strings.txt"));
        for (String temp: words)
            wrds += temp + "\n";
        for (Integer temp: strings)
            strngs += temp + "\n";
        words_w.write(wrds);
        strings_w.write(strngs);
        words_w.close();
        strings_w.close();
    }

    public static void main(String[] args) throws IOException {
        Words_check run = new Words_check();
        run.read();
        run.search();
        run.write();
    }
}
