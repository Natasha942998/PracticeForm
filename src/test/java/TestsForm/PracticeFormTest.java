package TestsForm;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static TestsForm.PracticeFormPage.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless"); // убрать, если нужен UI

        Configuration.browserCapabilities = options;

        Configuration.pageLoadTimeout = 120000;

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").shouldBe(visible, Duration.ofSeconds(30));
    }

    @Test
    public void formTest() {
        String firstName = "Veronika";
        String lastName = "Si";
        String email = "Veronika@example.com";
        String numberMobile = "23431111";
        String currentAddress = "text";
        String subjects = "test";
        String state = "Uttar Pradesh";
        String city = "Lucknow";
        SelenideElement titleThanksForSubmitting = $("//*[text()= 'Thanks for submitting the form']");
        SelenideElement date = $(".react-datepicker__day.react-datepicker__day--026"); //26 декабря

        fillName(firstName, lastName);
        fillEmail(email);

        selectGenderFemale(true);

        fillPhoneNumber(numberMobile);

        fillDate(date);

        fillSubjects(subjects);

        selectHobbiesMusic(true);

        fillCurrentAddress(currentAddress);

        fillState(state);

        fillCity(city);

        submit();

        SelenideElement modalContent = $(".modal-content");
        modalContent.shouldBe(Condition.visible);

        switchTo();

        titleThanksForSubmitting.should(Condition.exist, Duration.ofSeconds(30))
                .shouldBe(Condition.visible, Duration.ofSeconds(10));

        SelenideElement table = $(".table-responsive table"); // Находим таблицу

        // Находим строку (tr) и проверяем каждую ячейку (td) отдельно
        SelenideElement row = table.$("tr");


        row.$("td").shouldHave(
                Condition.text("Student Name")
        );
        row.$("td").shouldHave(
                Condition.text(firstName)
        );
        row.$("td").shouldHave(
                Condition.text("Student Email")
        );
        row.$("td").shouldHave(
                Condition.text(email)
        );
        row.$("td").shouldHave(
                Condition.text("Mobile")
        );
        row.$("td").shouldHave(
                Condition.text(numberMobile)
        );
        row.$("td").shouldHave(
                Condition.text("Date of Birth")
        );
        row.$("td").shouldHave(
                Condition.text("26 December,2025")
        );
    }
}