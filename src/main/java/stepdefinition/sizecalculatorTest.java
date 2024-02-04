package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartSummaryPage;
import pages.FitSizeFlyInScreen;
import pages.ProductPage;
import pages.ResultsPage;
import stepdefinition.SharedSD;

import java.time.Duration;

public class sizecalculatorTest {

    private WebDriver driver;
    private  ProductPage pp;
    private FitSizeFlyInScreen fs;

    private ResultsPage resultsPage;
    private CartSummaryPage cart;




    @Given("I am on the Size Calculator")
    public void i_am_on_the_size_calculator() {
        pp = new ProductPage(SharedSD.getDriver(), Duration.ofSeconds(15));
        fs = new FitSizeFlyInScreen(SharedSD.getDriver(), Duration.ofSeconds(10));
        resultsPage = new ResultsPage(SharedSD.getDriver(), Duration.ofSeconds(10));
        cart = new CartSummaryPage(SharedSD.getDriver(), Duration.ofSeconds(10));

        pp.clickFitGuideLink();
    }

    @When("I enter foot measurements and click calculate")
    public void iEnterFootMeasurementsAndClickCalculate() {
        //WebElement calculateButton = fs.getCalculateButton();
        if (fs.isCalculateButtonDisplayed()) {
            fs.selectMeasurements("220 mm", "85 mm", "220 mm", "85 mm");
            fs.calculateButton.click(); // click the calculate button
        } else {
            System.out.println("Calculate button is not displayed.");
        }
    }


    @Then("I verify the result Screen")
    public void iVerifyTheResultScreen() {

             // Verify Ideal Sandal Text
            resultsPage.verifyIdealSandalText("");

            // Verify Size
            resultsPage.verifySize();

            // Verify Width
            resultsPage.verifyWidth();

            // Verify Recalculate Button
            resultsPage.verifyRecalculateButton();

            // Verify Product Details
            resultsPage.verifyProductDetails();

            // Verify Left and Right Length and Width Elements
            resultsPage.verifyLeftLengthElement();
            resultsPage.verifyLeftWidthElement();
            resultsPage.verifyRightLengthElement();
            resultsPage.verifyRightWidthElement();

            // Verify Product Image
            resultsPage.verifyProductImage();

            // Verify Close Icon
            resultsPage.verifyCloseIcon();

            // Verify Size Chart Link
            resultsPage.verifySizeChartLink();

            // Verify Stock Availability
            resultsPage.verifyStockAvailability();

            // Verify Add to Cart
            resultsPage.clickAddToCart();

        }


    @Then("Then I click Add to Cart")
    public void then_i_click_add_to_cart() {

        // Verify if the page loads will elements

        cart.verifyHeading();
        cart.verifyViewCartButton();
        cart.verifyKeepShoppingButton();
    }

    }

