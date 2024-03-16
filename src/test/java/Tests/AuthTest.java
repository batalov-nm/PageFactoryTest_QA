package Tests;

import Pages.AuthPage;
import Users.RegularUser;
import Users.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AuthTest extends SetUpTest{
    static Stream<Arguments> getUserInfo() {
        return Stream.of(
                Arguments.of("Email_111@email.com", "pass1"),
//                Arguments.of(config.email(), config.password()),
                Arguments.of("Email_222@email.com", "pass2")
        );
    }

    @ParameterizedTest(name = "Test: {0}")
    @MethodSource("getUserInfo")
   public void submitAuthNegative(String userEmail, String userPassword) {
        User newUser = new RegularUser(userEmail, userPassword);

        AuthPage authPage = new AuthPage();

        authPage.sendKeysEmail(newUser.getEmail());
        authPage.sendKeysPassword(newUser.getPassword());

        authPage.clickSubmitButton();
        assertTrue(authPage.isBadPopupDisplayed());
    }
}
