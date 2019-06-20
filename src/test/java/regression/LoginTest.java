package regression;

import com.trello.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;

public class LoginTest extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();

    public void login() throws InterruptedException {
        loginPage.open();
        loginPage.login("email", "password");
    }
}
