package pages;
import junit.framework.JUnit4TestCaseFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class ResultsPage {

    private final WebDriver driver;
    private final FluentWait<WebDriver> wait;


    // Constructor
    public ResultsPage(WebDriver driver, Duration timeout) {
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

    // Page Elements
    private WebElement getHeadlineText() {
        return driver.findElement(By.xpath("//p[@class='ideal-size-text']"));
    }

    private WebElement getSizeElement() {
        return driver.findElement(By.xpath("//div[@class='result']"));
    }

    private WebElement getWidthElement() {
        return driver.findElement(By.xpath("//span[@class='size regular']"));
    }

    private WebElement getRecalculateButton() {
        return driver.findElement(By.xpath("//button[normalize-space()='Recalculate']"));
    }

    private WebElement getProductDetailsElement() {
        return driver.findElement(By.xpath("//div[@class='mini-cart-attributes']"));
    }

    private WebElement getLeftLengthElement() {
        return driver.findElement(By.xpath("//span[@class='lengthValueLeft']"));
    }

    private WebElement getLeftWidthElement() {
        return driver.findElement(By.xpath("//span[@class='widthValueLeft']"));
    }

    private WebElement getRightLengthElement() {
        return driver.findElement(By.xpath("//span[@class='lengthValueRight']"));
    }

    private WebElement getRightWidthElement() {
        return driver.findElement(By.xpath("//span[@class='widthValueRight']"));
    }

    private WebElement getProductImageElement() {
        return driver.findElement(By.xpath("//img[@title='Arizona Birko-Flor Nubuck Mocha']"));
    }

    private WebElement getCloseIconElement() {
        return driver.findElement(By.xpath("//i[@class='icon icon-close-thin']"));
    }

    private WebElement getSizeChartLink() {
        return driver.findElement(By.xpath("//a[@class='size-chart'][normalize-space()='size chart']"));
    }

    private WebElement getStockAvailabilityElement() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='in-stock-msg']")));
    }

    private WebElement getSetAvailabilityReminderButton() {
        return driver.findElement(By.xpath("//a[normalize-space()='Size/width no longer in stock?']"));
    }

    private WebElement getAddToCartButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='xlt-addToCart product-add-to-cart ']//button[@id='add-to-cart']")));
    }

    private WebElement getViewCartButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='View Cart']")));
    }

    private WebElement getKeepShoppingButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Keep Shopping']")));
    }

    // Page Actions
    public void verifyIdealSandalText(String expectedText) {
        WebElement textElement = getHeadlineText();
        String actualText = textElement.getText();

        // Use assertEquals to compare the expected and actual text
        try {
            assertEquals(expectedText, actualText);
        } catch (AssertionError e) {
            fail("Headline is not as expected: " + e.getMessage());
        }
    }






    public void verifySize() {
        WebElement sizeElement = getSizeElement();

        // Extract text from the div
        String sizeText = sizeElement.getText();

        // Split the text using the separator '|'
        String[] sizeValues = sizeText.split("\\|");

        // Assuming sizeValues[0] contains "2,5 UK" and sizeValues[1] contains "35 EU"
        String actualNum1 = cleanUpString(sizeValues[0]);
        String actualNum2 = cleanUpString(sizeValues[1]);
        //

        // Expected values after removing special characters
        String expectedNum1 = cleanUpString("2,5 UK");
        String expectedNum2 = cleanUpString("35 EU");


        // Assert the cleaned up values with the expected values obtained from the webpage
        assertEquals("Size does not match", actualNum1, expectedNum1);
        assertEquals("Size does not match", actualNum2, expectedNum2);

        System.out.println("Assert passed!");
    }


    // Utility method to clean up a string by removing special characters
    private String cleanUpString(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }




    public void verifyWidth() {
        WebElement widthElement = getWidthElement();

        // Wait for the element to be visible
        wait.until(ExpectedConditions.visibilityOf(widthElement));

        if (widthElement.isDisplayed()) {
            System.out.println("Width type displayed");
        } else {
            System.out.println("Width type not displayed.");
        }
    }

    public void verifyRecalculateButton() {
        WebElement recalculateButton = getRecalculateButton();

        if (!recalculateButton.isDisplayed()) {
            System.out.println("Recalculate button is not displayed");
        }
    }

    public void verifyProductDetails() {
        WebElement productDetailsElement = getProductDetailsElement();

        if (!productDetailsElement.isDisplayed()) {
            System.out.println("Product details element is not displayed");
        }
    }



    public void clickAddToCart() {
        WebElement addToCartButton = getAddToCartButton();
        addToCartButton.click();

        System.out.println("Clicked on Add to cart button.");

    }


    public void verifyLeftLengthElement() {
        WebElement leftLengthElement = getLeftLengthElement();

        if (!leftLengthElement.isDisplayed()) {
            System.out.println("Left length element is not displayed");
        }
    }

    public void verifyLeftWidthElement() {
        WebElement leftWidthElement = getLeftWidthElement();

        if (!leftWidthElement.isDisplayed()) {
            System.out.println("Left width element is not displayed");
        }
    }

    public void verifyRightLengthElement() {
        WebElement rightLengthElement = getRightLengthElement();

        if (!rightLengthElement.isDisplayed()) {
            System.out.println("Right length element is not displayed");
        }
    }

    public void verifyRightWidthElement() {
        WebElement rightWidthElement = getRightWidthElement();

        if (!rightWidthElement.isDisplayed()) {
            System.out.println("Right width element is not displayed");
        }
    }

    public void verifyProductImage() {
        WebElement productImageElement = getProductImageElement();

        if (!productImageElement.isDisplayed()) {
            System.out.println("Product image is not displayed");
        }
    }

    public void verifyCloseIcon() {
        WebElement closeIconElement = getCloseIconElement();

        if (!closeIconElement.isDisplayed()) {
            System.out.println("Close icon is not displayed");
        }
    }

    public void verifySizeChartLink() {
        WebElement sizeChartLink = getSizeChartLink();

        if (!sizeChartLink.isDisplayed()) {
            System.out.println("Size chart link is not displayed");
        }
    }

    public void verifyStockAvailability() {
        WebElement stockAvailabilityElement = getStockAvailabilityElement();

        if (!stockAvailabilityElement.isDisplayed()) {
            System.out.println("Stock availability element is not displayed");
        }
    }

    public void verifySetAvailabilityReminderButton() {
        WebElement setAvailabilityReminderButton = getSetAvailabilityReminderButton();

        if (!setAvailabilityReminderButton.isDisplayed()) {
            System.out.println("Set availability reminder button is not displayed");
        }
    }

    public void verifyViewCartButton() {
        WebElement viewCartButton = getViewCartButton();

        if (!viewCartButton.isDisplayed()) {
            System.out.println("View Cart button is not displayed");
        }
    }

    public void verifyKeepShoppingButton() {
        WebElement keepShoppingButton = getKeepShoppingButton();

        if (!keepShoppingButton.isDisplayed()) {
            System.out.println("Keep Shopping button is not displayed");
        }
    }
}

