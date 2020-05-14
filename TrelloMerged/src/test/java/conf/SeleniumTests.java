package conf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import uitests.elements.Container;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import uitests.pages.BoardPage;
import uitests.pages.CardPage;
import uitests.pages.HomePage;

@DisplayName("UI Tests")
public class SeleniumTests extends TestManager {

    @Test
    @Order(1)
    @DisplayName("Create Board test")
    public void createBoardTest() {
        HomePage homePage = new HomePage(driver);

        //creating a new board
        homePage.getAddBoardTile().click();
        homePage.getCreateBoardField().sendKeys("A New Board (UI)" + Keys.ENTER);

        //checking the existence of boardTitleBox element to assert a new board creation
        Container boardTitleBox = new BoardPage(driver).getBoardTitleBox();
        Assertions.assertTrue(boardTitleBox.elementExists());
    }

    @Test
    @Order(2)
    @DisplayName("Create List test")
    public void createListTest() {
        HomePage homePage = new HomePage(driver);

        //creating a new board
        homePage.getAddBoardTile().click();
        homePage.getCreateBoardField().sendKeys("A New Board (UI)" + Keys.ENTER);

        BoardPage boardPage = new BoardPage(driver);

        //creating a new list
        boardPage.getCreateListField().sendKeys("A New List (UI)" + Keys.ENTER);

        //checking the existence of listTitleBox element to assert a new list creation
        Container listTitleBox = boardPage.getListTitleBox();
        Assertions.assertTrue(listTitleBox.elementExists());
    }

    @Test
    @Order(3)
    @DisplayName("Create CheckItem test")
    public void createCheckItemTest() {
        HomePage homePage = new HomePage(driver);

        //creating a new board
        homePage.getAddBoardTile().click();
        homePage.getCreateBoardField().sendKeys("A New Board (UI)" + Keys.ENTER);

        BoardPage boardPage = new BoardPage(driver);

        //creating a new list
        boardPage.getCreateListField().sendKeys("A New List (UI)" + Keys.ENTER);

        //creating a new card
        boardPage.getCreateCardButton().click();
        boardPage.getCreateCardField().sendKeys("A New Card (UI)" + Keys.ENTER);

        CardPage cardPage = new CardPage(driver);

        //creating a new checklist
        cardPage.getCardDetailsTile().click();
        cardPage.getCreateChecklistButton().click();
        cardPage.getCreateChecklistField().sendKeys("New Checklist (UI)" + Keys.ENTER);

        //creating a new checkitem
        cardPage.getCreateCheckitemField().sendKeys("New Checkitem (UI)" + Keys.ENTER);

        //checking the existence of checkitemTitleBox element to assert a new checkitem creation
        Container checkitemTitleBox = cardPage.getCheckitemTitleBox();
        Assertions.assertTrue(checkitemTitleBox.elementExists());
    }

}
