package tests;

import data.Language;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class MainPageTests extends BaseTest {

    private static String telegramSupportUrl = "https://t.me/multicards_support";
    private static String registrationButtonText = "Sign up";

    @ValueSource(strings = {
            "Las ventajas",
            "Contactar con nosotros",
            "FAQ"
    })
    @ParameterizedTest(name = "В хедере на испанском отображается пункт меню: {0}")
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
    @DisplayName("Ссылка на Telegram support соответствует ожидаемой")
    void telegramSupportLinkShouldBeCorrectTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });

        step("Проверить ссылку на Telegram support", () -> {
            mainPage.checkTelegramSupportLink(telegramSupportUrl);
        });
    }


    @Test
    @DisplayName("После выбора испанского языка кнопка регистрации отображается на английском языке")
    void russianLanguageShouldBeSelectedTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });

        step("Изменить язык на испанский", () -> {
            mainPage.openLanguageMenu()
                    .chooseLanguage(Language.SPANISH.getValue());
        });

        step("Проверить, что текст кнопки регистрации отображается на английском", () -> {
            mainPage.checkRegistrationButtonText(registrationButtonText);
        });
    }
}