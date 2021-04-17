package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {

    WebDriver driver;

    @FindBy(id = "ppd")
    private WebElement verifyPage;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement logInButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyProductPagePresented() {
        Assert.assertTrue(verifyPage.isDisplayed());
    }

    public SignInPage logIn() {
        logInButton.click();
        return new SignInPage(driver);
    }
}
