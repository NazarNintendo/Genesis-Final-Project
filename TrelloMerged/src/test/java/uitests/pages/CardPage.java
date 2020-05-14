package uitests.pages;

import uitests.elements.Container;
import uitests.elements.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPage extends Page {
    public CardPage(WebDriver driver) {
        super(driver);
    }

    private Container cardDetailsTile = new Container(driver, By.cssSelector("a.list-card.js-member-droppable.ui-droppable"));

    public Container getCardDetailsTile() {
        return cardDetailsTile;
    }

    private Container createChecklistButton = new Container(driver, By.cssSelector("a.button-link.js-add-checklist-menu"));

    public Container getCreateChecklistButton() {
        return createChecklistButton;
    }

    private Field createChecklistField = new Field(driver, By.cssSelector("input[id='id-checklist']"));

    public Field getCreateChecklistField() {
        return createChecklistField;
    }

    private Field createCheckitemField = new Field(driver, By.cssSelector("textarea.edit.field.checklist-new-item-text.js-new-checklist-item-input"));

    public Field getCreateCheckitemField() {
        return createCheckitemField;
    }

    private Container checkitemTitleBox = new Container(driver, By.cssSelector("div.checklist-item-text-and-controls.hide-on-edit"));

    public Container getCheckitemTitleBox() {
        return checkitemTitleBox;
    }
}
