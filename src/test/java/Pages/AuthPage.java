package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    public AuthPage() {
        driver.get(config.baseUrl() + "/auth");
//        driver.get("https://frutonyanya.ru/auth");
        PageFactory.initElements(driver, this);
    }

    public AuthPage sendKeysEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
        System.out.println("Email entered! (" + email + ")");
        return this;
    }

    public AuthPage sendKeysPassword(String pass) {
        passwordInput.click();
        passwordInput.sendKeys(pass);
        System.out.println("Password entered! (" + pass + ")");
        return this;
    }

    public AuthPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public AuthPage isBadAuthPopupDisplayed() {
        BasePage.setExplicitWait(driver, 5, "//div[contains(@class, 'popup_bad')]");
        assertTrue(authPopupBad.isDisplayed());
        return this;
    }

    public AuthPage isBadEmailPopupDisplayed(String validityState) {
        isBadInputPopupDisplayed(validityState, "input[type=email]");
        return this;
    }

    public AuthPage isBadPasswordPopupDisplayed(String validityState) {
        isBadInputPopupDisplayed(validityState, "input[type=password]");
        return this;
    }

    public enum validityState {
        customError,
        patternMismatch,
        rangeOverflow,
        rangeUnderflow,
        stepMismatch,
        tooLong,
        tooShort,
        typeMismatch,
        valid,
        valueMissing;
    }
}
