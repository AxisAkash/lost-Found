import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ItemManager {
    private ArrayList<Item> items;
    private int nextId;

    public ItemManager() {
        items = new ArrayList<>();
        nextId = 1; // starting ID
    }

    // Add new item to the list
    public void addItem(String name) {
        Item newItem = new Item(nextId, name);
        items.add(newItem);
        nextId++;
    }

    // Display all items
    public void displayItems() {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println("ID: " + item.getId() + ", Name: " + item.getName());
        }
    }

    // Update item by ID
    public void updateItem(int id, String newName) {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setName(newName);
                System.out.println("Item updated successfully.");
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    // Delete item by ID
    public void deleteItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                System.out.println("Item deleted successfully.");
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        ItemManager itemManager = new ItemManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add item");
            System.out.println("2. Display items");
            System.out.println("3. Update item");
            System.out.println("4. Delete item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    scanner.nextLine(); // Consume the newline character
                    String itemName = scanner.nextLine();
                    itemManager.addItem(itemName);
                    break;
                case 2:
                    itemManager.displayItems();
                    break;
                case 3:
                    System.out.print("Enter item ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    scanner.nextLine(); // Consume the newline character
                    String updatedName = scanner.nextLine();
                    itemManager.updateItem(updateId, updatedName);
                    break;
                case 4:
                    System.out.print("Enter item ID to delete: ");
                    int deleteId = scanner.nextInt();
                    itemManager.deleteItem(deleteId);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
