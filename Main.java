
import java.util.ArrayList;
import java.util.List;

import model.ItemBuilder;
import model.ItemComponent;
import model.ItemType;
import model.Reciept;
import strategy.Excel;

public class Main {
    public static List<ItemComponent> input_1() {
        List<ItemComponent> itemList = new ArrayList<>();

        ItemComponent book  = new ItemBuilder(1, "book", 12.49)
            .setType(ItemType.BOOK)
            .build();
        ItemComponent musicCd  = new ItemBuilder(1, "music cd", 14.99)
            .build();
        ItemComponent chocolateBar  = new ItemBuilder(1, "chocolate bar", 0.85)
            .setType(ItemType.FOOD)
            .build();
        
        itemList.add(book);
        itemList.add(musicCd);
        itemList.add(chocolateBar);

        return itemList;
    }
    public static List<ItemComponent> input_2() {
        List<ItemComponent> itemList = new ArrayList<>();

        ItemComponent importedChocolateBox  = new ItemBuilder(1, "imported box of chocolates", 10.00)
            .setImported(true)
            .setType(ItemType.FOOD)
            .build();
        ItemComponent importedPerfumeBottle = new ItemBuilder(1, "imported bottle of perfume", 47.50)
            .setImported(true)
            .build();
            
        itemList.add(importedChocolateBox);
        itemList.add(importedPerfumeBottle);

        return itemList;
    }
    public static List<ItemComponent> input_3() {
        List<ItemComponent> itemList = new ArrayList<>();

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
        
        itemList.add(importedPerfumeBottle);
        itemList.add(perfumeBottle);
        itemList.add(headachePill);
        itemList.add(chocolateBox);

        return itemList;
    }
    public static void main(String[] args) {
        //Get items
        //List<ItemComponent> items = input_1();
        //List<ItemComponent> items = input_2();
        List<ItemComponent> items = input_3();
        
        //Excel excelFormatter = new Excel();
        Reciept reciept = new Reciept();
        //reciept.setFormatter(excelFormatter);
        reciept.addItemList(items);
        reciept.format();
    }
}