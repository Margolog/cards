package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    //Elements
    private SelenideElement loginButton = $("a[href='/login']");
    private SelenideElement registrationButton = $("a[href='/registration']");
    private SelenideElement languageButton = $("button[aria-haspopup='true']");
    private SelenideElement telegramSupportLink = $("a[target='_blank']");

    //Actions
    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Проверить меню в хедере")
    public MainPage checkHeaderMenuItem(String item) {
        $(byText(item)).shouldBe(visible);
        return this;
    }

    @Step("Проверить ссылку на телеграм")
    public MainPage checkTelegramSupportLink(String telegramSupport) {
        telegramSupportLink.shouldHave(
                attribute("href", telegramSupport)
        );
        return this;
    }

    @Step("Открыть страницу с логином")
    public MainPage openLoginPage() {
        loginButton.click();
        return this;
    }

    @Step("Открыть выбор языка")
    public MainPage openLanguageMenu() {
        languageButton.click();
        return this;
    }

    @Step("Выбирать язык")
    public MainPage chooseLanguage(String language) {
        $(byText(language)).click();
        return this;
    }

    @Step("Проверить кнопку регистрации")
    public MainPage checkRegistrationButtonText(String text) {
        registrationButton.shouldHave(text(text));
        return this;
    }
}