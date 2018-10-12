package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import transforms.MoneyConverter;

public class AccountSteps {

    @Autowired
    Account myAccount;

    @Given("^my account has been credited with \\$(\\d+\\.\\d+)$")
    public void my_account_has_been_credited_with_$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        myAccount.credit(amount);
    }

    @Then("^the balance of my account should be \\$(\\d+\\.\\d+)$")
    public void the_balance_of_my_account_should_be_$(@Transform(MoneyConverter.class)  Money amount) throws Throwable {
        Assert.assertEquals("Incorrect Account Balance -",
                amount, myAccount.getBalance());
    }



}
