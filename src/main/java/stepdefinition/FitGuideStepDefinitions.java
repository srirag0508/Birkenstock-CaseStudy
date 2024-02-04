package stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CartSummaryPage;
import pages.FitSizeFlyInScreen;
import pages.ProductPage;
import pages.ResultsPage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FitGuideStepDefinitions {


    private WebDriver driver;
    private ProductPage pp;
    private FitSizeFlyInScreen fs;

    private ResultsPage resultsPage;
    private CartSummaryPage cart;

    @Given("I am on the Product Display Page \\(PDP)")
    public void i_am_on_the_product_display_page_pdp() {

        pp = new ProductPage(SharedSD.getDriver(), Duration.ofSeconds(15));
        fs = new FitSizeFlyInScreen(SharedSD.getDriver(), Duration.ofSeconds(10));
        resultsPage = new ResultsPage(SharedSD.getDriver(), Duration.ofSeconds(10));
        cart = new CartSummaryPage(SharedSD.getDriver(), Duration.ofSeconds(10));


    }

    @When("I click on the Fit Guide link")
    public void i_click_on_the_fit_guide_link() {

        pp.clickFitGuideLink();

    }

    @When("I select the left foot measurements:")
    public void i_select_the_left_foot_measurements(DataTable dataTable) {
        // Retrieve data from the DataTable
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // Access specific values based on column names
        String leftLength = data.get(0).get("Length");
        String leftWidth = data.get(0).get("Width");

        // Perform actions with the retrieved data
        fs.selectFromDropdown("Left Foot Length", By.id("length-select-left"), leftLength);
        fs.selectFromDropdown("Left Foot Width", By.id("width-select-left"), leftWidth);
    }

    @When("I select the right foot measurements:")
    public void i_select_the_right_foot_measurements(DataTable dataTable) {
        // Retrieve data from the DataTable
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // Access specific values based on column names
        String rightLength = data.get(0).get("Length");
        String rightWidth = data.get(0).get("Width");

        // Perform actions with the retrieved data
        fs.selectFromDropdown("Right Foot Length", By.id("length-select-right"), rightLength);
        fs.selectFromDropdown("Right Foot Width", By.id("width-select-right"), rightWidth);
    }


    @And("I click on the calculate size button")
    public void iClickOnTheCalculateSizeButton() {

        if (fs.isCalculateButtonDisplayed()) {
            fs.clickCalculateSizeButton();
        } else {
            System.out.println("Calculate button is not displayed.");
        }
    }


    @Then("I verify the result displyed")
    public void iVerifyTheResultDisplyed() {
        // Verify Ideal Sandal Text
        resultsPage.verifyIdealSandalText("Your ideal sandal size and width are:");

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

    }

    @And("I verify the resulted Size")
    public void iVerifyTheResultedSize() {
        resultsPage.verifySize();

    }

    @And("I click on the Add to Shopping Cart button")
    public void iClickOnTheAddToShoppingCartButton() {
        // Verify Add to Cart is enbled
        resultsPage.clickAddToCart();
    }

    @Then("I should be redirected to the shopping cart")
    public void iShouldBeRedirectedToTheShoppingCart() {
        cart.verifyHeading();
        cart.verifyViewCartButton();
        cart.verifyKeepShoppingButton();
    }

    @And("I should see the product added with the calculated size")
    public void iShouldSeeTheProductAddedWithTheCalculatedSize() {
        cart.verifyproductdetails();

    }




}

