import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FruitSeller {
    public static void main(final String[] args) {
        final String outputFileName = "Sales.txt";
        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);) {

            HashMap<String, FruitDetails> fruitIndexMap = StockDetails.generate();

            System.out.println("-------- Welcome to the Fruit Buying System --------");

            System.out.print("Enter Your Name :: ");
            String buyerName = StringModifier.toTitleCase(br.readLine());

            boolean continueShopping = true;
            while (continueShopping) {
                System.out.print("Enter Fruit Name :: ");
                String fruitName = br.readLine().toLowerCase();

                if (fruitIndexMap.containsKey(fruitName)) {
                    int availableQuantity = fruitIndexMap.get(fruitName).getFruitQuantity();
                    double pricePerKilo = fruitIndexMap.get(fruitName).getPricePerKilo();

                    System.out.println("Quantity Available :: " + availableQuantity + "Kg");
                    System.out.println("Price Of " + StringModifier.toTitleCase(fruitName) + "/Kg :: $" + pricePerKilo);

                    System.out.print("Enter Required Quantity (in Kg) :: ");
                    Integer desiredQuantity = Integer.parseInt(br.readLine());

                    if (availableQuantity >= desiredQuantity) {
                        fruitIndexMap.get(fruitName).setFruitQuantity(availableQuantity - desiredQuantity);
                        InvoicePrinter.printSuccess(buyerName, fruitName, desiredQuantity, pricePerKilo);
                        InvoiceWriter.writeSuccess(outputFileName, buyerName, fruitName, desiredQuantity, pricePerKilo);
                    } else {
                        InvoicePrinter.printQuantityNotAvailable();
                        InvoiceWriter.writeQuantityNotAvailable(outputFileName, buyerName, fruitName, desiredQuantity);
                    }
                } else {
                    InvoicePrinter.printFruitNotFound();
                    InvoiceWriter.writeFruitNotFound(outputFileName, buyerName, fruitName);
                }
                System.out.print("Do you want to continue shopping? (yes/no): ");
                String continueChoice = br.readLine();

                if (continueChoice.equalsIgnoreCase("no")) {
                    continueShopping = false;
                }
            }

            StockDetails.write(fruitIndexMap);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
