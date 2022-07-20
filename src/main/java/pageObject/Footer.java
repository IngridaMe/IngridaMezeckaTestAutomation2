package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {

    public WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    private By twitterLink = By.linkText("Twitter");
    private By fbLink = By.linkText("Facbook");
    private By linkedInLink = By.linkText("LinkedIn");
    private By copyRightText = By.cssSelector("div[class='footer_copy']");
    //privati mainitie, nevar piekluut no citurienes. vajag publiskas metodes - getterus citaa formaa

    public WebElement twitterLinkField(){
        return driver.findElement(twitterLink);
           }

    public WebElement fbLink(){
        return driver.findElement(fbLink);
    }

    public WebElement linkedIn(){
        return driver.findElement(linkedInLink);
    }

    public WebElement copyRightText(){
        return driver.findElement(copyRightText);
    }

}
