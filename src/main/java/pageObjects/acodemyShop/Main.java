package pageObjects.acodemyShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Main {
    public WebDriver driver;
    public void MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By searchInputField = By.id("woocommerce-product-search-field-0");

    public WebElement getSearchInputField(){
        return driver.findElement(searchInputField);
    }


}
