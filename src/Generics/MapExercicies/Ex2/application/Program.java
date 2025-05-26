package Generics.MapExercicies.Ex2.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {

        String file = "/Users/augustocesarsouza/Documents/exemplo4.txt";

        Map<String,Integer> stock = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();

            while (line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                Integer qtdProduct = Integer.parseInt(fields[1]);
                if (stock.containsKey(name)){
                    stock.put(name,stock.get(name) + qtdProduct);
                } else {
                    stock.put(name,qtdProduct);
                }
                line = br.readLine();
            }

            for (String s : stock.keySet()){
                System.out.println(s + ": " + stock.get(s));
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
