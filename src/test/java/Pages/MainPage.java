package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'header__link_register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//a[contains(@class, 'header__button_login')]")
    private WebElement loginButton;

    public MainPage() {
        driver.get(config.baseUrl());
        PageFactory.initElements(driver, this);
    }

    public MainPage clickRegisterButton() {
        registerButton.click();
        return this;
    }

    public MainPage clickLoginButton() {
        loginButton.click();
        return this;
    }
}
