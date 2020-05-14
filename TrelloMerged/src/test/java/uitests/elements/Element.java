package uitests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Element {

    protected By by;
    protected WebDriver driver;

    public Element(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }

    public void click() {
        driver.findElement(by).click();
    }

    public void sendKeys(String keys) {
        driver.findElement(by).sendKeys(keys);
    }


    public boolean elementExists() {
        try{
            driver.findElement(by);
            return true;
        }
        catch (NullPointerException e) {
            return false;
        }
    }
}
