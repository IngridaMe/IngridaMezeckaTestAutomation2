package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By loginButton = By.cssSelector("input#login-button");

    private By errorMessage = By.cssSelector("h3[data-test='error']");


    public void login(String username, String pasword){
        getUserNameField().sendKeys(username);
        getPasswordField().sendKeys(pasword);
        getLogginButton().click();
    }


    public WebElement getErrorMessageTextField(){
        return driver.findElement(errorMessage);
    }

            public WebElement getUserNameField(){
                return driver.findElement(userInputField);
            }

            public WebElement getPasswordField(){
                return driver.findElement(passwordInputField);
            }

            public WebElement getLogginButton(){
                return driver.findElement(loginButton);
            }

}
