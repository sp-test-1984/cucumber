package nicebank;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
    class Account{
        public void deposit(int amount){

        }
    }

    @Given("^I have deposited \\$(\\d+) in  my account$")
    public void i_have_deposited_$_in_my_account(int amount) throws Throwable {
        Account myAccount = new Account();
        myAccount.deposit(amount);
    }


    @When("^I request \\$(\\d+)$")
    public void i_request_$(int arg1) throws Throwable{
        throw new PendingException();
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int arg1) throws Throwable{
        throw new PendingException();
    }
}
