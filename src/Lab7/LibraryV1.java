package Lab7;

import java.io.Serializable;
import java.util.*;

public class LibraryV1 implements Serializable {

    class User implements Serializable{
        private String name;
        private String hash_password;
        private Map<String, Date> books = new HashMap<String, Date>();
    }

    class Admin implements Serializable{
        private String name;
        private String hash_password;

        public static void unlock_user(String info){

        }

        public static void add_book(String info){

        }
    }

    private Integer statment;
    private List<User> users = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private List<User> black_list = new ArrayList<>();
    private List<String> books_list = new ArrayList<>();

    public static void give_book(String info){

    }

    public static void show_list(){

    }

    public static void ban_user(String info){

    }

    public static void show_menu(){

    }

    public static void register(){

    }

    public static void login(){

    }
}
