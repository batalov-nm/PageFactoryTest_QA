package Tests;

import Pages.AuthPage;
import Pages.MainPage;
import org.junit.jupiter.api.Test;


public class AuthTest extends SetUpTest {
//    static Stream<Arguments> getUserInfo() {
//        return Stream.of(
//                Arguments.of("Email_111@email.com", "pass1"),
////                Arguments.of(config.email(), config.password()),
//                Arguments.of("Email_222@email.com", "pass2")
//        );
//    }

//    @ParameterizedTest(name = "Test: {0}")
//    @MethodSource("getUserInfo")

    public static final String CORRECT_EMAIL = "test@test.te";
    public static final String CORRECT_PASSWORD = "test_test123";
    public static final String WRONG_EMAIL = "dasd@dsad.dsa";
    public static final String WRONG_PASSWORD = "dsadad";
    public static final String NONE = "";

    @Test
    public void submitAuthWrongNegative() {
//        User newUser = new RegularUser(userEmail, userPassword);
        MainPage mainPage = new MainPage();
        mainPage.clickLoginButton();

        AuthPage authPage = new AuthPage();
        authPage
                .sendKeysEmail(WRONG_EMAIL)
                .sendKeysPassword(WRONG_PASSWORD)
                .clickSubmitButton()
                .isBadAuthPopupDisplayed();
    }

    @Test
    public void submitAuthEmptyNegative() {
        MainPage mainPage = new MainPage();
        mainPage.clickLoginButton();

        AuthPage authPage = new AuthPage();
        authPage
                .sendKeysEmail(NONE)
                .sendKeysPassword(NONE)
                .clickSubmitButton()
                .isBadEmailPopupDisplayed(AuthPage.validityState.valueMissing.name())
                .isBadPasswordPopupDisplayed(AuthPage.validityState.valueMissing.name());
    }

    @Test
    public void submitAuthPositive() {
        MainPage mainPage = new MainPage();
        mainPage.clickLoginButton();

        AuthPage authPage = new AuthPage();
        authPage
                .sendKeysEmail(CORRECT_EMAIL)
                .sendKeysPassword(CORRECT_PASSWORD)
                .clickSubmitButton()
                .isBadAuthPopupDisplayed();
    }
}
