package acodemyShopp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String NO_SEARCH_RESULTS = "No products were found matching your selection.";
    private By searchInputField = By.id("woocommerce-product-search-field-0");
    private By resultCountLabel = By.cssSelector("header[class='woocommerce-products-header']+div[class='storefront-sorting'] p");
    private By searchResults = By.cssSelector("li[class*='product']");

    private By noResultsInfoText = By.cssSelector("p.woocommerce-info");

    public String getNoSearchResultText(){
        return driver.findElement(noResultsInfoText).getText();
    }

    public List<WebElement> getSearchResults(){
        return driver.findElements(searchResults);
    }
    //atgriež masīvu ar elementiem augšejais

    public WebElement getSearchInputField(){
        return driver.findElement(searchInputField);
    }


    public String getSearchResultText(){
        return driver.findElement(resultCountLabel).getText();
    }

    public void searchProduct(String searchQuery){
        getSearchInputField().clear();
        //šo vienmēr vajag notīrīt
        getSearchInputField().sendKeys(searchQuery);
        //2.darbība - kas jāieraksta
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

}