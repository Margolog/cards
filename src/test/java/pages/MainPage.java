package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;


public class MainPage {

    //Elements
    private SelenideElement loginButton = $("a[href='/login']");
    private final SelenideElement signUpButton = $("a[href='/sign-up']");
    private SelenideElement languageButton = $("button[aria-haspopup='true']");
    private final SelenideElement telegramSupportLink = $$("a").findBy(text("@multicards_support"));

    //Actions
    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("/");
        loginButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить меню в хедере")
    public MainPage checkHeaderMenuItem(String item) {
        $(byText(item)).shouldBe(visible);
        return this;
    }

    @Step("Проверить ссылку на Telegram support")
    public MainPage checkTelegramSupportLink(String expectedUrl) {
        telegramSupportLink
                .scrollTo()
                .shouldHave(attribute("href", expectedUrl));

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
        signUpButton.shouldHave(text(text));
        return this;
    }
}