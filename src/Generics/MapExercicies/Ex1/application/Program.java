package Generics.MapExercicies.Ex1.application;

import Generics.MapExercicies.Ex1.entities.Candidates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

//        String file = "/Users/augustocesarsouza/Documents/exemplo2.txt";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String file = sc.next();

        File path = new File(file);

        Map<Candidates,Integer> cadidatesMap = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null){
                String [] fields = line.split(",");
                String name = fields[0];
                Integer votos = Integer.parseInt(fields[1]);
                Candidates candidates = new Candidates(name,votos);

                if (cadidatesMap.containsKey(candidates)){
                    cadidatesMap.put(candidates, cadidatesMap.get(candidates) + votos);

                } else {
                    cadidatesMap.put(candidates,votos);
                }
                line = br.readLine();
            }

            for (Candidates c : cadidatesMap.keySet()){
                System.out.println(c.getName() + ": " + cadidatesMap.get(c));
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
