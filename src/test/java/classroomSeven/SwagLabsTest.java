package classroomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.Footer;
import pageObject.LoginPage;
import pageObject.ProductsPage;

import java.time.Duration;
import java.util.List;

public class SwagLabsTest {

    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";
    //lielie burti ar apaksvitram - tapec, ka final

    private final String LOCAL_URL = "file://C:\\Users\\ingri\\Desktop\\Studijas\\Automatizacija2022\\IngridaMezeckaTestAutomation\\elements.html";

    @BeforeMethod (alwaysRun = true)
    public void openBrowser() throws InterruptedException {
        System.out.println("atver testu");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
     public void testErrorMessage() throws InterruptedException {
        System.out.println("izpilda");
        driver.get(SWAGLABS_URL);

        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        //hvvb

        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("");

        //meklee login pogu
        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        userNameInputField.clear();
        passwordInputField.sendKeys("Password123");
        loginButton.click();
        actualErrorMessage = errorMessage.getText();
        expectedErrorMessage = "Epic sadface: Username is required";


        Thread.sleep(3000);
        System.out.println("izpilda testu");
    }

    @Test
    public void testFooterCopyRightText(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Footer footer = new Footer(driver);
        String actualString = footer.copyRightText().getText();
        String expectedString = "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        Assert.assertEquals(actualString, expectedString);
    }


    @Test
    public void testSuccessLoginPOM() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle().getText(), "PRODUCTS");
    }

    @Test
    public void testSucessfullLogin() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");

        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
        Assert.assertEquals(titleText.getText(), "PRODUCTS");

       // WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
//        linkedInLink.click();
//


        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropDown.selectByValue("hilo");
        Thread.sleep(5000);

        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addFleeceJacketToCartButton.click();
        Thread.sleep(5000);
    }


    @Test
    public void testErrorMassageWithoutPasswordWithPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Ingrida", "");
//        loginPage.getUserNameField().sendKeys("standard_user");
//        loginPage.getPasswordField().sendKeys("");
//        loginPage.getLogginButton().click();
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText, expectedErrorMessage);
    }

    @Test
    public void testErrorMessageWithoutUsernameWPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "parole");
//        loginPage.getUserNameField().sendKeys("");
//        loginPage.getPasswordField().sendKeys("parole");
//        loginPage.getLogginButton().click();
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }


    @Test
    public void testSuccessLogin() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle().getText(), "PRODUCTS");
    }

    @Test
    public void testSamplePage() throws InterruptedException {
    driver.get(LOCAL_URL);

    WebElement vards = driver.findElement(By.id("fNameID"));
    vards.sendKeys("Ingrida");

    WebElement uzvards = driver.findElement(By.id("lNameID"));
    uzvards.sendKeys("Mezecka");

   WebElement informacija = driver.findElement(By.name("description"));
   informacija.clear();
   informacija.sendKeys("Šī ir informācija par mani");


   WebElement studentCheckBox = driver.findElement(By.id("studentID"));
   studentCheckBox.click();

   WebElement radioButtonJava = driver.findElement(By.id("javaID"));
        System.out.println(radioButtonJava.isSelected());
   radioButtonJava.click();
        System.out.println(radioButtonJava.isSelected());


        Select milakaKrasaDropDown = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasaDropDown.selectByIndex(0);
        milakaKrasaDropDown.selectByIndex(1);

        List<WebElement> saraksts = milakaKrasaDropDown.getOptions();
        for (int i = 0; i < saraksts.size(); i++) {
            System.out.println(saraksts.get(i).getText());

        }
    Thread.sleep(5000);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //aizver brouseri
        driver.close();
        System.out.println("aizver ");
    }





    }
