package model;

public interface ItemComponent {
    int getQuantity();
    String getName();
    boolean getImported();
    double getTax(); //Get tax of the items
    double getPrice(); //Get price of the items
    double getTotal(); //Get total price after applying tax
    ItemType getType();
}
