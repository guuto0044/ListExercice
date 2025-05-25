package SetExercicies.ex2.application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        int n;

        System.out.print("How many Students for course A?");
        n = sc.nextInt();

        for (int i = 0; i < n; i++){
            Integer students = sc.nextInt();
            a.add(students);
        }
        System.out.print("How many Students for course B?");
        n = sc.nextInt();

        for (int i = 0; i < n; i++){
            Integer students = sc.nextInt();
            b.add(students);
        }
        System.out.print("How many Students for course C?");
         n = sc.nextInt();

        for (int i = 0; i < n; i++){
            Integer students = sc.nextInt();
            c.add(students);
        }

        Set<Integer> totalStudents = new HashSet<>(a);
        totalStudents.addAll(b);
        totalStudents.addAll(c);

        System.out.print("Total Students: " + totalStudents.size());



    }
}
