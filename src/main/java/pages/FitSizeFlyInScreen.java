package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FitSizeFlyInScreen {
    private final WebDriver driver;
    private final FluentWait<WebDriver> wait;

    @FindBy(xpath = "//span[contains(text(),'Find your perfect fit')]")
    private WebElement headlineElement;

    @FindBy(xpath = "//div[@class='option kids']")
    private WebElement kidsOptionElement;

    @FindBy(xpath = "//div[@class='option adults selected']")
    private WebElement adultsOptionElement;

    @FindBy(xpath = "//button[normalize-space()='Calculate Size']")
    public WebElement calculateButton;

    @FindBy(id = "length-select-left")
    public WebElement leftLength;

    @FindBy(id = "width-select-left")
    public WebElement leftWidth;

    @FindBy(id = "length-select-right")
    public WebElement rightLength;

    @FindBy(id = "width-select-right")
    public WebElement rightWidth;



    // Constructor

    public FitSizeFlyInScreen(WebDriver driver, Duration timeout) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(Duration.ofSeconds(2)) // Adjust the polling interval as needed
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        PageFactory.initElements(driver, this);
    }

    // Select measurement method
    public void selectMeasurements(String leftLength, String leftWidth, String rightLength, String rightWidth) {
        selectDropdownOption("length-select-left", leftLength);
        selectDropdownOption("width-select-left", leftWidth);
        selectDropdownOption("length-select-right", rightLength);
        selectDropdownOption("width-select-right", rightWidth);
    }

    private void selectDropdownOption(String dropdownId, String option) {
        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(dropdownId)));
        new Select(dropdown).selectByVisibleText(option);
    }

    // Check if headline is displayed
    public boolean isHeadlineDisplayed() {
        return wait.until(driver -> headlineElement.isDisplayed());
    }

    // Check if kids option is displayed
    public boolean isKidsOptionDisplayed() {
        return wait.until(driver -> kidsOptionElement.isDisplayed());
    }

    // Check if adults option is displayed
    public boolean isAdultsOptionDisplayed() {
        return wait.until(driver -> adultsOptionElement.isDisplayed());
    }

    // Check if calculate button is displayed
    public boolean isCalculateButtonDisplayed() {
        return wait.until(driver -> calculateButton.isDisplayed());
    }

    //
    public void clickCalculateSizeButton() {
        calculateButton.click();
    }


    public void selectFromDropdown(String fieldName, By dropdownLocator, String selectedValue) {
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        Select dropdown = new Select(dropdownElement);

        // Select the value from the dropdown
        dropdown.selectByVisibleText(selectedValue);

        // Verify if the selected value is as expected
        if (!dropdown.getFirstSelectedOption().getText().equals(selectedValue)) {
            System.out.println(fieldName + ": Value '" + selectedValue + "' not available in dropdown.");

        }
    }
}