package Lab7;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "GB");
        ResourceBundle rb = ResourceBundle.getBundle("Lab7.res.Interfa", locale);
        Object s = rb.getObject("app_menu_a");
        System.out.println(s);
    }

}
