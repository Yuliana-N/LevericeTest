package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import pages.MailHogPage;
import steps.LoginSteps;
import steps.WorkspaceSteps;
import utils.EmailGenerator;
import utils.FolderGenerator;
import pages.LoginPage;
import steps.ChannelSteps;
import utils.TextGenerator;
import utils.EmailGenerator;

public class BaseTest {
    LoginSteps loginSteps;
    LoginTest loginTest;
    LoginPage loginPage;
    WorkspaceSteps workspaceSteps;
    ChannelTest channelTest;
    ChannelSteps channelSteps;
    EmailGenerator emailGenerator;
    FolderGenerator folderGenerator;
    TextGenerator textGenerator;
    MailHogPage mailHogPage;
 


    @BeforeClass
    public void openBrowser() {
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;   // выставить false для закрытия браузера
        loginSteps = new LoginSteps();
        loginTest = new LoginTest();
        loginPage = new LoginPage();
        emailGenerator = new EmailGenerator();
        workspaceSteps = new WorkspaceSteps();
        folderGenerator = new FolderGenerator();
        channelTest = new ChannelTest();
        channelSteps = new ChannelSteps();
        textGenerator = new TextGenerator();
        mailHogPage = new MailHogPage();
    }

    @AfterMethod
    public void closeBrowser()
    {
        Selenide.closeWebDriver();
    }
}
