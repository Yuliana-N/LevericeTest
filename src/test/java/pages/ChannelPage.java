package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Log4j2
public class ChannelPage {

    private static final String MESSAGE_SECTION = ".create-message-section";
    private static final String INPUT_MESSAGE = "#input-message p";
    private static final String BUTTON = ".ic-action-float-plus";
    private static final String TEXT_MESSAGE = ".message-render span p";

    public ChannelPage isPageOpened() {
        $(MESSAGE_SECTION).shouldBe(Condition.visible);
        return this;
    }


    public ChannelPage enterText(String textMessage) {
        $(INPUT_MESSAGE).sendKeys(textMessage);
        return this;
    }

    public ChannelPage clickEnterButton() {
        sleep(1000);
        $(INPUT_MESSAGE).sendKeys(Keys.ENTER);
        return this;
    }

    public ChannelPage checkTextMessage(String textMessage) {
        sleep(1000);
        List<String> listOfMessage = $$(byCssSelector(TEXT_MESSAGE)).texts();
        $$(byCssSelector(TEXT_MESSAGE)).contains(exactValue(textMessage));
        return this;
    }
}
