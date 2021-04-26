package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoodPage extends BasePage {

    @FindBy(xpath = "//a[@href='/ct/9302/']")
    private WebElement milk;

    public FoodPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MilkPage GoToMilkPage() {
    milk.click();
    return new MilkPage(driver);
    }
}
