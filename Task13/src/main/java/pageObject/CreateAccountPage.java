package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateAccountPage {

    WebDriver driver;

    @FindBy(id = "ap_customer_name")
    private WebElement yourName;
    @FindBy(id = "ap_email")
    private WebElement email;
    @FindBy(id = "ap_password")
    private WebElement password;
    @FindBy(id = "ap_password_check")
    private WebElement reEnterPassword;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCreateAccountPage() {
        Assert.assertTrue(yourName.isDisplayed());
    }

    public CreateAccountPage enterYourName() {
        yourName.click();
        yourName.clear();
        yourName.sendKeys("Dmitriy Gordon");
        return this;
    }

    public CreateAccountPage enterEmail() {
        email.click();
        email.clear();
        email.sendKeys("gordon@gmail.com");
        return this;
    }

    public CreateAccountPage enterPassword() {
        password.click();
        password.clear();
        password.sendKeys("GorDmitri911_l");
        return this;
    }

    public CreateAccountPage reEnterPassword() {
        reEnterPassword.click();
        reEnterPassword.clear();
        reEnterPassword.sendKeys("GorDmitri911_l");

        //sleep just for better visibility
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}

