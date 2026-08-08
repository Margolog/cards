package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.SignUpPage;

import static io.qameta.allure.Allure.step;

public class LoginTests extends BaseTest {

    private static String inValidEmail = "inValidEmail";
    private static String password = "1234";
    private static final String RECOVERY_EMAIL = "test@test.ru";
    LoginPage loginPage = new LoginPage();


    @Test
    @DisplayName("На странице авторизации отображается кнопка входа через Google")
    void googleLoginButtonShouldBeVisibleTest() {
        step("Открыть страницу логина", () -> {
            loginPage.openPage();
        });

        step("Проверить кнопку входа через Google", () -> {
            loginPage.checkGoogleLoginButton();
        });
    }

    @Test
    @DisplayName("При вводе некорректного email отображается ошибка Wrong email")
    void invalidEmailValidationShouldBeShownTest() {
        step("Открыть страницу авторизации", () -> {
            loginPage.openPage();
        });

        step("Ввести некорректный email, пароль", () -> {
            loginPage.setEmail(inValidEmail)
                     .setPassword(password);

        });

        step("Нажать кнопку входа", () -> {
            loginPage.clickLoginButton();
        });

        step("Проверить отображение ошибки", () -> {
            loginPage.checkValidationErrorIsVisible();
        });
    }

    @Test
    @DisplayName("После отправки формы восстановления пароля отображается поле Confirmation code")
    void confirmationCodeShouldBeShownAfterPasswordRecoveryRequestTest() {
        ForgotPasswordPage forgotPasswordPage = step("Открыть страницу восстановления пароля", () ->
                loginPage.openPage()
                         .openForgotPasswordPage());

        step("Ввести email", () -> {
            forgotPasswordPage.setEmail(RECOVERY_EMAIL);
        });

        step("Отправить форму восстановления пароля", () -> {
            forgotPasswordPage.submitRecoveryForm();
        });

        step("Проверить отображение поля Confirmation code", () -> {
            forgotPasswordPage.checkConfirmationCodeIsVisible();
        });
    }

    @Test
    @DisplayName("Со страницы авторизации можно перейти на страницу регистрации")
    void signUpPageShouldBeOpenedFromLoginPageTest() {
        step("Открыть страницу авторизации", () -> {
            loginPage.openPage();
        });

        SignUpPage signUpPage = step("Нажать Join Multicards.io", () ->
                loginPage.openSignUpPage());

        step("Проверить заголовок Sign Up Account", () -> {
            signUpPage.checkPageTitle();
        });
    }
}
