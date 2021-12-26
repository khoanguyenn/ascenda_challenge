package strategy;

import model.ItemComponent;
import model.Reciept;
import java.util.List;

public class Standard implements FormatStrategy {
    @Override
    public void format(Reciept reciept) {
        List<ItemComponent> items = reciept.getItems();
        String output = "";
        for (ItemComponent item : items) {
            output += String.format("%d, %s, %.2f \n", item.getQuantity(), item.getName(), item.getTotal());
        }
        System.out.println(output);
        System.out.println(String.format("Sales taxes: %.1f", reciept.getTotalTax()));
        System.out.println(String.format("Total: %.2f", reciept.getTotalPrice()));
    }
    
}
