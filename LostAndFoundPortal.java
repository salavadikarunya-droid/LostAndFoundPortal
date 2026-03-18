import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    String description;
    String type; // Lost or Found
    String contact;

    Item(String name, String description, String type, String contact) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.contact = contact;
    }

    void display() {
        System.out.println("\nType: " + type);
        System.out.println("Item Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Contact: " + contact);
        System.out.println("---------------------------");
    }
}

public class LostAndFoundPortal {

    static ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Lost and Found Portal =====");
            System.out.println("1. Report Lost Item");
            System.out.println("2. Report Found Item");
            System.out.println("3. View All Items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addItem(sc, "Lost");
                    break;

                case 2:
                    addItem(sc, "Found");
                    break;

                case 3:
                    viewItems();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    static void addItem(Scanner sc, String type) {
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        System.out.print("Enter Contact Info: ");
        String contact = sc.nextLine();

        items.add(new Item(name, desc, type, contact));
        System.out.println(type + " item added successfully!");
    }

    static void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("\n===== All Items =====");
        for (Item item : items) {
            item.display();
        }
    }
}