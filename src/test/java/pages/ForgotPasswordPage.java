package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static data.TestData.CONFIRMATION_CODE_TEXT;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ForgotPasswordPage {
    // Elements
    private final SelenideElement emailInput =
            $("form input[type='text']");

    private final SelenideElement submitButton =
            $("button[type='submit']");

    private final SelenideElement confirmationCodeLabel =
            $$("form div").findBy(text(CONFIRMATION_CODE_TEXT));

    //Actions
    @Step("Ввести email: {value}")
    public ForgotPasswordPage setEmail(String value) {
        emailInput.shouldBe(visible, enabled)
                  .click();
        emailInput.sendKeys(value);
        emailInput.sendKeys(Keys.TAB);
        emailInput.shouldHave(exactValue(value));
        return this;
    }

    @Step("Отправить форму восстановления пароля")
    public ForgotPasswordPage submitRecoveryForm() {
        submitButton.shouldBe(visible, enabled)
                    .click();
        return this;
    }

    @Step("Проверить отображение поля Confirmation code")
    public ForgotPasswordPage checkConfirmationCodeIsVisible() {
        confirmationCodeLabel.shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }
}
