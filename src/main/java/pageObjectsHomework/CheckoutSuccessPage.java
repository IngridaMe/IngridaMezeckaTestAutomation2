package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemInCartCheckout = By.className("inventory_item_name");

    private By inventoryItemName = By.cssSelector("div[class='inventory_item_name']");

    public WebElement itemInCartCheckout(){
        return driver.findElement(itemInCartCheckout);
    }
}
