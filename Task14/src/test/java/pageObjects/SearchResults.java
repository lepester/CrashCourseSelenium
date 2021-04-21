package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.BasePage;

public class SearchResults extends BasePage {
    private By softServePage = (By.xpath("//a[@href='https://softserve.academy/']"));
    private By searchResults = (By.cssSelector("div.GyAeWb"));

    public SearchResults(WebDriver driver) {
        this.driver = driver;
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.presenceOfElementLocated(searchResults));

    }

    public SoftServePage ClickSoftServeAcademy() {
        driver.findElement(softServePage).click();
        return new SoftServePage(driver);
    }
}
