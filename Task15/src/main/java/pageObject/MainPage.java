package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    @FindBy(xpath = "//a[@href='/food/']")
    private WebElement food;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get("https://pn.com.ua/");
        return this;
    }

    public FoodPage goToFoodPage() {
        food.click();
        return new FoodPage(driver);
    }
}
