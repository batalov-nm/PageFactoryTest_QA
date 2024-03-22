package Pages;

import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected static WebDriver driver;
    protected static ProjectConfig config;

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }

    public static void initConfig(){
        config = ConfigFactory.create(ProjectConfig.class);
    }

    public static void setExplicitWait(WebDriver webDriver, int waitDuration, String elementXpath){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(waitDuration));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXpath)));
    }

    public boolean isBadInputPopupDisplayed(String validityState, String querySelector){ // querySelector without ''
//        String js = "return document.querySelector('input').validity.valueMissing;";
        String js = "return document.querySelector('" + querySelector + "').validity." + validityState + ";";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        return (boolean) jsExecutor.executeScript(js);
    }
}
