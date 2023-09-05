package utils;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class TextGenerator {
    public static String fakeText;

    public String generateText() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        fakeText = fakeValuesService.letterify("Hello,?????! ??? ??????? ???");
        return fakeText;
    }
}
