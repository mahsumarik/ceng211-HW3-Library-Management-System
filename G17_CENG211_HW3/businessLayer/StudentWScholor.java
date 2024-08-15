package CENG211_Homeworks.G17_CENG211_HW3;

import java.time.temporal.ChronoUnit;

public class StudentWScholor extends Member{

    @Override
    public double discount(int borrowCharge, int lateCharge) {
        return (borrowCharge+lateCharge)*3/10;
    }

    @Override
    public double totalPrice(int borrowCharge, int lateCharge) {
        return borrowCharge+lateCharge-discount(borrowCharge,lateCharge);

    }
}
