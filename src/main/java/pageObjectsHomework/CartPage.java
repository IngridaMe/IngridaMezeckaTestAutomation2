package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By isItemInCart = By.className("inventory_item_name");
    private By goToCheckout = By.id("checkout");


    public WebElement isItemInCart(){
        return driver.findElement(isItemInCart);
    }

    public WebElement goToCheckout(){
        return driver.findElement(goToCheckout);
    }

}
