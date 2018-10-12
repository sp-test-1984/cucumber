package nicebank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teller {

    @Autowired
    CashSlot cashSlot;


    public void withdrawFrom(Account account, int dollars){
        cashSlot.dispense(dollars);
    }
}
