package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.ProductsPage;
import pageObjectsHomework.CartPage;
import pageObjectsHomework.CheckoutPage;
import pageObjectsHomework.InventoryPage;

import java.time.Duration;

public class SauceDemoTests {

    WebDriver driver;
    WebDriverWait wait;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";


    @BeforeMethod(alwaysRun = true)
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    //1. Navigēt uz saiti https://www.saucedemo.com/
    //2. Ielogoties ar pareizu lietotāja vārdu/paroli
    //3. Pārbaudīt, ka lietotājs ir ielogojies
    public void openWebPageLogInPage() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUserNameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.getLogginButton().click();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle().getText(), "PRODUCTS");
        Thread.sleep(5000);
    }

    @Test
    public void InventoryPageAddItemGoToCartCheckItem() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart().click();
        inventoryPage.DoneGoToCheckout().click();
    }

    @Test
    public void checkCartPage(){
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.isItemInCart().getText(), "Sauce Labs Bike Light");
        cartPage.goToCheckout().click();
    }

    @Test
    public void checkCheckoutPage(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getName().sendKeys("Ingrida");
        checkoutPage.getSurname().sendKeys("Mezecka");
        checkoutPage.getPostalCode().sendKeys("LV1234");
        checkoutPage.GetToContinueButton().click();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}

