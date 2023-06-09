import java.util.HashMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StockDetails {
    public static HashMap<String, FruitDetails> generate() throws IOException, FileNotFoundException {
        HashMap<String, FruitDetails> fruitIndexMap = new HashMap<String, FruitDetails>();
        FileReader fr = new FileReader("FruitList.csv");
        BufferedReader br = new BufferedReader(fr);

        // first line contains the headings of the columns, here we discard the line
        br.readLine();

        String line = "";

        // populate hashmap to store fruit data
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("")) {
                continue;
            }

            // generate individual strings seperated by comma
            final String[] words = line.split(",");

            final String name = words[0].trim();
            final Integer quantity = Integer.parseInt(words[1].trim());
            final Double pricePerKilo = Double.parseDouble(words[2].trim());

            fruitIndexMap.put(name, new FruitDetails(name, quantity, pricePerKilo));
        }

        br.close();
        fr.close();

        return fruitIndexMap;
    }

    public static void write(HashMap<String, FruitDetails> fruitIndexMap) throws IOException {
        FileWriter fw = new FileWriter("FruitList.csv");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("name,quantity,pricePerKilo");
        bw.newLine();

        for (String fruitName : fruitIndexMap.keySet()) {
            FruitDetails details = fruitIndexMap.get(fruitName);
            String outputString = String.format("%s,%d,%.2f", fruitName, details.getFruitQuantity(),
                    details.getPricePerKilo());
            bw.write(outputString);
            bw.newLine();
        }

        bw.close();
        fw.close();
    }
}
