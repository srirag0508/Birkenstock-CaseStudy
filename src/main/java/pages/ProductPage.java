package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ProductPage {

    @FindBy(xpath = "//h1[normalize-space()='Cookie Settings']")
    public WebElement cookieSettings;

    @FindBy(xpath = "//div[contains(@class,'button button-custom-green solid confirm-button check-all-button')]")
    public WebElement acceptAllButton;

    @FindBy(xpath = "//div[@class='country-switcher']")
    private WebElement countrySwitcherDialog;

    @FindBy(xpath = "//i[@class='icon icon-close']")
    private WebElement countrySwitcherClose;

    @FindBy(xpath = "//span[@class='fylin-link flyin-product-info-fit-guide']")
    public WebElement fitGuideLink;

    private final WebDriver driver;
    public FluentWait<WebDriver> wait;

    public ProductPage(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(Duration.ofSeconds(2)) // Adjust the polling interval as needed
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        PageFactory.initElements(driver, this);
    }

    public void acceptCookieSettings() {
        wait.until(driver -> driver.findElement(By.xpath("//div[contains(@class,'button button-custom-green solid confirm-button check-all-button')]"))).click();
    }

    public void clickCountrySwitcher() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='country-switcher']")));
        countrySwitcherClose.click();
    }

    public void clickFitGuideLink() {
        wait.until(ExpectedConditions.elementToBeClickable(fitGuideLink)).click();
    }
}
