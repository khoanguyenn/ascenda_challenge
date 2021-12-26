package model;
import decorator.BasicTax;
import decorator.ImportedTax;

public class ItemBuilder {
    private int quantity;
    private double price;
    private String itemName;
    private boolean isImported = false;
    private ItemType itemType = ItemType.OTHERS;

    public ItemBuilder(int quantity, String itemName, double price) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
    }

    public ItemBuilder setImported(boolean isImported) {
        this.isImported = isImported;
        return this;
    }

    public ItemBuilder setType(ItemType itemType) {
        this.itemType = itemType;
        return this;
    }
    
    public ItemComponent applyTax(Item item) {
        ItemComponent applyItem = item;
        if (item.getType() != ItemType.MEDICAL 
            && item.getType() != ItemType.BOOK 
            && item.getType() != ItemType.FOOD) {
                applyItem = new BasicTax(applyItem);
        }
        if (item.getImported()) {
            applyItem = new ImportedTax(applyItem);
        }
        return applyItem;
    }

    public void validateItem() {
        if (quantity == 0) {
            throw new Error("No quantity provided!");
        }
        if (price == 0) {
            throw new Error("No price provided!");
        }
        if (itemName == null) {
            throw new Error("No item's price provided!");
        }
    }
    public void clearItem() {
        this.quantity = 0;
        this.isImported = false;
        this.itemName = null;
        this.itemType = ItemType.OTHERS;
        this.price = 0;
    }

    public ItemComponent build() {
        validateItem();
        Item item = new Item(quantity, itemName, price, isImported, itemType);
        ItemComponent taxApplyItem = applyTax(item);
        clearItem();
        return taxApplyItem;
    }

}
