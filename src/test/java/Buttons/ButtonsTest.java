package Buttons;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ButtonsTest {

    SelenideElement doubleClickButton = $("#doubleClickBtn");
    SelenideElement resultMessage = $("#doubleClickMessage");

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless"); // без UI

        Configuration.browserCapabilities = options;

        Configuration.pageLoadTimeout = 120000;

        open("https://demoqa.com/buttons");
    }

    @Test
    public void testDoubleClick() {

        doubleClickButton
                .shouldBe(visible)
                .shouldBe(enabled);

        doubleClickButton.doubleClick();

        // проверка результата - после двойного клика появляется сообщение:"You have done a double click"
        resultMessage.shouldBe(visible);
        resultMessage.shouldHave(text("You have done a double click"));
    }
}
