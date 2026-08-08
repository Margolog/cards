package tests;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class BaseTest {

    private static final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {
        Configuration.browser = webConfig.getBrowser();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.headless = webConfig.isHeadless();
        Configuration.remote = webConfig.getRemoteUrl().isBlank()
                ? null
                : webConfig.getRemoteUrl();

        Configuration.savePageSource = true;
        Configuration.screenshots = true;

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--lang=en-US");
        options.setExperimentalOption(
                "prefs",
                Map.of("intl.accept_languages", "en-US,en")
        );

        if (Configuration.remote != null) {
            options.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
        }

        Configuration.browserCapabilities = options;
    }

    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }

    @AfterEach
    void addAttachments() {
        try {
            if (hasWebDriverStarted()) {
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                Attach.browserConsoleLogs();
                if (Configuration.remote != null) {
                    Attach.addVideo();
                }
            }
        } finally {
            SelenideLogger.removeListener("AllureSelenide");
            closeWebDriver();
        }
    }
}
