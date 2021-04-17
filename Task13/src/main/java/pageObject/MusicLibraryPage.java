package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MusicLibraryPage {

    WebDriver driver;

    String musicLibraryHomePage = "https://music.amazon.com/?ref_=nav_AccountFlyout_cldplyr";
    @FindBy(xpath = "//music-shoveler[@primary-text='Laugh Out Loud Podcasts']")
    private WebElement musicPresented;

    public MusicLibraryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MusicLibraryPage verifyMusicLibraryPage() {
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.visibilityOf(musicPresented));
        Assert.assertEquals(driver.getCurrentUrl(), musicLibraryHomePage);
        return this;
    }
}
