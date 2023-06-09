/**
 * Class to write generated Invoice in the terminal
 */
public class InvoicePrinter {
    public static void printSuccess(String buyerName, String fruitName, int quantity,
            double unitPrice) {
        System.out.println("--------------:: PURCHASE SUCCESS ::--------------");
        System.out.println("Buyer's Name\t:: " + buyerName);
        System.out.println("Fruit Name\t:: " + StringModifier.toTitleCase(fruitName));
        System.out.println("Fruit Quantity\t:: " + quantity + "Kg");
        System.out.println("Price Per Kg\t:: $" + unitPrice);
        System.out.println("Total Price\t:: $" + (unitPrice * quantity));
    }

    public static void printQuantityNotAvailable() {
        System.out.println("***** Desired Quantity Not Available *****");
        System.out.println("-----------:: PURCHASE FAILED ::-----------");
    }

    public static void printFruitNotFound() {
        System.out.println("***** Desired Fruit Not Available *****");
        System.out.println("----------:: PURCHASE FAILED ::----------");
    }
}
