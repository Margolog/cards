package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LoginTests extends BaseTest {

    private static String inValidEmail = "inValidEmail";
    private static String password = "1234";

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
}