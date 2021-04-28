import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaProductPage extends BasePage{
    private By tabItemMain = By.xpath("//product-tab-main");
    private By buyButton = By.cssSelector("span.buy-button__label");
    private By modalPreloader = By.xpath("//div[contains(@class,'modal__preloader')]");


    public RozetkaProductPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.visibilityOfElementLocated(tabItemMain));
    }

    public Checkout ClickToCheckout() {
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        WebElement target = driver.findElement(By.cssSelector("span.buy-button__label"));
        Actions actions = new Actions(driver);
        pageLoad.until(ExpectedConditions.elementToBeClickable(buyButton));
        actions.moveToElement(target).perform();
        target.click();

        pageLoad.until(ExpectedConditions.invisibilityOfElementLocated(modalPreloader));


        return new Checkout(driver);
    }
}