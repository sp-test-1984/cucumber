package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import transforms.MoneyConverter;

public class AccountSteps {

    @Autowired
    Account myAccount;

    @Given("^I have deposited \\$(\\d+\\.\\d+) in  my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class)Money amount) throws Throwable {
        myAccount.deposit(amount);

        Assert.assertEquals("Incorrect Account Balance - ",
                amount, myAccount.getBalance());
    }
}
