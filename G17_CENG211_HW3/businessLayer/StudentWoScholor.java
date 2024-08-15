package CENG211_Homeworks.G17_CENG211_HW3;

public class StudentWoScholor extends Member {

    @Override
    public double discount(int borrowCharge, int lateCharge) {
        return (borrowCharge+lateCharge)*2/10;
    }

    @Override
    public double totalPrice(int borrowCharge, int lateCharge) {
        return borrowCharge+lateCharge-discount(borrowCharge,lateCharge);
    }
}
