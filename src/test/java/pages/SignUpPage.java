package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignUpPage {

    private static final String SIGN_UP_PAGE_TITLE = "Sign Up Account";

    private final SelenideElement pageTitle =
            $$("h1").findBy(text(SIGN_UP_PAGE_TITLE));

    @Step("Проверить заголовок страницы регистрации")
    public SignUpPage checkPageTitle() {
        pageTitle.shouldBe(visible)
                .shouldHave(exactText(SIGN_UP_PAGE_TITLE));
        return this;
    }
}
