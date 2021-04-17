package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), 'NVIDIA GeForce RTX 3060')]")
    private WebElement graphicsCard;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyGraphicsCardPresented() {
        Assert.assertTrue(graphicsCard.isDisplayed());
    }

    public ProductPage ProductPage() {
        graphicsCard.click();
        return new ProductPage(driver);
    }
}
