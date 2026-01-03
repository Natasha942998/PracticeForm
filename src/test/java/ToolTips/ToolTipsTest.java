package ToolTips;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ToolTipsTest {

    SelenideElement hoverButton = $("#toolTipButton");
    SelenideElement tooltip = $(".t-tooltip-inner");

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

        open("https://demoqa.com/tool-tips");
    }

    @Test
    public void testToolTip() {

        hoverButton
                .shouldBe(visible)
                .shouldBe(enabled)
                .shouldHave(exactText("Hover me to see"))
                .hover();

        // проверка результата - появление tooltip с текстом:"You hovered over the button"
        tooltip
                .shouldBe(visible)
                .shouldHave(text("You hovered over the button"));

        //tooltip исчезает при уходе курсора
        actions().moveByOffset(0, 0).perform();
        tooltip.shouldNotBe(visible);
    }
}