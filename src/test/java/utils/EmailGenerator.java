package utils;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class EmailGenerator {
     public static String fakeEmail;

    public void generateEmail() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        fakeEmail = fakeValuesService.bothify("???????##@mail.ru");
    }
}
