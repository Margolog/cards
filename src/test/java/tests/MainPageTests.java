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
import static io.qameta.allure.Allure.step;

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
        step("Открыть главную страницу на испанском языке", () -> {
            mainPage.openPage()
                    .openLanguageMenu()
                    .chooseLanguage(Language.SPANISH.getValue());
        });

        step("Проверить пункт меню: " + menuItem, () -> {
            mainPage.checkHeaderMenuItem(menuItem);
        });
    }

    @Test
    @Story("Поддержка в Telegram")
    @DisplayName("Ссылка на Telegram support соответствует ожидаемой")
    void telegramSupportLinkShouldBeCorrectTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });

        step("Проверить ссылку на Telegram support", () -> {
            mainPage.checkTelegramSupportLink(TELEGRAM_SUPPORT_URL);
        });
    }


    @Test
    @Story("Локализация интерфейса")
    @DisplayName("После выбора испанского языка кнопка регистрации отображается на английском языке")
    void spanishLanguageShouldBeSelectedTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });

        step("Изменить язык на испанский", () -> {
            mainPage.openLanguageMenu()
                    .chooseLanguage(Language.SPANISH.getValue());
        });

        step("Проверить, что текст кнопки регистрации отображается на английском", () -> {
            mainPage.checkRegistrationButtonText(REGISTRATION_BUTTON_TEXT);
        });
    }
}
