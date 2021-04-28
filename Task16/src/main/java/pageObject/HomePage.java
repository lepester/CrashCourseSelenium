package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "input.search-form__input")
    private WebElement searchInput;
    @FindBy(css = "button.search-form__submit")
    private WebElement searchButton;
    @FindBy(css = "main.content_type_main")
    private WebElement sideBar;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage() {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public SearchResultsPage SearchProduct(String searchText){
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
