package decorator;

import model.ItemComponent;

public abstract class TaxDecorator implements ItemComponent {
    protected ItemComponent item;
    protected TaxDecorator(ItemComponent item) {
        this.item = item;
    }
}
