package strategy;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import model.ItemComponent;
import model.Reciept;

public class Excel implements FormatStrategy {
    // Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    // CSV file header
    private static final String FILE_HEADER = "quantity,name,price";
    private static final String fileName = "data/receipt.csv";

    @Override
    public void format(Reciept receipt) {
        List<ItemComponent> items = receipt.getItems();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);

            // Write the CSV file header
            fileWriter.append(FILE_HEADER);

            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            System.out.println("Writing CSV file...");
            // Write a new Country object list to the CSV file
            for (ItemComponent itemComponent : items) {
                fileWriter.append(String.valueOf(itemComponent.getQuantity()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(itemComponent.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(itemComponent.getTotal()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            //Write sale taxes
            fileWriter.append("Sales taxes");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.format("%.1f",receipt.getTotalTax()));
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write total
            fileWriter.append("Total");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.format("%.2f",receipt.getTotalPrice()));
            fileWriter.append(NEW_LINE_SEPARATOR);

            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        } 
    }
}
