package regression;

import com.trello.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.api.models.CardPage;
import com.trello.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

public class CardActions extends BrowserFactory {

    TrelloRestClient client = new TrelloRestClient();

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();
    Card card = new Card("My new card No 5" + new Date().getTime());

    @Test
    public void login() {
        loginPage.open();
        loginPage.login("sumigoxuci@mailsource.info", "werter321");

    }

    @Test
    public void openCard() {
        cardPage.open();
    }

    @Test(dependsOnMethods = {"login", "openCard"})
    public void moveCard() {

    }

    @BeforeTest
    public void prepareData() throws IOException {
        Card createCard = client.cardsService.createCard("5cffd3f2ef21013bb2f882cb", card).execute().body(); // Looked for idList in browser through inspect -> Network -> Preserve Log
    }

    @AfterTest
    public void clearData() {

    }
}
