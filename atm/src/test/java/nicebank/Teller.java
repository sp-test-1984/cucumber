package nicebank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teller {

    @Autowired
    CashSlot cashSlot;

    @Autowired
    Account myAccount;

    public void withdrawFrom(Account account, int dollars){
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }
}
