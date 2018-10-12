package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import transforms.MoneyConverter;

public class Steps {

    private KnowsMyDomain helper;

    public Steps(){
        this.helper = new KnowsMyDomain();
    }

    class KnowsMyDomain{
        private Account myAccount;
        private CashSlot cashSlot;
        private Teller teller;

        public Account getMyAccount() {
            if(myAccount == null){
                myAccount = new Account();
            }
            return myAccount;
        }

        public CashSlot getCashSlot(){
            if(cashSlot == null){
                cashSlot = new CashSlot();
            }
            return cashSlot;
        }

        public Teller getTeller() {
            if(teller == null){
                teller = new Teller(getCashSlot());
            }
            return teller;
        }
    }


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
        private CashSlot cashSlot;

        public Teller(CashSlot cashSlot){
            this.cashSlot = cashSlot;
        }

        public void withdrawFrom(Account account, int dollars){
            cashSlot.dispense(dollars);
        }
    }

    class CashSlot{

        private int contents;

        public int getContents(){
            return contents;
        }

        public void dispense(int dollars){
            contents = dollars;
        }
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
