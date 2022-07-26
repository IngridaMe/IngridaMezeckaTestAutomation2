package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepDefinitions {

    private int appleCount;
    private int eatenApplesCount;

    @Given("I have {int} apples")
    public void i_have_apples(int a) {
        System.out.println("i have " + a + " apples");
        appleCount = a;
    }
    @When("I eat {int} apples")
    public void i_eat_apples(int b) {
        System.out.println("i eat " + b + " apples");
        eatenApplesCount = b;
    }
    @Then("I have I have {int} apples left")
    public void i_have_i_have_apples_left(int c) {
        System.out.println("i have " + c + " apples left");
        int applesLeft = appleCount - eatenApplesCount;
        Assert.assertEquals(applesLeft, c);
    }

}
