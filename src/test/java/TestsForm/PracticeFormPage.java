package TestsForm;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {

    // Локаторы элементов формы
    private static final SelenideElement firstNameInput = $("#firstName");
    private static final SelenideElement lastNameInput = $("#lastName");

    private static final SelenideElement emailInput = $("#userEmail");


    private static final SelenideElement genderCheckboxMale = $("#gender-radio-1");
    private static final SelenideElement genderCheckboxFemale = $("#gender-radio-2");
    private static final SelenideElement genderCheckboxOther = $("#gender-radio-3");

    private static final SelenideElement phoneInput = $("#userNumber");

    private static final SelenideElement birthDateInput = $("#dateOfBirthInput");
    private static final SelenideElement calendar = $(".react-datepicker-popper");

    private static final SelenideElement subjectInput = $("#subjectsInput");

    private static final SelenideElement hobbyCheckboxSports = $("#hobbies-checkbox-1");
    private static final SelenideElement hobbyCheckboxReading = $("#hobbies-checkbox-2");
    private static final SelenideElement hobbyCheckboxMusic = $("#hobbies-checkbox-3");

    private static final SelenideElement uploadFileButton = $("#uploadPicture");

    private static final SelenideElement currentAddressInput = $("#currentAddress");

    private static final SelenideElement stateDropdown = $("#react-select-3-input");

    private static final SelenideElement cityDropdown = $("#react-select-4-input");

    private static final SelenideElement submitButton = $("#submit");

    private static final SelenideElement titleThanksForSubmitting = $("#example-modal-sizes-title-lg");

    public static void fillName(String firstNameValue, String lastNameValue) {
        firstNameInput.shouldBe(visible).setValue(firstNameValue);
        lastNameInput.shouldBe(visible).setValue(lastNameValue);
    }

    public static void fillEmail(String value) {
        emailInput.shouldBe(visible).setValue(value);
    }

    public static void selectGenderMale(Boolean value) {
        genderCheckboxMale.should(exist, Duration.ofSeconds(30));// 1. Проверяем, что элемент присутствует в DOM (exist)
        genderCheckboxMale.shouldBe(hidden, Duration.ofSeconds(30));// 2. Проверяем видимость элемента (visible)
        genderCheckboxMale.setSelected(true); // 3. Устанавливаем значение
    }

    public static void selectGenderFemale(Boolean value) {
        genderCheckboxFemale.should(exist, Duration.ofSeconds(30));
        genderCheckboxFemale.shouldBe(hidden, Duration.ofSeconds(30));
        genderCheckboxFemale.setSelected(true);
    }

    public static void selectGenderOther(Boolean value) {
        genderCheckboxOther.should(exist, Duration.ofSeconds(30));
        genderCheckboxOther.shouldBe(hidden, Duration.ofSeconds(30));
        genderCheckboxOther.setSelected(true);
    }

    public static void fillDate(SelenideElement date) {
        birthDateInput.click();
        calendar.shouldBe(visible);
        date.shouldBe(visible).click();
        calendar.shouldBe(disappear);
    }

    public static void fillPhoneNumber(String value) {
        phoneInput.shouldBe(visible).setValue(value);
    }

    public static void fillSubjects(String value) {
        subjectInput.shouldBe(visible).setValue(value);
    }

    public static void selectHobbiesSports(Boolean value) {

        hobbyCheckboxSports.shouldBe(visible).setSelected(true);
    }

    public static void selectHobbiesReading(Boolean value) {
        hobbyCheckboxReading.shouldBe(visible).setSelected(true);
    }

    public static void selectHobbiesMusic(Boolean value) {

        hobbyCheckboxMusic.shouldBe(visible).setSelected(true);
    }

    public static void uploadFile(File file, String fileName) {
        uploadFileButton.shouldBe(visible).click();
            }

    public static void fillCurrentAddress(String value) {
        currentAddressInput.shouldBe(visible).setValue(value);
    }

    public static void fillState(String value) {
        stateDropdown.shouldBe(visible).setValue(value);
    }

    public static void fillCity(String value) {
        cityDropdown.shouldBe(visible).setValue(value);
    }

    public static SelenideElement submit() {
        submitButton.shouldBe(visible).click();

        return titleThanksForSubmitting;
    }
}