package uitests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uitests.elements.Field;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private Field loginField = new Field(driver, By.cssSelector("input[id='user']"));

    public Field getLoginField() {
        return loginField;
    }

    private Field passwordField = new Field(driver, By.cssSelector("input[id='password']"));

    public Field getPasswordField() {
        return passwordField;
    }

    private Field passwordFieldAtlassian = new Field(driver, By.cssSelector("input.Input__InputElement-sc-1o6bj35-0.bfCuIo"));

    public Field getPasswordFieldAtlassian() {
        return passwordFieldAtlassian;
    }
}
