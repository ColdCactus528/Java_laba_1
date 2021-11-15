package Lab_3;
import java.util.ArrayList;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Employee {
    public enum Gender {
        MALE,
        FEMALE
    }

    public enum Dept {
        LOGISTIC,
        KRABOV,
        VKUSNOYEDI,
        POSLEOBEDENNOGOSNA;
    }

    public enum Role {
        STAFF,
        MANAGER,
        EXECUTIVE
    }

    public Employee (String givenName, String surName, int age, Gender gender, Role role, Dept dept, String eMail, String phone,
                String address, String city, String state, int code) {

        this.givenName = givenName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.dept = dept;
        this.eMail = eMail;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.code = code;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public String getSurName() {
        return this.surName;
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return  this.gender;
    }

    public Role getRole() {
        return this.role;
    }

    public String getAddress() {
        return this.address;
    }

    public Dept getDept() {
        return this.dept;
    }

    public String getEMail() {
        return this.eMail;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "givenName='" + givenName + '\'' +
                ", surName='" + surName + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", dept='" + dept + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public static ArrayList<Employee> createShortList(int quantity) throws IOException {
        SecureRandom randomNumber = new SecureRandom();
        ArrayList<Employee> list = new ArrayList<>(quantity);
        if (quantity < 7)
            quantity = 7;

        String[] massOfStates = {
                "Амурская", "Архангельская", "Астраханская", "Белгородская", "Брянская", "Владимирская",
                "Волгоградская", "Вологодская", "Воронежская", "Ивановская", "Иркутская", "Калининградская",
                "Калужская", "Камчатская", "Кемеровская", "Кировская", "Костромская", "Курганская",
                "Курская", "Ленинградская", "Липецкая", "Магаданская", "Московская", "Мурманская",
                "Нижегородская", "Новгородская", "Новосибирская", "Омская", "Оренбургская", "Орловская",
                "Пензенская", "Пермская", "Псковская", "Ростовская", "Рязанская", "Самарская",
                "Саратовская", "Сахалинская", "Свердловская", "Смоленская", "Тамбовская", "Тверская",
                "Томская", "Тульская", "Тюменская", "Ульяновская", "Челябинская", "Читинская",
                "Ярославская"};

        for (int i = 0; i < quantity; i++) {
            EmployeeBuilder builder = new EmployeeBuilder();
            String url = "https://getfakedata.com/person/ru_RU";
            Document document = Jsoup.connect(url).get();
            String sGender = document.body().getElementsByTag("td").get(1).text();
            Gender gender ;
            if (sGender.equals("Male"))
                gender = Gender.MALE;
            else
                gender = Gender.FEMALE;


            String sGivenName = document.body().getElementsByTag("h3").get(0).text().split(" ")[1];
            String sSurName = document.body().getElementsByTag("h3").get(0).text().split(" ")[0];
            String sAge = document.body().getElementsByTag("td").get(3).text().split("\\(")[1].split(" ")[0];
            String sEmail = document.body().getElementsByTag("td").get(7).text();
            String sPhone = document.body().getElementsByTag("td").get(5).text();
            String sAddress = document.body().getElementsByTag("p").get(2).text().split(",")[3]
                    + document.body().getElementsByTag("p").get(2).text().split(",")[4];
            String sCity = document.body().getElementsByTag("p").get(2).text().split(",")[2].split(" ")[2];
            String sState = document.body().getElementsByTag("p").get(2).text().split(",")[1].split(" ")[1];

            int Code = 0;
            for (int j = 0; j < massOfStates.length; j++) {
                if (Objects.equals(sState, massOfStates[j])){
                    Code = j + 28;
                }
            }

            Role role = Role.values()[randomNumber.nextInt(Role.values().length)];
            Dept dept = Dept.values()[randomNumber.nextInt(Dept.values().length)];

            builder.setGivenName(sGivenName);
            builder.setSurName(sSurName);
            builder.setAge(Integer.parseInt(sAge));
            builder.setGender(gender);
            builder.setEMail(sEmail);
            builder.setPhone(sPhone);
            builder.setAddress(sAddress);
            builder.setCity(sCity);
            builder.setState(sState);
            builder.setCode(Code);
            builder.setRole(role);
            builder.setDept(dept);

            list.add(builder.getResult());
        }

        return list;
    }

    private final String givenName;
    private final String surName;
    private final int age;
    private final Gender gender;
    private final Role role;
    private final Dept dept;
    private final String eMail;
    private final String phone;
    private final String address;
    private final String city;
    private final String state;
    private final int code;
}
