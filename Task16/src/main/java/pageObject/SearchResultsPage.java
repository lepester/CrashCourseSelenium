package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{
    private By resultsGrid = By.cssSelector("div.goods-tile__inner");


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(resultsGrid).isDisplayed();
    }

}
