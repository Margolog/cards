package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    private final SelenideElement appLoader = $("#app-loader");

    protected void waitForPageLoaded() {
        appLoader.should(disappear, Duration.ofSeconds(15));
    }
}
