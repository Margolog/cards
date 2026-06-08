import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LoginTests extends BaseTest{

    private static final String password = "password";
    private static final String  inValidEmail = "inValidEmail";

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
    @DisplayName("При вводе некорректного email отображается сообщение об ошибке")
    void invalidEmailValidationShouldBeShownTest() {
        step("Открыть страницу логина", () -> {
            loginPage.openPage();
        });

        step("Ввести некорректный email и пароль", () -> {
            loginPage.setEmail(inValidEmail);
            loginPage.setPassword(password);
        });

        step("Нажать кнопку Войти", () -> {
            loginPage.clickLoginButton();
        });

        step("Проверить ошибку email", () -> {
            loginPage.checkEmailValidationError();
        });
    }
}