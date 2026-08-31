package tests;

import data.Language;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static data.TestData.REGISTRATION_BUTTON_TEXT;
import static data.TestData.TELEGRAM_SUPPORT_URL;

public class MainPageTests extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @ValueSource(strings = {
            "Las ventajas",
            "Contactar con nosotros",
            "FAQ"
    })
    @ParameterizedTest(name = "В хедере на испанском отображается пункт меню: {0}")
    @Story("Локализация интерфейса")
    @DisplayName("В хедере отображаются пункты меню")
    void headerMenuItemsShouldBeVisibleTest(String menuItem) {
        mainPage.openPage()
                .openLanguageMenu()
                .chooseLanguage(Language.SPANISH.getValue())
                .checkHeaderMenuItem(menuItem);
    }

    @Test
    @Story("Поддержка в Telegram")
    @DisplayName("Ссылка на Telegram support соответствует ожидаемой")
    void telegramSupportLinkShouldBeCorrectTest() {
        mainPage.openPage()
                .checkTelegramSupportLink(TELEGRAM_SUPPORT_URL);
    }


    @Test
    @Story("Локализация интерфейса")
    @DisplayName("После выбора испанского языка кнопка регистрации отображается на английском языке")
    void spanishLanguageShouldBeSelectedTest() {
        mainPage.openPage()
                .openLanguageMenu()
                .chooseLanguage(Language.SPANISH.getValue())
                .checkRegistrationButtonText(REGISTRATION_BUTTON_TEXT);
    }
}
