package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final String URL = "https://autotest.leverice.net/public/client/";
    private static final String LOGIN_PAGE_IMAGE_CSS = ".tutorial-img__content";
    private static final String CREATE_WORKSPACE_TEXT = "Create a new Workspace";
    private static final String EMAIL_NAME = "email";
    private static final String CONTINUE_BUTTON_TEXT = "Continue";
    private static final String VALIDATION_CODE_FIELD_CSS = "input[inputmode=numeric]";
    private static final String FIRST_NAME_NAME = "fname";
    private static final String LAST_NAME_NAME = "lname";
    private static final String SUBMIT_INTRODUCE_YOURSELF_TEXT = "Continue";
    private static final String WORKSPACE_NAME_CSS = ".textarea__inner.in-workspace-wizard";
    private static final String SIGN_IN_TEXT = "Open a Workspace you already work in.";

    public void openPage() {
        open(URL);
        sleep(1000);
       isPageOpened();
    }

    public void isPageOpened() {
        $(LOGIN_PAGE_IMAGE_CSS).waitUntil(Condition.visible, 10000);
    }

    public void proceedToCreatingANewWorkspace(String email) {
        $(byText(CREATE_WORKSPACE_TEXT)).click();
        $(byName(EMAIL_NAME)).sendKeys(email);
        $(byText(CONTINUE_BUTTON_TEXT)).click();
    }

    public void enterValidationCode() {
        $(VALIDATION_CODE_FIELD_CSS).sendKeys(MailHogPage.validationCode);
    }

    public void fillIntroduceYourselfFields(String firstName, String lastName) {
        $(byName(FIRST_NAME_NAME)).sendKeys(firstName);
        $(byName(LAST_NAME_NAME)).sendKeys(lastName);
        $(byText(SUBMIT_INTRODUCE_YOURSELF_TEXT)).click();
    }

    public void createWorkspace(String newWorkspaceName) {
        $(byCssSelector(WORKSPACE_NAME_CSS)).waitUntil(Condition.visible,10000);
        sleep(1000);
        $(byCssSelector(WORKSPACE_NAME_CSS)).sendKeys(newWorkspaceName, Keys.ENTER);
    }

    public void closeTab() {
        Selenide.closeWindow();
    }

    public void proceedToSignIn(String email) {
        $(byText(SIGN_IN_TEXT)).click();
        $(byName(EMAIL_NAME)).sendKeys(email);
        $(byText(CONTINUE_BUTTON_TEXT)).click();
    }

    public void selectWorkspace(String workspaceName) {
        $(byText(workspaceName)).click();
    }
}
