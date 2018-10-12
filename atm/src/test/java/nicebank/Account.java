package nicebank;

import org.springframework.stereotype.Component;

@Component
public class Account {

    private Money balance = new Money();

    public Money getBalance() {
        return balance;
    }

    public void credit(Money amount){
        balance = balance.add(amount);
    }

    public void debit(int dollars){
        balance = balance.minus(new Money(dollars, 0));
    }
}
