package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    public WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCart = By.className("btn btn_primary btn_small btn_inventory");
    private By goToCheckOut = By.className("shopping_cart_container");

//    public WebElement getUsernameField(){
//        return driver.findElement(usernameInputField);
//    }

    public WebElement addItemToCart(){
        return driver.findElement(addToCart);
    }

    public WebElement DoneGoToCheckout(){
        return driver.findElement(goToCheckOut);
    }
}
