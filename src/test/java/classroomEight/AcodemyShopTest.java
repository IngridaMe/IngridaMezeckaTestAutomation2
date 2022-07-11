package classroomEight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AcodemyShopTest {
//kajsefjshfjdx
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testSearsh() throws InterruptedException {
        driver.get("https://shop.acodemy.lv/");
        //MainPage mainPage = new MainPage(driver);

        Thread.sleep(5000);
    }
    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }
}
