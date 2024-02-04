package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class CartSummaryPage {

    private final WebDriver driver;
    private final FluentWait<WebDriver> wait;

    // Constructor

    public CartSummaryPage(WebDriver driver, Duration timeout) {
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


    // Verify Heading in Page
    public void verifyHeading() {

        WebElement headingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@role='heading'][contains(text(),'Added to your cart')]")));
        assertTrue(headingElement.isDisplayed());
    }

    // Verify View Cart button
    public void verifyViewCartButton() {
        WebElement viewCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='View Cart']")));
        assertTrue(viewCartButton.isDisplayed());
    }

    // Verify Keep Shopping button
    public void verifyKeepShoppingButton() {
        WebElement keepShoppingButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Keep Shopping']")));
        assertTrue(keepShoppingButton.isDisplayed());
    }


}
