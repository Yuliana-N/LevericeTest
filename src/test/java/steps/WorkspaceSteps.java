package steps;

import pages.WorkspacePage;
import utils.FolderGenerator;

public class WorkspaceSteps {
    WorkspacePage workspacePage;
    FolderGenerator folderGenerator;

    public WorkspaceSteps() {
        workspacePage = new WorkspacePage();
        folderGenerator = new FolderGenerator();
    }

    public void inviteUsersByEnterEmail(String userEmail) {
        workspacePage.clickInviteUser();
        workspacePage.inviteUser(userEmail);
    }

    public void checkForInvitedUser(String userEmail) {
        workspacePage.manageMembers();
        workspacePage.checkForInvitedUser(userEmail);
    }

    public void createANewFolder() {
        folderGenerator.generateFolderName();
        workspacePage.initiateCreatingNewFolder();
        workspacePage.fillFolderName(FolderGenerator.fakeFolderName);
    }

    public void checkNewFolder() {
        workspacePage.checkNewFolder(FolderGenerator.fakeFolderName);
    }
}
