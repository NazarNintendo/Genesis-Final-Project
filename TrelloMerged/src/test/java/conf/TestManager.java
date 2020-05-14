package conf;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uitests.pages.LoginPage;

import java.util.concurrent.TimeUnit;


public class TestManager {

    protected static WebDriver driver;

    static String login = "genesisqaschoolavn@gmail.com";
    static String password = "QNd8N'nwu.N2YP<";

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trello.com/login/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginField().sendKeys(login);
        loginPage.getPasswordField().sendKeys(password + Keys.ENTER);
        loginPage.getPasswordFieldAtlassian().sendKeys(password + Keys.ENTER);
    }

    @AfterEach
    public void toHomePage() {
        driver.get("https://trello.com/");
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
