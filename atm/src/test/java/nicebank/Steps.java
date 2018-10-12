package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import transforms.MoneyConverter;

public class Steps {

    private Account myAccount;


    class Account{
        private Money balance = new Money();

        public void deposit(Money amount){
            balance = balance.add(amount);
        }

        public Money getBalance() {
            return balance;
        }
    }

    class Teller{
        public void withdrawFrom(Account account, int amount){

        }
    }

    @Given("^I have deposited \\$(\\d+\\.\\d+) in  my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class)Money amount) throws Throwable {
        myAccount = new Account();
        myAccount.deposit(amount);

       Assert.assertEquals("Incorrect Account Balanace - ",
               amount, myAccount.getBalance());
    }


    @When("^I withdraw \\$(\\d+)$")
    public void i_withdraw_$(int amount) throws Throwable {
        Teller teller = new Teller();
        teller.withdrawFrom(myAccount, amount);
    }


    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int arg1) throws Throwable{
        throw new PendingException();
    }
}
