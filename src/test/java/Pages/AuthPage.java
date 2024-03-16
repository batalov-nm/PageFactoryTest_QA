package Pages;

import config.ProjectConfig;
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
    private WebElement popupBad;

    public AuthPage(){
//        driver.get(config.baseUrl() + "/auth"); // fixme Почему-то не видит конфиг, пишет что baseUrl() is Null
        driver.get("https://frutonyanya.ru/auth");
        PageFactory.initElements(driver, this);
    }

    public void sendKeysEmail(String email){
        emailInput.click();
        emailInput.sendKeys(email);
        System.out.println("Email entered!");
    }

    public void sendKeysPassword(String pass){
        passwordInput.click();
        passwordInput.sendKeys(pass);
        System.out.println("Password entered!");
    }

    public void clickSubmitButton(){
        submitButton.click();
        System.out.println("Submit Buttin clicked!");
    }

    public boolean isBadPopupDisplayed(){ // fixme Можно ли взять локатор из аннотации @FindBy, обратившись к самому элементу по типу submitButton.getXpath или типо того?
        BasePage.setExplicitWait(driver, 5, "//div[contains(@class, 'popup_bad')]");
        System.out.println("Bad Popup displayed");
        return popupBad.isDisplayed();
    }

}
