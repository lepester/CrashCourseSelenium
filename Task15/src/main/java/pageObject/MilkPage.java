package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

public class MilkPage extends BasePage {

    @FindBy(css = "ul.short-menu")
    private WebElement shortMenu;
    @FindBy(css = "li.dropdown-sorting")
    private WebElement sortMenu;
    @FindBy(xpath = "//a[@data-sort='price']")
    private WebElement getPriceAsc;
    @FindBy(xpath = "//a[@data-sort='price_desc']")
    private WebElement getPriceDesc;
    @FindBy(xpath = "//a[@data-sort='offer']")
    private WebElement dropdownMenu;
    @FindBy(id = "price-min")
    private WebElement minPrice;
    @FindBy(id = "price-max")
    private WebElement maxPrice;


    public MilkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        shortMenu.isDisplayed();

    }

    public MilkPage priceAsc() {
        sortMenu.click();
        dropdownMenu.isDisplayed();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(getPriceAsc).click().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MilkPage priceDesc() {
        sortMenu.click();
        getPriceDesc.isDisplayed();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(getPriceDesc).click().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MilkPage fieldValidation(String stringToVerify) {
            minPrice.clear();
            minPrice.sendKeys(stringToVerify);

            maxPrice.clear();
            maxPrice.sendKeys(stringToVerify);
        return this;
    }

    public MilkPage getPricesAsc() {
        List<WebElement> elementsList = driver.findElements(By.xpath("(//div[@class='avg-price'])[position()>0 and position()<=3]"));

        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        System.out.println(sortedList);
        return this;
    }

    public MilkPage getPricesDesc() {
        List<WebElement> elementsList = driver.findElements(By.xpath("(//div[@class='avg-price'])[position()>0 and position()<=3]"));

        List<String> originalList = elementsList.stream().map(WebElement::getText).collect(Collectors.toList());

        System.out.println(originalList);
        return this;
    }
}
