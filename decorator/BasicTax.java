package decorator;

import model.ItemComponent;
import model.ItemType;
import util.DecimalUtil;

public class BasicTax extends TaxDecorator {
    private int taxPrice = 10;
    public BasicTax(ItemComponent item) {
        super(item);
    }

    @Override
    public double getTax() {
        return this.taxPrice + this.item.getTax(); 
    }

    @Override
    public double getPrice() {
        return this.item.getPrice();
    }

    @Override
    public double getTotal() {
        return DecimalUtil.formatDecimal(getPrice() * (getTax() / 100 + 1));
    }

    @Override
    public int getQuantity() {
        return this.item.getQuantity();
    }

    @Override
    public String getName() {
        return this.item.getName();
    }

    @Override
    public boolean getImported() {
        return this.item.getImported();
    }

    @Override
    public ItemType getType() {
        return this.item.getType();
    }


}
