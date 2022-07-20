package classroomEight;

import acodemyShopp.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class AcodemyShopTest {

    RemoteWebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
 public void setupBrowser() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        //vienmeer vajag šo klasi. un url vajag
        driver = new RemoteWebDriver(new URL("http://192.168.8.139:4444"), chromeOptions);
     //startēe jaunu driveri, norada, uz kaadu servera adresi suutiit
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        SafariOptions browserOptions = new SafariOptions();
//        browserOptions.setCapability("platformName", "macOS 12");
//        browserOptions.setCapability("browserVersion", "15");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("build", "JURIS BUILD #1");
//        sauceOptions.put("name", "ACODEMY TESTS ON SAFARI MACOS");
//        browserOptions.setCapability("sauce:options", sauceOptions);
//
//        URL url = new URL("https://oauth-juriskreilis-41bd0:efd9da3a-ba54-4dd6-ad40-6d7061fc2c8c@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        driver = new RemoteWebDriver(url, browserOptions);
//

    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Beanie");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 2 results");
        mainPage.searchProduct("T-shirt");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 3 results");

        mainPage.searchProduct("Hoodie");
        Assert.assertEquals(mainPage.getSearchResults().size(),3);
        List<WebElement> results =  mainPage.getSearchResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("##########################");
            System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
        }
    }

    @Test
    public void testEmptySearch()  {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Ingrida");
        Assert.assertEquals(mainPage.getNoSearchResultText(),MainPage.NO_SEARCH_RESULTS);
    }

    @Test
    public void testSwitchTabs() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        // atver jaunu linku
        System.out.println(driver.getTitle());
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //pārslēdzas uz jauno tabu
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        driver.close();
        tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }

    @Test
    public void testJavascript() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        //pa taisno iekopēe, izpilda javascript uzreiz, skrollē uz leju
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("alert('INGRIDA INGRIDA')");
        //izvada alertu uz aaru
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.cssSelector("li.post-18"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //vienmēr jānorāda nulle. ieskrollē tā, lai es redzu konkrētu elementu
        Thread.sleep(4000);
    }
    @Test
    public void mouseActionsTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        //blaa blaa cookies piekrišana
        Actions actions = new Actions(driver);
        WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
        actions.moveToElement(hoverMeButton).perform();
        //uzbīdi peli uz pogas un izpildi darbiibu
        Thread.sleep(2000);
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(2000);
    }

    @Test
    public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform();
        //turu ctrl un turu k un izpildu
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }

}