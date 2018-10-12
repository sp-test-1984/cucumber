package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import support.KnowsMyDomain;
import transforms.MoneyConverter;

public class Steps {

    private KnowsMyDomain helper;

    public Steps(){
        this.helper = new KnowsMyDomain();
    }


    @Given("^I have deposited \\$(\\d+\\.\\d+) in  my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class)Money amount) throws Throwable {
        helper.getMyAccount().deposit(amount);

       Assert.assertEquals("Incorrect Account Balanace - ",
               amount, helper.getMyAccount().getBalance());
    }


    @When("^I withdraw \\$(\\d+)$")
    public void i_withdraw_$(int amount) throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
    }


    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int dollars) throws Throwable{
        Assert.assertEquals("Incorrect Amount Dispensed - ",
                dollars, helper.getCashSlot().getContents());
    }
}
