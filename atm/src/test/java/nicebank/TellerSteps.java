package nicebank;

import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class TellerSteps {

    @Autowired
    Teller teller;

    @Autowired
    Account myAccount;

    @When("^I withdraw \\$(\\d+)$")
    public void i_withdraw_$(int amount) throws Throwable {
        teller.withdrawFrom(myAccount, amount);
    }
}
