package utilities;

import com.github.javafaker.Faker;

public class OpencartDataFactory {

    public static Faker faker = new Faker();

    public static String getEmail(){
        return faker.internet().emailAddress();
    }

    public static String getPassword(){
        return faker.internet().password();
    }

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getTelephone(){
        return faker.phoneNumber().phoneNumber();
    }
}
