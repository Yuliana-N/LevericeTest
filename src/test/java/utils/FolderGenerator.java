package utils;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class FolderGenerator {
    public static String fakeFolderName;

    public void generateFolderName() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        fakeFolderName = fakeValuesService.bothify("???????");
    }
}
