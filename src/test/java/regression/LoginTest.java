package regression;

import com.trello.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();

    @Test
    public void login() throws InterruptedException {
        loginPage.open();
        loginPage.login("sumigoxuci@mailsource.info", "werter321");
        boardsPage.openBoard("TestBoard");
    }
}
