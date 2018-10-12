package nicebank;

import org.springframework.stereotype.Component;

@Component
public class CashSlot {

    private int contents;

    public int getContents() {
        return contents;
    }

    public void dispense(int dollars){
        contents = dollars;
    }
}
