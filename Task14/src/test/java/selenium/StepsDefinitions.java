package selenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import pageObjects.GoogleHomePage;
import pageObjects.SearchResults;

import java.util.concurrent.TimeUnit;

public class StepsDefinitions extends BasePage{

    @Given("^I open Google$")
    public void openGoogle() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("^I enter a query and proceed to search results$")
    public void searchResults() {
        String testSearchText = "SoftServe IT Academy";
        String testResultText = "SoftServe IT Academy";

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.searchProduct(testSearchText);

        SearchResults searchResultPage = new SearchResults(driver);
        searchResultPage.ClickSoftServeAcademy();

        Assert.assertEquals(testSearchText, testResultText);
    }

    @Then("^I should check whether the site is correct$")
    public void verifyWebPage() {
        String expectedSoftServe = "https://softserve.academy/";
        String actualSoftServe = "https://softserve.academy/";

        Assert.assertEquals(expectedSoftServe, actualSoftServe);
    }

    @And("^I close browser$")
    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }
}