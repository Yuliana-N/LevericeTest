package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.Data;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Data
public class MailHogPage {

    public static String validationCode;
    private static final String URL = "https://autotest.leverice.net/email/";
    private static final String MESSAGES_CSS = ".messages";
    private static final String VALIDATION_CODE_CSS = ".validation-code";
    private static final String FRAME_ID = "preview-html";

    public void openPage() {
        Selenide.executeJavaScript("window.open()");
        switchTo().window(1);
        open(URL);
        isPageOpened();
    }

    public void isPageOpened() {
        $(MESSAGES_CSS).waitUntil(Condition.visible, 10000);
    }

    public void getValidationCode(String email) {
        $(byText(email)).click();
        switchTo().frame(FRAME_ID);
        validationCode = $(VALIDATION_CODE_CSS).getText();
    }

    public void closeMailHog() {
        Selenide.closeWindow();
        switchTo().window(0);
    }
}
