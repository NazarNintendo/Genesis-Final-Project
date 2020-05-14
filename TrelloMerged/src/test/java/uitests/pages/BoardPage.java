package uitests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uitests.elements.Container;
import uitests.elements.Field;

public class BoardPage extends Page {
    public BoardPage(WebDriver driver) {
        super(driver);
    }


    private Container boardTitleBox = new Container(driver, By.cssSelector("div.board-header-btn.mod-board-name.inline-rename-board.js-rename-board"));

    public Container getBoardTitleBox() {
        return boardTitleBox;
    }

    private Field createListField = new Field(driver, By.cssSelector("input.list-name-input"));

    public Field getCreateListField() {
        return createListField;
    }

    private Container listTitleBox = new Container(driver, By.cssSelector("div.list-header-target.js-editing-target"));

    public Container getListTitleBox() {
        return listTitleBox;
    }

    private Container createCardButton = new Container(driver, By.cssSelector("a.open-card-composer.js-open-card-composer"));

    public Container getCreateCardButton() {
        return createCardButton;
    }

    private Field createCardField = new Field(driver, By.cssSelector("textarea.list-card-composer-textarea.js-card-title"));

    public Field getCreateCardField() {
        return createCardField;
    }

    private Container cardTitleBox = new Container(driver, By.cssSelector("div.list-card-details.js-card-details"));

    public Container getCardTitleBox() {
        return cardTitleBox;
    }
}
