package Lab5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Pattern;

public class Contact_list implements Comparator<Contact_list>, Comparable<Contact_list> {
    private String name = "No info";
    private String mobile_phone_number = "No info";
    private String work_phone_number = "No info";
    private String home_phone_number = "No info";
    private String email = "No info";
    private String web_site = "No info";
    private String home_adres = "No info";

    public int param = 0;

    Contact_list (){}
    //Конструктор, принимающий строку, с проверкой корректности введённых данных
    Contact_list (String data){
        String arr[] = data.split(", ");
        String reg_n = "[А-Я][а-я]{1,15}";
        String reg_m_ph = "(\\+375|80)[0-9]{9}";
        String reg_w_ph = "((\\+375|80)[0-9]{9})|([0-9]{7})";
        String reg_h_ph = "[0-9]{7}";
        String reg_em = "[a-zA-Z1-9\\-\\.\\_]{1,16}@[a-z]{3,6}\\.[a-z]{2,3}";
        String reg_ws = "(www\\.|)([a-z0-9]+([-]*[a-z0-9]*)*[a-z0-9]+)(\\.[a-z]{2,6})";
        String reg_h_a = "г\\.[А-Я][а-я]+[,]ул\\.[А-Я][а-я]+[,]" +
                "д\\.([1-9][0-9][0-9]|[1-9][0-9]|[1-9])[,]" +
                "кв\\.([1-9][0-9][0-9]|[1-9][0-9]|[1-9])";
        int flag = 0;
        //Проверка корректности введённых данных
        switch(7 - arr.length){
            case (0):
                if(Pattern.compile(reg_h_a).matcher(arr[6]).matches())
                    flag++;
            case (1):
                if(Pattern.compile(reg_ws).matcher(arr[5]).matches())
                    flag++;
            case (2):
                if(Pattern.compile(reg_em).matcher(arr[4]).matches())
                    flag++;
            case (3):
                if(Pattern.compile(reg_h_ph).matcher(arr[3]).matches())
                    flag++;
            case(4):
                if(Pattern.compile(reg_w_ph).matcher(arr[2]).matches())
                    flag++;
            case (5):
                if(Pattern.compile(reg_n).matcher(arr[0]).matches() && Pattern.compile(reg_m_ph).matcher(arr[1]).matches())
                    flag+=2;
        }
        //Инициализация полей в зависимости от количества данных и их корректности
        if(flag == arr.length){
            if(arr.length >= 2){
                name = arr[0];
                mobile_phone_number = arr[1];
            }
            if(arr.length >= 3)
                work_phone_number = arr[2];
            if(arr.length >= 4)
                home_phone_number = arr[3];
            if(arr.length >= 5)
                email = arr[4];
            if(arr.length >= 6)
                web_site = arr[5];
            if(arr.length == 7)
                home_adres = arr[6];
        }
        else System.out.println("Wrong input!");
    }

    //Сеттеры с проверкой корректности введённых данных
    public void setName(String name) {
        if(Pattern.compile("[А-Я][а-я]{1,15}").matcher(name).matches())
            this.name = name;
        else System.out.println("Wrong name!");
    }
    public void setMobile_phone_number(String mobile_phone_number) {
        if(Pattern.compile("(\\+375|80)[0-9]{9}").matcher(mobile_phone_number).matches())
            this.mobile_phone_number = mobile_phone_number;
        else System.out.println("Wrong number!");
    }
    public void setWork_phone_number(String work_phone_number) {
        if(Pattern.compile("((\\+375|80)[0-9]{9})|([0-9]{7})").matcher(work_phone_number).matches())
            this.work_phone_number = work_phone_number;
        else System.out.println("Wrong number!");
    }
    public void setHome_phone_number(String home_phone_number) {
        if(Pattern.compile("[0-9]{7}").matcher(home_phone_number).matches())
            this.home_phone_number = home_phone_number;
        else System.out.println("Wrong number!");
    }
    public void setEmail(String email) {
        if(Pattern.compile("[a-zA-Z1-9\\-\\.\\_]{1,16}@[a-z]{3,5}\\.[a-z]{2,3}").matcher(email).matches())
            this.email = email;
        else System.out.println("Wrong email!");
    }
    public void setWeb_site(String web_site) {
        if(Pattern.compile("(www\\.|)([a-z0-9]+([-]*[a-z0-9]*)*[a-z0-9]+)(\\.[a-z]{2,6})").matcher(web_site).matches())
            this.web_site = web_site;
        else System.out.println("Wrong web site!");
    }
    public void setHome_adres(String home_adres) {
        if(Pattern.compile("г\\.[А-Я][а-я]+[,]ул\\.[А-Я][а-я]+[,]" +
                "д\\.([1-9][0-9][0-9]|[1-9][0-9]|[1-9])[,]" +
                "кв\\.([1-9][0-9][0-9]|[1-9][0-9]|[1-9])").matcher(home_adres).matches())
            this.home_adres = home_adres;
        else System.out.println("Wrong web address!");
    }

