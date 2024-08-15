package CENG211_Homeworks.G17_CENG211_HW3;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class App implements IBorrowing, ISearchable {

    private ArrayList<Items> arrayList;

    private int priority;

    private int chargePerDay;

    private FileIO fileIO = new FileIO();

    public App() {
        setArrayList(fileIO.getItems());
    }

    public ArrayList<Items> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Items> arrayList) {
        this.arrayList = arrayList;
    }

    public int borrowCharge(int index) {
        priority = calculatePriority(index);
        chargePerDay = chargePerDayForItemType(index);
        return findNumberOfBorrowed(index) * priority * chargePerDay;
    }

    public int calculatePriority(int index) {
        int priority = 0;
        if (getArrayList().get(index).getPriority().equalsIgnoreCase("invaluable")) {
            priority = 3;
        } else if (getArrayList().get(index).getPriority().equalsIgnoreCase("highly significant")) {
            priority = 2;
        } else if (getArrayList().get(index).getPriority().equalsIgnoreCase("Noteworthy")) {
            priority = 1;
        }
        return priority;
    }

    public int chargePerDayForItemType(int index) {
        int chargePerDay = 0;
        if (getArrayList().get(index).getItemType().equalsIgnoreCase("book")) {
            chargePerDay = 5;
        } else if (getArrayList().get(index).getItemType().equalsIgnoreCase("magazine")) {
            chargePerDay = 10;
        }
        return chargePerDay;
    }

    public int findNumberOfBorrowed(int index) {
        int numberDayBorrowed = (int) ChronoUnit.DAYS.between(getArrayList().get(index).getStartBorrow(), getArrayList().get(index).getEndBorrow());
        return numberDayBorrowed;
    }

    public int lateCharge(int index) {
        if (findNumberOfBorrowed(index) > 10 && getArrayList().get(index).getItemType().equalsIgnoreCase("book")) {
            return 5;
        } else if (findNumberOfBorrowed(index) > 7 && getArrayList().get(index).getItemType().equalsIgnoreCase("magazine")) {
            return 2;
        } else {
            return 0;
        }
    }

    public double totalPrice(int index) {
        Member member = null;
        if (getArrayList().get(index).getCustomerType().equalsIgnoreCase("studentWOScholar")) {
            member = new StudentWoScholor();
            return member.totalPrice(borrowCharge(index), lateCharge(index));
        }
        if (getArrayList().get(index).getCustomerType().equalsIgnoreCase("studentWScholar")) {
            member = new StudentWScholor();
            return member.totalPrice(borrowCharge(index), lateCharge(index));
        }
        if (getArrayList().get(index).getCustomerType().equalsIgnoreCase("general")) {
            member = new General();
            return member.totalPrice(borrowCharge(index), lateCharge(index));
        }
        return 0;
    }

    public String exceed(int index) {
        if (getArrayList().get(index).getItemType().equalsIgnoreCase("book") && findNumberOfBorrowed(index) > 10) {
            return "Exceed: Exceeds";
        } else if (getArrayList().get(index).getItemType().equalsIgnoreCase("book") && findNumberOfBorrowed(index) <= 10) {
            return "Exceed: Not Exceeds";
        } else if (getArrayList().get(index).getItemType().equalsIgnoreCase("magazine") && findNumberOfBorrowed(index) > 7) {
            return "Exceed: Exceeds";
        } else if (getArrayList().get(index).getItemType().equalsIgnoreCase("magazine") && findNumberOfBorrowed(index) <= 7) {
            return "Exceed: Not Exceeds";
        }
        return "";
    }

    public int getIndex(String title) {
        int index = 0;
        for (int i = 0; i < getArrayList().size(); i++) {
            if (getArrayList().get(i).getTitle().equalsIgnoreCase(title)) {
                index = i;
                return index;
            }
        }
        return index;
    }
    @Override
    public boolean search(String title) {
        boolean check = false;
        for (Items items : getArrayList()) {
            if (items.getTitle().equalsIgnoreCase(title)) {
                check = true;
            }
        }
        return check;
    }
    @Override
    public boolean search(String title, String ItemType) {
        boolean check = false;
        for (Items items : getArrayList()) {
            if (items.getTitle().equalsIgnoreCase(title) && items.getItemType().equalsIgnoreCase("book")) {
                check = true;
            }
        }
        return check;
    }
    public void showBorrowedItemsInfo() {
        for (int i = 0; i < getArrayList().size(); i++) {
            Items items = getArrayList().get(i);
            System.out.println("Item Number:" + items.getItemNumber() + " Title:" + items.getTitle() + " Item Type:" + items.getItemType() +
                    " Borrowing Days:" + findNumberOfBorrowed(i) + " Exceed:" + exceed(i) + " Total Price:" + totalPrice(i));

        }
    }
    public void showStatusOfSearchedItems() {
        if (search("Animal Farm")) {
            int i = getIndex("Animal Farm");
            Items items = getArrayList().get(i);
            System.out.println("Item Number:" + items.getItemNumber() + " Title:" + items.getTitle() + " Item Type:" + items.getItemType() +
                    " Borrowing Days:" + findNumberOfBorrowed(i) + " Exceed:" + exceed(i) + " Total Price:" + totalPrice(i));
        } else {
            System.out.println("Does not exist.");
        }
        if (search("History of Art", "book")) {
            int i = getIndex("History of Art");
            Items items = getArrayList().get(i);
            System.out.println("Item Number:" + items.getItemNumber() + " Title:" + items.getTitle() + " Item Type:" + items.getItemType() +
                    " Borrowing Days:" + findNumberOfBorrowed(i) + " Exceed:" + exceed(i) + " Total Price:" + totalPrice(i));
        } else {
            System.out.println("Does not exist.");
        }
    }
}
