package CENG211_Homeworks.G17_CENG211_HW3;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class Member  {

    public abstract double discount(int borrowCharge, int lateCharge);

    public abstract double totalPrice(int borrowCharge, int lateCharge);

}
