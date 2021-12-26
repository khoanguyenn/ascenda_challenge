package model;
import java.util.ArrayList;
import java.util.List;

import strategy.FormatStrategy;
import strategy.Standard;

/**
 * Reciept
 */
public class Reciept {
    List<ItemComponent> itemList = new ArrayList<>();
    FormatStrategy formatter = new Standard();
    public Reciept(){};
    public void addItem(ItemComponent item) {
        itemList.add(item);
    }
    public void addItemList(List<ItemComponent> itemList) {
        this.itemList.addAll(itemList);
    }
    public void setFormatter(FormatStrategy formatter) {
        this.formatter = formatter;
    }
    public void format() {
        this.formatter.format(this);
    }

    public List<ItemComponent> getItems() {
        return this.itemList;
    }
    public double getTotalTax() {
        double totalTax = 0.0f;
        for (ItemComponent itemComponent : itemList) {
            totalTax += itemComponent.getPrice() * itemComponent.getTax() / 100;
        }
        return totalTax;
    };
    public double getTotalPrice() {
        double totalPrice = 0.0f;
        for (ItemComponent itemComponent : itemList) {
            totalPrice += itemComponent.getTotal();
        }
        return totalPrice;
    };
}