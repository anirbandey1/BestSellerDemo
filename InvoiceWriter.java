import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Class to write generated Invoice to the desired output file.
 */
public class InvoiceWriter {
    public static void writeSuccess(String fileName, String buyerName, String fruitName, int quantity,
            double unitPrice) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.flush();
        bw.write("--------------:: PURCHASE SUCCESS ::--------------");
        bw.newLine();
        bw.write("Buyer's Name\t:: " + buyerName);
        bw.newLine();
        bw.write("Fruit Name\t\t:: " + StringModifier.toTitleCase(fruitName));
        bw.newLine();
        bw.write("Fruit Quantity\t:: " + quantity);
        bw.newLine();
        bw.write("Price Per Kilo\t:: $" + unitPrice);
        bw.newLine();
        bw.write("Total Price\t\t:: $" + (unitPrice * quantity));
        bw.newLine();

        bw.close();
        fw.close();
    }

    public static void writeQuantityNotAvailable(String fileName, String buyerName, String fruitName,
            int desiredQuantity) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.flush();
        bw.write("--------------:: PURCHASE FAILED ::--------------");
        bw.newLine();
        bw.write("Buyer's Name\t:: " + buyerName);
        bw.newLine();
        bw.write("Fruit Name\t\t:: " + StringModifier.toTitleCase(fruitName));
        bw.newLine();
        bw.write("Desired Quantity\t:: " + desiredQuantity);
        bw.newLine();
        bw.write("ERR :: Required Quantity Not Available.");
        bw.newLine();

        bw.close();
        fw.close();
    }

    public static void writeFruitNotFound(String fileName, String buyerName, String desiredFruitName)
            throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.flush();
        bw.write("--------------:: PURCHASE FAILED ::--------------");
        bw.newLine();
        bw.write("Buyer's Name\t:: " + buyerName);
        bw.newLine();
        bw.write("Fruit Name\t\t:: " + StringModifier.toTitleCase(desiredFruitName));
        bw.newLine();
        bw.write("ERR :: Desired Fruit Not Available.");
        bw.newLine();

        bw.close();
        fw.close();
    }
}
