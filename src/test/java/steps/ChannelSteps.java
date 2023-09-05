package steps;

import pages.ChannelPage;

public class ChannelSteps {
    ChannelPage channelPage;

    public ChannelSteps() {
        channelPage = new ChannelPage();
    }
    public ChannelSteps openPage(){
        channelPage
                .isPageOpened();
      return this;
    }
    public ChannelSteps writeTextMessage(String textMessage){
        channelPage
                .enterText(textMessage);
        return this;
    }
    public ChannelSteps sendTextMessage(){
        channelPage
                .clickEnterButton();
        return this;
    }
    public ChannelSteps checkThatMessageSended(String textMessage){
        channelPage
                .checkTextMessage(textMessage);
        return this;
    }
}
