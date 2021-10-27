package Lab4;
//Толстой Ян 8 курс 2 группа
//Регулярные выражения
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

    private static String GUID = "[{][A-Fa-f0-9]+[-][A-Fa-f0-9]+[-][A-Fa-f0-9]+" +
                                 "[-][A-Fa-f0-9]+[-][A-Fa-f0-9]+[}]|" +
                                 "[A-Fa-f0-9]+[-][A-Fa-f0-9]+[-][A-Fa-f0-9]+" +
                                 "[-][A-Fa-f0-9]+[-][A-Fa-f0-9]+";

    private static String MAC = "[A-Fa-f0-9]{2}(:|[-]|)[A-Fa-f0-9]{2}(:|[-]|)" +
                                "[A-Fa-f0-9]{2}(:|[-]|)[A-Fa-f0-9]{2}(:|[-]|)" +
                                "[A-Fa-f0-9]{2}(:|[-]|)[A-Fa-f0-9]{2}";

    private static String URL =  "((https://)|(http://)|(www\\.)|)" +
                                 "([a-z0-9]+([-]*[a-z0-9]*)*[a-z0-9]+)" +
                                 "[\\.[a-z]{2,6}]((:[0-9]{4})|.{0,50})";

    private static String color = "#[A-Fa-f0-9]{6}";

    private static String date = "(0[1-9]|[12][0-9]|3[01])/" +
                                 "(0[1-9]|1[1-2])/" +
                                 "(1[6-9][0-9][0-9]|[2-9][0-9][0-9][0-9])";

    private static String email = "[a-zA-Z1-9\\-\\.\\_]{1,16}@[a-z]{3,5}\\.[a-z]{2,3}";

    private static String IP_adres = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                     "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                     "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                     "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

    private static String password = "(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,}";

    private static String number = "[1-9][0-9]{5}";

    public static void main(String[] args) {
        Pattern.compile(number).matcher("г.Минск,ул.Гикало,д.22,кв.14").matches();
        System.out.println(Pattern.compile(number).matcher("г.Минск,ул.Гикало,д.22,кв.14").matches());
    }
}
