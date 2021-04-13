import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaProductPage extends BasePage{
    private By tabItemMain = By.xpath("//product-tab-main");

    public RozetkaProductPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.visibilityOfElementLocated(tabItemMain));
    }
}
