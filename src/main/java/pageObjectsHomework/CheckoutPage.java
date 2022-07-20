package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By name = By.name("firstName");
    private By surname = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    public WebElement getName(){
        return driver.findElement(name);
    }

    public WebElement getSurname(){
        return driver.findElement(surname);
    }

    public WebElement getPostalCode(){
        return driver.findElement(postalCode);
    }

    public WebElement GetToContinueButton(){
        return driver.findElement(continueButton);
    }
}
