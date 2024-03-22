package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends BasePage {

    @FindBy(xpath = "//input[contains(@type, 'email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class, 'btn') and contains(@class, 'btn_arrow')]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, 'popup_bad')]")
    private WebElement authPopupBad;

    @FindBy(xpath = "//form[contains(@class, 'formPage__form' and contains(@class, 'js-login-form')")
    private WebElement authForm;

    public AuthPage(){
        driver.get(config.baseUrl() + "/auth");
//        driver.get("https://frutonyanya.ru/auth");
        PageFactory.initElements(driver, this);
    }

    public void sendKeysEmail(String email){
        emailInput.click();
        emailInput.sendKeys(email);
        System.out.println("Email entered! ("+email+")");
    }

    public void sendKeysPassword(String pass){
        passwordInput.click();
        passwordInput.sendKeys(pass);
        System.out.println("Password entered! ("+pass+")");
    }

    public void inputCorrectEmail(){
        emailInput.click();
        emailInput.sendKeys(config.email());
    }

    public void inputCorrectPassword(){
        passwordInput.click();
        passwordInput.sendKeys(config.password());
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public boolean isBadAuthPopupDisplayed(){
        BasePage.setExplicitWait(driver, 5, "//div[contains(@class, 'popup_bad')]");
        return authPopupBad.isDisplayed();
    }

    public boolean isBadEmailPopupDisplayed(String validityState){
        return isBadInputPopupDisplayed(validityState, "input[type=email]");
    }

    public boolean isBadPasswordPopupDisplayed(String validityState){
        return isBadInputPopupDisplayed(validityState, "input[type=password]");
    }
}