    public String getName() {
        return name;
    }
    public String getMobile_phone_number() {
        return mobile_phone_number;
    }
    public String getWork_phone_number() {
        return work_phone_number;
    }
    public String getHome_phone_number() {
        return home_phone_number;
    }
    public String getEmail() {
        return email;
    }
    public String getWeb_site() {
        return web_site;
    }
    public String getHome_adres() {
        return home_adres;
    }

//    Сравнение по определённому полю в зависимости от переданного параметра:
//    1 - По имени
//    2 - По номеру мобильного
//    3 - По рабочему номеру
//    4 - По домашнему номеру
//    5 - По адресу электронной почты
//    6 - По веб сайту
//    7 - По домашнему адресу

    public int compareTo_run(Contact_list o1, int param){
        this.param = param;
        return this.compareTo(o1);
    }
    @Override
    public int compareTo(Contact_list o) {
        switch(param){
            case(1): return this.getName().compareTo(o.getName());
            case(2): return this.getMobile_phone_number().compareTo(o.getMobile_phone_number());
            case(3): return this.getWork_phone_number().compareTo(o.getWork_phone_number());
            case(4): return this.getHome_phone_number().compareTo(o.getHome_phone_number());
            case(5): return this.getEmail().compareTo(o.getEmail());
            case(6): return this.getWeb_site().compareTo(o.getWeb_site());
            case(7): return this.getHome_adres().compareTo(o.getHome_adres());
            default:
                System.out.println("Wrong param!");
                return 0;
        }
    }

    public int compare_run(Contact_list o1, Contact_list o2, int param){
        this.param = param;
        return compare(o1, o2);
    }
    @Override
    public int compare(Contact_list o1, Contact_list o2) {
        switch(param){
            case(1): return o1.getName().compareTo(o2.getName());
            case(2): return o1.getMobile_phone_number().compareTo(o2.getMobile_phone_number());
            case(3): return o1.getWork_phone_number().compareTo(o2.getWork_phone_number());
            case(4): return o1.getHome_phone_number().compareTo(o2.getHome_phone_number());
            case(5): return o1.getEmail().compareTo(o2.getEmail());
            case(6): return o1.getWeb_site().compareTo(o2.getWeb_site());
            case(7): return o1.getHome_adres().compareTo(o2.getHome_adres());
            default:
                System.out.println("Wrong param!");
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Contact:" + '\n' +
                "name: " + name + '\n' +
                "mobile_phone_number: " + mobile_phone_number + '\n' +
                "work_phone_number: " + work_phone_number + '\n' +
                "home_phone_number: " + home_phone_number + '\n' +
                "email: " + email + '\n' +
                "web_site: " + web_site + '\n' +
                "home_adres: " + home_adres;
    }

    public void sort(Contact_list list[], String param){
        int param_n = 0;
        if(param.compareTo("name") == 0)
            param_n = 1;
        if(param.compareTo("mobile phone") == 0)
            param_n = 2;
        if(param.compareTo("work number") == 0)
            param_n = 3;
        if(param.compareTo("home number") == 0)
            param_n = 4;
        if(param.compareTo("email") == 0)
            param_n = 5;
        if(param.compareTo("web site") == 0)
            param_n = 6;
        if(param.compareTo("home address") == 0)
            param_n = 7;
        for (int i = 0; i < list.length ; i++) {
            for (int j = 0; j < list.length; j++) {
                if(new Contact_list().compare_run(list[i], list[j], param_n) < 0){
                    Contact_list temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Contact_list run = new Contact_list();
        Contact_list list[] = new Contact_list[5];
        list[0] = new Contact_list("Ян, +375295629604, 80295629604, 2936971, fat_taf@mail.ru, yanomaly.inst, г.Минск,ул.Толстого,д.5,кв.15");
        list[1] = new Contact_list("Леха, +375297610506, 2967971, 2867971, testpochta@gmail.com");
        list[2] = new Contact_list("Чига, +375292283220, 2936881, 2960071, grafGrifer@bsu.by");
        list[3] = new Contact_list("Чупапи, +375291414889, 2765881, 2969271, po4ta@tut.by, muniana.com");
        list[4] = new Contact_list("Жорик, 80291337229, 80291629904, 2919278, volk_muzhik@yendex.org");
        run.sort(list, "web site");
        for (Contact_list temp:
                list) {
            System.out.println(temp.toString());
        }
    }
}

