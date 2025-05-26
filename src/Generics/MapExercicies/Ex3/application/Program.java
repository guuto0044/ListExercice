package Generics.MapExercicies.Ex3.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file with path: ");
        String file = sc.next();

        File path = new File(file);

        Map<String,Integer> stock = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null){

                String[] fields = line.split(",");
                String name = fields[0];
                Integer qtyProduct = Integer.parseInt(fields[1]);
                if (stock.containsKey(name)){
                    stock.put(name, stock.get(name) + qtyProduct);
                } else {
                    stock.put(name,qtyProduct);
                }
                line = br.readLine();
            }

            for (String s : stock.keySet()){
                System.out.println(s + ": " + stock.get(s));
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
