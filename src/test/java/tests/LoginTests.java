package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.SignUpPage;

import static data.TestData.INVALID_EMAIL;
import static data.TestData.PASSWORD;
import static data.TestData.RECOVERY_EMAIL;

public class LoginTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @Test
    @Story("Авторизация через Google")
    @DisplayName("На странице авторизации отображается кнопка входа через Google")
    void googleLoginButtonShouldBeVisibleTest() {
        loginPage.openPage()
                 .checkGoogleLoginButton();
    }

    @Test
    @Story("Валидация формы авторизации")
    @DisplayName("При вводе некорректного email отображается ошибка Wrong email")
    void invalidEmailValidationShouldBeShownTest() {
        loginPage.openPage()
                 .setEmail(INVALID_EMAIL)
                 .setPassword(PASSWORD)
                 .clickLoginButton()
                 .checkValidationErrorIsVisible();
    }

    @Test
    @Story("Восстановление пароля")
    @DisplayName("После отправки формы восстановления пароля отображается поле Confirmation code")
    void confirmationCodeShouldBeShownAfterPasswordRecoveryRequestTest() {
        ForgotPasswordPage forgotPasswordPage = loginPage.openPage()
                                                       .openForgotPasswordPage();

        forgotPasswordPage.setEmail(RECOVERY_EMAIL)
                          .submitRecoveryForm()
                          .checkConfirmationCodeIsVisible();
    }

    @Test
    @Story("Переход к регистрации")
    @DisplayName("Со страницы авторизации можно перейти на страницу регистрации")
    void signUpPageShouldBeOpenedFromLoginPageTest() {
        SignUpPage signUpPage = loginPage.openPage()
                                           .openSignUpPage();

        signUpPage.checkPageTitle();
    }
}
