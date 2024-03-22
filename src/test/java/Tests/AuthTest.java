package Tests;

import Pages.AuthPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AuthTest extends SetUpTest{
//    static Stream<Arguments> getUserInfo() {
//        return Stream.of(
//                Arguments.of("Email_111@email.com", "pass1"),
////                Arguments.of(config.email(), config.password()),
//                Arguments.of("Email_222@email.com", "pass2")
//        );
//    }

//    @ParameterizedTest(name = "Test: {0}")
//    @MethodSource("getUserInfo")

//    public static
    @Test
   public void submitAuthWrongNegative() {
//        User newUser = new RegularUser(userEmail, userPassword);
        AuthPage authPage = new AuthPage();

        authPage.sendKeysEmail("dasd@dsad.dsa");
        authPage.sendKeysPassword("dsadad");

        authPage.clickSubmitButton();
        assertTrue(authPage.isBadAuthPopupDisplayed());
    }

//    badInput:
//    customError:
//    patternMismatch:
//    rangeOverflow:
//    rangeUnderflow:
//    stepMismatch:
//    tooLong:
//    tooShort:
//    typeMismatch:
//    valid:
//    valueMissing:
    @Test
    public void submitAuthEmptyNegative() {
        AuthPage authPage = new AuthPage();
        authPage.sendKeysEmail("");
        authPage.sendKeysPassword("");

        authPage.clickSubmitButton();
        assertTrue(authPage.isBadEmailPopupDisplayed("valueMissing"));
        assertTrue(authPage.isBadPasswordPopupDisplayed("valueMissing"));
    }

    @Test
    public void submitAuthPositive() {
        AuthPage authPage = new AuthPage();
        authPage.inputCorrectEmail();
        authPage.inputCorrectPassword();

        authPage.clickSubmitButton();
        assertFalse(authPage.isBadAuthPopupDisplayed());
    }
}
