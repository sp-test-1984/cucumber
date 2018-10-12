package nicebank;

public class Account {

    private Money balance = new Money();

    public Money getBalance() {
        return balance;
    }

    public void deposit(Money amount){
        balance = balance.add(amount);
    }
}
