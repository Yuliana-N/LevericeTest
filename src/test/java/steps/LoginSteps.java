package steps;

import pages.LoginPage;
import pages.MailHogPage;
import utils.EmailGenerator;

public class LoginSteps {
    LoginPage loginPage;
    MailHogPage mailHogPage;
    EmailGenerator emailGenerator;

    public LoginSteps() {
        loginPage = new LoginPage();
        mailHogPage = new MailHogPage();
        emailGenerator = new EmailGenerator();
    }

    public void createANewWorkspace() {
        emailGenerator.generateEmail();
        loginPage.openPage();
        loginPage.proceedToCreatingANewWorkspace(EmailGenerator.fakeEmail);
    }

    public void fakeEmailMailHogValidation() {
        mailHogPage.openPage();
        mailHogPage.getValidationCode(EmailGenerator.fakeEmail);
        mailHogPage.closeMailHog();
    }

    public void fillWorkspaceFields(String firstName, String lastName, String newWorkspaceName) {
        loginPage.enterValidationCode();
        loginPage.fillIntroduceYourselfFields(firstName, lastName);
        loginPage.createWorkspace(newWorkspaceName);
        loginPage.closeTab();
    }

    public void signIn(String login) {
        loginPage.openPage();
        loginPage.proceedToSignIn(login);
    }

    public void MailHogValidation(String login) {
        mailHogPage.openPage();
        mailHogPage.getValidationCode(login);
        mailHogPage.closeMailHog();
    }

    public void selectWorkspace(String workspaceName) {
        loginPage.enterValidationCode();
        loginPage.selectWorkspace(workspaceName);
    }
}
