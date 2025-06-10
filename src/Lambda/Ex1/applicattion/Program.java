package Lambda.Ex1.applicattion;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Program {
    public static void main(String[] args) {
        String file = "/Users/augustocesarsouza/Documents/exemplo6.txt";

        Map<String,Double> mapProduct = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();

            while (line != null){
                String [] fields = line.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);
                mapProduct.put(name,price);
                line= br.readLine();
            }

            Optional<Double> sum = mapProduct
                    .values()
                    .stream()
                    .reduce(Double::sum);

            Optional<Double> avg = sum
                    .map(x -> sum.get()/ mapProduct.size());

            System.out.println("Average price: " + String.format("%.2f", avg.orElse(0.0)));

            for (String p : mapProduct.keySet()){
                if (mapProduct.get(p) < avg.get()){
                    System.out.println(p);
                }
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
