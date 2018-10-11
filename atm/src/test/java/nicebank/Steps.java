package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.graalvm.compiler.nodes.extended.MonitorEnter;
import org.junit.Assert;
import transforms.MoneyConverter;

public class Steps {
    class Account{
        private Money balance = new Money();

        public void deposit(Money amount){
            balance = balance.add(amount);
        }

        public Money getBalance() {
            return balance;
        }
    }

    @Given("^I have deposited \\$(\\d+\\.\\d+) in  my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class)Money amount) throws Throwable {
        Account myAccount = new Account();
        myAccount.deposit(amount);

       Assert.assertEquals("Incorrect Account Balanace - ",
               amount, myAccount.getBalance());
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
