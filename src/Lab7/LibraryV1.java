package Lab7;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryV1 implements Serializable {

    static class User implements Serializable{
        private Date craeted;
        private String name;
        private String hash_password;
        private Map<String, Date> books = new HashMap<String, Date>();

        public String getName() {return name;}

        public Map<String, Date> getBooks() {return books;}

        public String getHash_password() {return hash_password;}

        public User() {}

        public User(String name, String hash_password) {
            this.name = name;
            this.hash_password = hash_password;
        }
    }

    class Admin implements Serializable{
        private String name;
        private String hash_password;

        public String getName() {
            return name;
        }

        public String getHash_password() {
            return hash_password;
        }

        public static void unlock_user(String[] args) throws NoSuchAlgorithmException {
            Scanner sc = new Scanner(System.in);
            System.out.println(rb.getString("user"));
            String user = sc.nextLine();
            for (User us: black_list) {
                if(us.getName().compareTo(user) == 0) {
                    black_list.remove(us);
                    System.out.println(rb.getString("success"));
                    break;
                }
            }
            System.out.println(rb.getString("fail"));
            show_menu(args);
        }

        public static void add_book(String[] args) throws NoSuchAlgorithmException {
            Scanner sc = new Scanner(System.in);
            System.out.println(rb.getString("book_name"));
            String nm = sc.nextLine();
            System.out.println(rb.getString("author"));
            String author = sc.nextLine();
            String pass_name = nm + " " + author;
            int flag = 0;
            for (String temp: books_list) {
                if(pass_name.compareTo(temp) == 0)
                    flag++;
            }
            if(flag == 0) {
                books_list.add(pass_name);
                System.out.println(rb.getString("success"));
            }
            else
                System.out.println(rb.getString("fail"));
            show_menu(args);
        }
    }

    private static ResourceBundle rb;
    private static Locale locale;
    private static Integer user_number;
    private static Integer statment = 0;
    private static List<User> users = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();
    private static List<User> black_list = new ArrayList<>();
    private static List<String> books_list = new ArrayList<>();

    public static void give_book(String[] args){

    }

    public static void pick_book(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        System.out.println(rb.getString("book_name"));
        String nm = sc.nextLine();
        System.out.println(rb.getString("author"));
        String author = sc.nextLine();
        String pass_name = nm + " " + author;
        for (String name: users.get(user_number).getBooks().keySet()) {
            if(pass_name.compareTo(name) == 0){
                users.get(user_number).getBooks().remove(pass_name);
                System.out.println(rb.getString("success"));
                break;
            }
        }
        show_menu(args);
    }

    public static void show_list(String[] args) throws NoSuchAlgorithmException {
        System.out.println(rb.getString("list"));
        for (String book: books_list)
            System.out.println(book);
        show_menu(args);
    }

    public static void ban_user(String[] args) throws NoSuchAlgorithmException {
        Date current_date = new Date();
        for (User user: users) {
            for (Date date: user.getBooks().values()) {
                if(current_date.getTime() - date.getTime() > 1)
                    black_list.add(user);
            }
        }
        show_menu(args);
    }

    public static void register(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        System.out.println(rb.getString("nickname"));
        String nicname;
        int flag;
        do {
            flag = 0;
            nicname = sc.nextLine();
            for (User user : users) {
                if (user.getName().compareTo(nicname) == 0)
                    flag++;
            }
            if (flag != 0)
                System.out.println(rb.getString("same_name"));
            else
                flag = 0;
        } while(flag != 0);
        System.out.println(rb.getString("password"));
        String password = sc.nextLine();
        Pattern pass1 = Pattern.compile("[A-Z]+");
        Pattern pass2 = Pattern.compile("[a-z]+");
        Pattern pass3 = Pattern.compile("[0-9]+");
        Matcher pass1_m = pass1.matcher(password);
        Matcher pass2_m = pass2.matcher(password);
        Matcher pass3_m = pass3.matcher(password);
        if(!pass1_m.find() || !pass2_m.find() || !pass3_m.find()  || password.length() < 5) {
            while (!pass1_m.find() || !pass2_m.find() || !pass3_m.find()  || password.length() < 5) {
                System.out.println(rb.getString("weak_password"));
                password = sc.nextLine();
                pass1_m = pass1.matcher(password);
                pass2_m = pass2.matcher(password);
                pass3_m = pass3.matcher(password);
            }
        }
        users.add(new User(nicname, password));
        user_number = users.size() - 1;
        show_menu(args);
    }

    public static void login(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        System.out.println(rb.getString("nickname"));
        String nicname = sc.nextLine();
        System.out.println(rb.getString("password"));
        String password = sc.nextLine();
        byte paass[] = null;
        MessageDigest pass_sh = MessageDigest.getInstance("SHA-1");
        pass_sh.update(password.getBytes(StandardCharsets.UTF_8));
        paass = pass_sh.digest();
        BigInteger bi = new BigInteger(1, paass);
        password = bi.toString(16);
        int flaga = 0, flagu = 0;
        for (User user: users) {
            if(nicname.compareTo(user.getName()) == 0 && password.compareTo(user.getHash_password()) == 0)
                flagu++;
        }
        for (Admin admin: admins) {
            if(nicname.compareTo(admin.getName()) == 0 && password.compareTo(admin.getHash_password()) == 0)
                flaga++;
        }
        if(flagu == 1) {
            statment = 2;
            show_menu(args);
        }
        if(flaga == 1){
            statment = 2;
            show_menu(args);
        }
        if(flaga == 0 && flagu == 0) {
            System.out.println(rb.getString("wrong_input"));
            statment = 0;
            show_menu(args);
        }
        user_number = users.indexOf(new User(nicname, password));
    }

    public static void show_menu(String[] args) throws NoSuchAlgorithmException {
        if(args.length > 1) {
            ban_user(args);
            locale = new Locale(args[0], args[1]);
            rb = ResourceBundle.getBundle("Lab7.res.Interfa", locale);
            switch(statment){
                case(0):
                    System.out.println(rb.getObject("menu"));
                    break;
                case(1):
                    System.out.println(rb.getObject("app_menu_a"));
                    break;
                case(2):
                    System.out.println(rb.getObject("app_menu_u"));
                    break;
            }
            menu(args);
        }
        else {
            System.out.println("Wrong locale!");
            System.exit(0);
        }
    }

    public static void menu(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        switch(statment){
            case(0):
                switch(Integer.parseInt(command)){
                    case(0):
                        System.exit(0);
                        break;
                    case(1):
                        register(args);
                        break;
                    case(2):
                        login(args);
                        break;
                }
                break;
            case(1):
                switch(Integer.parseInt(command)){
                    case(0):
                        System.exit(0);
                        break;
                    case(1):
                        Admin.unlock_user(args);
                        break;
                    case(2):
                        Admin.add_book(args);
                        break;
                    case(3):
                        show_list(args);
                        break;
                }
                break;
            case(2):
                switch(Integer.parseInt(command)){
                    case(0):
                        System.exit(0);
                        break;
                    case(1):
                        give_book(args);
                        break;
                    case(2):
                        pick_book(args);
                        break;
                    case(3):
                        show_list(args);
                        break;
                }
                break;
        }

    }
}
