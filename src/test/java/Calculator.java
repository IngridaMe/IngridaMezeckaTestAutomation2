import org.testng.Assert;
import org.testng.annotations.*;

public class Calculator {
   private classroomSix.Calculator calculator;

    @Test
    public void testSum(){
        System.out.println("summas tests");
        int actualResult = calculator.sum(5, 3);
        int expectedResult = 8;
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(calculator.sum(5, 3), 8);
        Assert.assertEquals(calculator.sum(-5, 3), -2);
        Assert.assertEquals(calculator.sum(-5, -3), -8);
        Assert.assertEquals(calculator.sum(0, -3), -3);
        Assert.assertEquals(calculator.sum(5, 0), 5);
        Assert.assertEquals(calculator.sum(0, 0), 0);
        System.out.println("this is my first test ever!");
    }

    @Test
    public void testDalisana(){
        System.out.println("dalisanas tests");
        Assert.assertEquals(calculator.dalisana(12.4, 6.2), 2.0);
    }

    @Test
    public void izteiksmesTests(){
        System.out.println("izteiksmes tests");
        Assert.assertEquals(calculator.dalisana(8.2, 2.0) + calculator.sum(1, 2), 7.1);
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("izpidlas before CLASS"); // izpildas pirms katra testa!
        this.calculator = new classroomSix.Calculator(); // tad var izdzest so rindinu no parejam metodem, jo šis izpildisies vienmer!
    }

    @BeforeMethod
    public void izpildasPirmsKatraTESTA(){
        System.out.println("izpildas pirms katra testa metodes");
    }

}
