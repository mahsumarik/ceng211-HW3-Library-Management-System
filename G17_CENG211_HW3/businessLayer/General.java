package CENG211_Homeworks.G17_CENG211_HW3;

import com.sun.tools.attach.AgentInitializationException;

public class General  extends Member{


    @Override
    public double discount(int borrowCharge, int lateCharge) {
        return 0;
    }
    @Override
    public double totalPrice(int borrowCharge, int lateCharge) {
        return borrowCharge+lateCharge-discount(borrowCharge,lateCharge);
    }
}
