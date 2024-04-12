package Tests;

import Pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

abstract public class SetUpTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
//        WebDriverManager.chromedriver().clearDriverCache().setup();
//        WebDriverManager wdm = WebDriverManager.chromedriver().driverVersion("122");
//        wdm.setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        ChromeOptions newChromeOptions = new ChromeOptions();
        newChromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        BasePage.initConfig();
        BasePage.setDriver(driver);

        //ConfigFactory.create(ProjectConfig.class).baseUrl();
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
