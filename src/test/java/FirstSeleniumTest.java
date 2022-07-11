import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver chromeParluks;

    @Test
    public void testPageTitle(){
        chromeParluks = new ChromeDriver(); //atver chrome browser tuksu lapu
        chromeParluks.navigate().to("http://www.lu.lv"); // neatver pilnaa logaa
       // chromeParluks.manage().window().fullscreen(); //atvers pilnaa logaa
        chromeParluks.manage().window().maximize();
        String expectedTitle = "Latvijas Universitāte";
        String actualTitle = chromeParluks.getTitle(); //paradi man ludzu lapas nosaukumu
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @AfterMethod
    public void closeBrowser(){
        chromeParluks.quit();
    }
    //k.ko papildinu, lai butu izmainas
}
