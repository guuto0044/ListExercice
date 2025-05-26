package Generics.SetExercicies.ex1.application;

import Generics.SetExercicies.ex1.entities.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
//        String file = "/Users/augustocesarsouza/Documents/exemplo1.txt";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter fille full path: ");
        String file = sc.next();

        File path = new File(file);

        Set<User> setUsers = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while (line != null){
                String [] fields = line.split(" ");
                String nickname = fields[0];
                Date dateTime = Date.from(Instant.parse(fields[1]));
                User user = new User(nickname,dateTime);
                setUsers.add(user);
                line = br.readLine();
            }

            System.out.print("Total Users:" + setUsers.size());

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
