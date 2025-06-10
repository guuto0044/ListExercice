package Lambda.Ex2.application;

import Lambda.Ex2.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale .setDefault(Locale.US);

//        String file = "/Users/augustocesarsouza/Documents/exemplo7.txt";

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter full file Path: ");
        String file = sc.next();

        List<Employee>list = new ArrayList<>();


        System.out.print("Enter Salary: R$");
        Double salary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){

            String line = br.readLine();

            while (line != null){
                String [] fields = line.split(",");
                String name = fields[0];
                String email = fields[1];
                Double salarys = Double.parseDouble(fields[2]);
                Employee employee = new Employee(name, email,salarys);
                list.add(employee);
                line = br.readLine();
            }

            System.out.println("Email of people whose salary is less than " + String.format("%.2f", salary) + ":");

            Set<String> emails = list.stream()
                    .filter(x -> x.getSalary() > salary)
                    .map(Employee::getEmail)
                    .collect(java.util.stream.Collectors.toSet());
            emails.stream()
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
