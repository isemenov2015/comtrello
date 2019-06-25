package junk;

import com.trello.TrelloRestClient;
import com.trello.api.models.Card;
import org.testng.annotations.Test;

import java.io.IOException;

public class TryTrelloAPI {

    @Test
    public void callIt() throws IOException, InterruptedException {
        TrelloRestClient client = new TrelloRestClient();

        Card card = new Card();
        card.name = "My new card No 4";

        Card createCard = client.cardsService.createCard("5cffd3f2ef21013bb2f882cb", card).execute().body(); // Looked for idList in browser through inspect -> Network -> Preserve Log
        Thread.sleep(1500);
        client.cardsService.deleteCard(card.id).execute();
    }
}
