package uitests.pages;

import uitests.elements.Container;
import uitests.elements.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private Container addBoardTile = new Container(driver, By.cssSelector("div.board-tile.mod-add"));

    public Container getAddBoardTile() {
        return addBoardTile;
    }

    private Field createBoardField = new Field(driver, By.cssSelector("input[data-test-id='create-board-title-input']"));

    public Field getCreateBoardField() {
        return createBoardField;
    }

}
