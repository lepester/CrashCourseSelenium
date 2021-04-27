import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{
    private By tabItemMain = By.xpath("//product-tab-main");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(tabItemMain).isDisplayed();

    }


}

