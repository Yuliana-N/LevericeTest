package tests;

import org.testng.annotations.Test;

public class ChannelTest extends LoginTest {

    @Test
    public void sendMessage() {
        String text = textGenerator.generateText();
        login();
        channelSteps
                .openPage()
                .writeTextMessage(text)
                .sendTextMessage()
                .checkThatMessageSended(text);
    }
}
