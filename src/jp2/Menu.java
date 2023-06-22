package src.jp2;




import com.sun.javafx.fxml.builder.ProxyBuilder;
import javafx.beans.binding.MapExpression;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {




    public static void main(String[] args) {
        Map<String, Customer> customers = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Customer Relationship Management");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    scanner.nextLine(); // Consume newline character
                    String name = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter customer phone: ");
                    String phone = scanner.nextLine();

                    Customer customer = new Customer(name, email, phone);
                    customers.put(name, customer);
                    System.out.println("Customer added successfully.");
                    break;

                case 2:
                    System.out.print("Enter customer name to search: ");
                    scanner.nextLine(); // Consume newline character
                    String searchName = scanner.nextLine();
                    Customer foundCustomer = customers.get(searchName);
                    if (foundCustomer != null) {
                        System.out.println("Name: " + foundCustomer.getName());
                        System.out.println("Email: " + foundCustomer.getEmail());
                        System.out.println("Phone: " + foundCustomer.getPhone());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.println("Customer List:");
                    for (Customer c : customers.values()) {
                        System.out.println("Name: " + c.getName());
                        System.out.println("Email: " + c.getEmail());
                        System.out.println("Phone: " + c.getPhone());
                        System.out.println("----------------------");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
