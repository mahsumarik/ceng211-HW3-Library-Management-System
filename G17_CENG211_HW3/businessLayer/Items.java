package CENG211_Homeworks.G17_CENG211_HW3;

import java.time.LocalDate;

public class Items {

    private String itemNumber;

    private String title;

    private String priority;

    private String ItemType;

    private String CustomerType;

    private LocalDate startBorrow;

    private LocalDate endBorrow;

    public Items(String itemNumber, String title, String priority, String itemType, String customerType, LocalDate startBorrow, LocalDate endBorrow) {
        this.itemNumber = itemNumber;
        this.title = title;
        this.priority = priority;
        ItemType = itemType;
        CustomerType = customerType;
        this.startBorrow = startBorrow;
        this.endBorrow = endBorrow;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public String getTitle() {
        return title;
    }


    public String getPriority() {
        return priority;
    }


    public String getItemType() {
        return ItemType;
    }


    public String getCustomerType() {
        return CustomerType;
    }

    public LocalDate getStartBorrow() {
        return startBorrow;
    }

    public LocalDate getEndBorrow() {
        return endBorrow;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemNumber='" + itemNumber + '\'' +
                ", title='" + title + '\'' +
                ", priority='" + priority + '\'' +
                ", ItemType='" + ItemType + '\'' +
                ", CustomerType='" + CustomerType + '\'' +
                ", startBorrow=" + startBorrow +
                ", endBorrow=" + endBorrow +
                '}';
    }
}
