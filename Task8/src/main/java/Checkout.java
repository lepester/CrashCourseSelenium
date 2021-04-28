import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout extends BasePage{

    private By checkoutPage = By.cssSelector("div.modal__holder");

    public Checkout(WebDriver driver) {
        this.driver = driver;
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.invisibilityOfElementLocated(checkoutPage));
    }

    public CheckoutPage checkoutPage() {
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://rozetka.com.ua//checkout/']")));
        WebElement acceptYes = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua//checkout/']"));
        acceptYes.click();

        String preloaderLine = "//div[@class='preloader']";
        pageLoad.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(preloaderLine)));
        return new CheckoutPage(driver);
    }
}
