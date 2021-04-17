package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;
    @FindBy(id = "nav-search-submit-button")
    private WebElement buttonForSearch;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement logInButton;
    @FindBy(xpath = "//span[contains(text(), 'Music Library')]")
    private WebElement musicLibraryButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get("https://www.amazon.com/");
        return this;
    }

    public MainPage findSearchField() {
        searchField.isDisplayed();
        searchField.click();
        return this;
    }

    public SearchResultPage searchForGraphicsCard() {
        searchField.sendKeys("NVIDIA RTX 3060");
        buttonForSearch.click();
        return new SearchResultPage(driver);
    }

    public MusicLibraryPage musicLibraryPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(logInButton).perform();
        musicLibraryButton.click();
        return new MusicLibraryPage(driver);
    }
}
