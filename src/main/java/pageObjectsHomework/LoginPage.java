package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By usernameInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By logginButton = By.id("input#login-button");

    public WebElement getUsernameField(){
        return driver.findElement(usernameInputField);
    }

    public WebElement getPasswordField(){
        return driver.findElement(passwordInputField);
    }

    public WebElement getLogginButton(){
        return driver.findElement(logginButton);
    }
}
