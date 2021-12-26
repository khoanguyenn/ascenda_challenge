
import model.ItemBuilder;
import model.ItemComponent;
import model.ItemType;
import model.Reciept;
import strategy.Excel;
public class Main {
    public static void main(String[] args) {
        //Instantiate objects
        ItemComponent importedPerfumeBottle = new ItemBuilder(1, "imported bottle of perfume", 27.99)
                                .setImported(true)
                                .build();
        ItemComponent perfumeBottle = new ItemBuilder(1, "bottle of perfume", 18.99).build();
        ItemComponent headachePill = new ItemBuilder(1, "packet of headache pills", 9.75)
                                .setType(ItemType.MEDICAL)
                                .build();
        ItemComponent chocolateBox = new ItemBuilder(1, "box of imported chocolates", 11.25)
                                .setType(ItemType.FOOD)
                                .setImported(true)
                                .build();
        
        //Excel excelFormatter = new Excel();
        Reciept reciept = new Reciept();
        //reciept.setFormatter(excelFormatter);;
        reciept.addItem(importedPerfumeBottle);
        reciept.addItem(perfumeBottle);
        reciept.addItem(headachePill);
        reciept.addItem(chocolateBox);
        reciept.format();
    }
}