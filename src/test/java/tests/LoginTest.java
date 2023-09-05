package tests;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void registrationTest() {
        loginSteps.createANewWorkspace();
        loginSteps.fakeEmailMailHogValidation();
        loginSteps.fillWorkspaceFields("Jack", "Daniels", "New Workspace");
    }

    @Test
    public void login() {
        loginSteps.signIn("test42@mailinator.com");
        loginSteps.MailHogValidation("test42@mailinator.com");
        loginSteps.selectWorkspace("Test Workspace");
    }
}

/* используйте login() чтобы открыть Леврайс, после чего можно писать свои тесты.
 */
