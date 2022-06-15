package utils;

import com.github.javafaker.Faker;

public class MailGenerator {

    private MailGenerator() {
    }

    public static String getTemporaryEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

}
