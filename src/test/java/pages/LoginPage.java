package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    // Elements
    private final SelenideElement googleLoginButton =
            $("img[src*='google']").ancestor("button");

    private final SelenideElement emailInput =
            $("input[autocomplete='username']");

    private final SelenideElement passwordInput =
            $("input[autocomplete='current-password']");

    private final SelenideElement loginButton =
            $("button[type='submit']");

    private final SelenideElement validationError =
            $(".v-messages__message");

    // Actions
    @Step("Открыть страницу авторизации")
    public LoginPage openPage() {
        open("/login");
        loginButton.shouldBe(visible);
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

    @Step("Нажать кнопку входа")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Проверить, что отображается сообщение об ошибке")
    public LoginPage checkValidationErrorIsVisible() {
        validationError.shouldBe(visible);
        return this;
    }
}