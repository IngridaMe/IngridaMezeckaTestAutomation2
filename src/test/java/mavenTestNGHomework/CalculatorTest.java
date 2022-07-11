package mavenTestNGHomework;

import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;


public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void testAdd(){
        System.out.println("Sākas testAdd tests");
//    int actualResult = calculator.sum(4, 5);
//    int expectedResult = 9;
    Assert.assertEquals(calculator.sum(4, 5), 9);
    Assert.assertEquals(calculator.sum(-90, 5), -85);
    Assert.assertEquals(calculator.sum(0, 2), 2);

    }

    @Test
    public void testMinus(){
        System.out.println("Sākas testMinus tests");
        Assert.assertEquals(calculator.minus(7, 2), 5);
        Assert.assertEquals(calculator.minus(-7, 0), -7);
    }

    @BeforeMethod
    public void pirmsKatraTesta(){
        System.out.println("Tests ir sācies");
    }

    @AfterMethod
    public void pecKatraTesta(){
        System.out.println("Tests ir beidzies");
    }

    @BeforeClass
    public void pirmsKlases(){
        System.out.println("Veiksmes vēlējumi pirms testa uzsākšanas!");
        this.calculator = new Calculator();
    }

    @AfterClass
    public void pecKlases(){
        System.out.println("YES! Viss tests ir pabeigts!");
    }
}
