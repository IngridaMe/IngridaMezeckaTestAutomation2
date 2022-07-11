package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTest {
    WebDriver chromeDriver;

    @BeforeMethod
    public void openWeb(){
    chromeDriver = new ChromeDriver();
    }

    @AfterMethod
    public void closeWeb(){
        chromeDriver.quit();
    }

    @Test
    public void testWebTitle(){
        chromeDriver.navigate().to("http://www.delfi.lv");
        chromeDriver.manage().window().maximize();
        String actualTitle = chromeDriver.getTitle();
        String expectedTitle = "DELFI - Vadošais ziņu portāls Latvijā - DELFI";
        Assert.assertEquals(actualTitle, expectedTitle);
    }


       @Test
       public void testWebTitleTwo(){

            chromeDriver.navigate().to("http://www.youtube.com");
            chromeDriver.manage().window().maximize();
            String actualTitleTwo = chromeDriver.getTitle();
            String expectedTitleTwo = "YouTube";
            Assert.assertEquals(actualTitleTwo, expectedTitleTwo);
        }

}
