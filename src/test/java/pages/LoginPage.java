package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    //Elements
    private  SelenideElement googleLoginButton = $("img[src*='google']").ancestor("button");
    private SelenideElement emailInput = $("input[placeholder='Введите email']");
    private SelenideElement passwordInput = $("input[placeholder='Введите пароль']");
    private SelenideElement loginButton = $$("button").findBy(text("ВОЙТИ"));
    private SelenideElement emailValidationError = $(byText("Неправильный адрес электронной почты"));

    //Actions
    @Step("Открыть страницу авторизации")
    public LoginPage openPage() {
        open("/login");
        return this;
    }

    @Step("Проверить, что отображается кнопка входа через Google")
    public LoginPage checkGoogleLoginButton() {
        googleLoginButton.shouldBe(visible);
        return this;
    }

    @Step("Ввести email: {value}")
    public LoginPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Нажать кнопку Войти")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Проверить ошибку валидации email")
    public LoginPage checkEmailValidationError() {
        emailValidationError.shouldBe(visible);
        return this;
    }
}