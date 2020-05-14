package conf;

import apitests.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

@Test(description = "API Tests")
public class APITests {
    private String boardId;
    public String idList;
    public String idCard;
    public String idCheckList;
    public String idCheckItem;


    @Test(priority = 1, description = "Create Board test")
    public void checkCreateBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Board board = new Board();
        String name = "A new Board (API)";

        Board createBoard = retrofitBuilder.getTrelloApi().createBoard(board, name).execute().body();
        boardId = createBoard.getId();
        Assert.assertEquals(createBoard.getName(), name);
    }

    @Test (priority = 2, description = "Create List test")
    public void createList() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        List list = new List();
        String name = "A new List (API)";
        List createList = retrofitBuilder.getTrelloApi().createList(list, boardId, name).execute().body();

        idList = createList.getId();
        Assert.assertEquals(createList.getName(), name);
    }

    @Test (priority = 3, description = "Create Card test")
    public void createCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Card card = new Card();
        String name = "A new Card (API)";
        Card createCard = retrofitBuilder.getTrelloApi().createCard(card, idList, name).execute().body();
        idCard = createCard.getId();
    }

    @Test (priority = 4, description = "Create CheckList test")
    public void createCheckList() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        CheckList checkList = new CheckList();
        String name = "CheckList (API)";
        CheckList createCheckList = retrofitBuilder.getTrelloApi().createCheckList(checkList, idCard, name).execute().body();
        idCheckList = createCheckList.getId();
    }

    @Test(priority = 5, description = "Create CheckItem test")
    public void addCheckItem() throws IOException {
        createCard();
        createCheckList();
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        CheckList checkList = new CheckList();
        String name = "Item (API)";
        CheckList addCheckItem = retrofitBuilder.getTrelloApi().addCheckItem(checkList,idCheckList, name).execute().body();
        idCheckItem = addCheckItem.getId();
    }

}
