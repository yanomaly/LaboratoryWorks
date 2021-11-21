package Lab8.Entities;

public class Driver extends Entity {

    private Integer number;
    private String surname;
    private String category;
    private Integer experience;
    private String address;
    private Double salary;
    private String birthday;

    @Override
    public String toString1(){
        return "Number: " + number + " surname: " + surname +
                " category: " + category + " experience: " + experience + " years"+
                " address: " + address + " salary: " + salary + "$" +
                " birthday: " + birthday;
    }

    @Override
    public String toString2(){
        return number + " " + surname + " " + category + " " +
                experience + " " + address + " " + salary + " " +
                 birthday;
    }

    @Override
    public boolean equals(Object o) {
        Driver driver = (Driver) o;
        return number.compareTo(driver.number) == 0 && surname.compareTo(driver.surname) == 0 &&
                category.compareTo(driver.category) == 0 && experience.compareTo(driver.experience) == 0 &&
                address.compareTo(driver.address) == 0 && salary.compareTo(driver.salary) == 0 &&
                birthday.compareTo(driver.birthday) == 0;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getNumber() {
        return number;
    }

    public Driver(String args){
        String[] arrgs = args.split(" ");
        number = Integer.parseInt(arrgs[0]);
        surname = arrgs[1];
        category = arrgs[2];
        experience = Integer.parseInt(arrgs[3]);
        address = arrgs[4];
        salary = Double.parseDouble(arrgs[5]);
        birthday = arrgs[6];
    }
}
