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

    // Additional methods for actions on the page can be added as needed
}
