
import java.util.*;

// 🔹 CUSTOMER TABLE
class Customer {
    int id;
    String name;
    String password;

    Customer(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

// 🔹 FOOD TABLE
class Food {
    String name;
    String category;
    int price;
    boolean available;

    Food(String name, String category, int price, boolean available) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }
}

// 🔹 ORDER TABLE
class Order {
    List<Food> items = new ArrayList<>();
    int total = 0;

    void addFood(Food f) {
        items.add(f);
        total += f.price;
    }
}

// 🔹 DELIVERY TABLE
class Delivery {
    String status;

    Delivery(String status) {
        this.status = status;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Customer customer = null;

        // 🔹 Available Food List
        List<Food> menu = new ArrayList<>();
        menu.add(new Food("Paneer", "Veg", 200, true));
        menu.add(new Food("Chicken", "Non-Veg", 300, true));
        menu.add(new Food("Juice", "Beverage", 100, true));
        menu.add(new Food("IceCream", "Dessert", 150, false)); // not available

        List<String> history = new ArrayList<>();

        int mainChoice;

        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            mainChoice = sc.nextInt();

            switch (mainChoice) {

                // CREATE ACCOUNT
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Set Password: ");
                    String pass = sc.nextLine();

                    customer = new Customer(id, name, pass);
                    System.out.println("Account Created!");
                    break;

                // LOGIN
                case 2:
                    if (customer == null) {
                        System.out.println("Create account first!");
                        break;
                    }

                    System.out.print("Enter ID: ");
                    int loginId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Password: ");
                    String loginPass = sc.nextLine();

                    if (customer.id != loginId || !customer.password.equals(loginPass)) {
                        System.out.println("Invalid Login!");
                        break;
                    }

                    System.out.println("Login Successful!");

                    // ORDER PROCESS
                    Order order = new Order();
                    int choice;

                    do {
                        System.out.println("\n--- MENU ---");
                        for (int i = 0; i < menu.size(); i++) {
                            Food f = menu.get(i);
                            System.out.println((i + 1) + ". " + f.name + " (" + f.category + ") - " + f.price +
                                    (f.available ? "" : " [Not Available]"));
                        }
                        System.out.println("5. Finish Order");

                        System.out.print("Choose item: ");
                        choice = sc.nextInt();

                        if (choice >= 1 && choice <= 4) {
                            Food selected = menu.get(choice - 1);

                            if (!selected.available) {
                                System.out.println("Item not available!");
                            } else {
                                order.addFood(selected);
                                history.add("Added: " + selected.name);
                                System.out.println("Added!");
                            }
                        }

                    } while (choice != 5);

                    // TOTAL
                    System.out.println("Total Amount: " + order.total);

                    // POLICY CHECK
                    if (order.total > 5000) {
                        System.out.println("Approval Required:");
                        System.out.println("1. Manager Approval");
                        System.out.println("2. Chef Approval");
                    } else {
                        System.out.println("Order Approved!");
                    }

                    // 🔹 DELIVERY
                    Delivery delivery = new Delivery("Dispatched");
                    System.out.println("Delivery Status: " + delivery.status);

                    // 🔹 HISTORY
                    System.out.println("\nTransaction History:");
                    for (String h : history) {
                        System.out.println(h);
                    }

                    break;

                case 3:
                    System.out.println("Exit...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (mainChoice != 3);
    }
}