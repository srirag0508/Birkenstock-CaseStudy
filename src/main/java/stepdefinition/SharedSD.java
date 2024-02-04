package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SharedSD {
    private static WebDriver driver;

    @Before
    public void openUrl() throws InterruptedException {
        /* Initialize ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); */

        System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.birkenstock.com/gb/arizona-birko-flor-nubuck/arizona-core-birkoflornubuck-0-eva-u_650.html");

        // Create a Duration object representing 5 seconds
        Duration waitDuration = Duration.ofSeconds(10);

        // Set up a WebDriverWait object with the specified timeout
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);

        // Wait for the cookie settings element to be visible and clickable
        WebElement cookieSettings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Cookie Settings']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=' button button-custom-green solid confirm-button check-all-button']")));

        // Click on the cookie settings and accept all button
        cookieSettings.click();
        driver.findElement(By.xpath("//div[@class=' button button-custom-green solid confirm-button check-all-button']")).click();

        // Wait for the country switcher element to be clickable
        WebElement countrySwitcher = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='country-switcher']")));

        // Click on the country switcher
        countrySwitcher.click();
        // Wait for the page to load completely

        driver.navigate().refresh();
        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
