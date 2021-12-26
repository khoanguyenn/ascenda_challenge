package model;
public class Item implements ItemComponent {
    private int quantity;
    private String description;
    private double price;
    private boolean isImported;
    private ItemType itemType = ItemType.OTHERS;

    public Item(int quantity, String description, double price, boolean isImported, ItemType itemType) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.isImported = isImported;
        this.itemType = itemType;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getName() {
        return this.description;
    }

    public ItemType getType() {
        return this.itemType;
    }

    public boolean getImported() {
        return this.isImported;
    }
    @Override
    public double getTax() {
        return 0;
    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public double getTotal() {
        return price;
    } 
}
