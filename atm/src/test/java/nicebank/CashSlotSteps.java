package nicebank;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class CashSlotSteps {

    @Autowired
    CashSlot cashSlot;

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int dollars) throws Throwable{
        Assert.assertEquals("Incorrect Amount Dispensed - ",
                dollars, cashSlot.getContents());
    }
}
