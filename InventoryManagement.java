import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;
import java.util.Scanner;
/* I choose to optimize the code by using hashmap instead of arraylist because it offers faster lookup and retrieval of data.
And it also shortens the code because it eliminates the need for manual indexing and searching through the ArrayList.. */
class InventoryManagement {
    private final Scanner manage;
    private final Inventory storage;
    public InventoryManagement() {
        manage = new Scanner(System.in);
        storage = new Inventory();
    }
    public void startMenu() { // interface
        System.out.println("Welcome to Inventory Management!");
        System.out.println("I'm Rozzelle B. De Omania from BSIT 2-1");
        int option = 0;
        while (option != 4) {
            printMenu();
            option = getUserChoice();
            switch (option) {
                case 1 -> addItem();
                case 2 -> {
                    if (storage.isEmpty()) {
                        System.out.println("\n\tNo items in the inventory! Please Add first");
                    } else {
                        removeItem();
                    }
                }
                case 3 -> {
                    if (storage.isEmpty()) {
                        System.out.println("\n\tNo items in the inventory! Please Add first");
                    } else {
                        checkItemQuantity();
                    }
                }
                case 4 -> System.out.println("Thank you for using Inventory Management. Goodbye!");
                default -> System.out.println("Invalid input. Please try again. Choose options 1-4 only!");
            }
        }
    }
    private void printMenu() { // displays choices
        System.out.println("\nPlease select an action:");
        System.out.println("1. Add item to the inventory");
        System.out.println("2. Remove item from the inventory");
        System.out.println("3. Check quantity of an item in the inventory");
        System.out.println("4. Exit the program");
    }
    private int getUserChoice() {
        int option = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter your option: ");
                option = manage.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1-4.");
                manage.nextLine();
            }
        }
        return option;
    }
    private void addItem() { // prompts the user to enter the number of items they want to add.
        manage.nextLine();
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("\nEnter the number of items you want to add: ");
                int numItems = manage.nextInt();
                validInput = true;
                if (numItems <= 0) {
                    System.out.println("Invalid number of items. Please enter a positive number.");
                    return;
                }
                for (int i = 1; i <= numItems; i++) {
                    manage.nextLine();
                    System.out.print("\nEnter the item name for item " + i + ": ");
                    String name = manage.nextLine().toLowerCase();
                    System.out.print("Enter the item quantity for item " + i + ": ");
                    int quantity;
                    while(true){
                        String input = manage.nextLine();
                        if (input.matches("\\d+")) {
                            quantity = Integer.parseInt(input);
                            if (quantity > 0) {
                                break;
                            }
                        }
                        System.out.println("Invalid input. Enter a valid Quantity!");
                        System.out.print("Enter the item quantity for item " + i + ": ");
                    }
                    storage.addItem(name, quantity);
                    System.out.println("Item added successfully.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                manage.nextLine(); // Clear the input buffer
            }
        }
    }
    private int getItemQuantityInput() { // validates the quantity input from the user.
        int quantity = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                quantity = manage.nextInt();
                if (quantity > 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Enter a valid quantity!");
                    System.out.print("Enter the item quantity: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter the item quantity: ");
                manage.nextLine(); // Clear the input buffer
            }
        }
        return quantity;
    }
    private void removeItem() { // Prompts the user to choose whether to remove the entire item or only its quantity.
        manage.nextLine();
        System.out.print("\nDo you want to remove the item or only its quantity?");
        System.out.println("\nA. Remove the item");
        System.out.println("B. Remove the quantity of the item");
        System.out.print("Enter your choice: ");
        String choice = manage.nextLine().toUpperCase();
        switch (choice) {
            case "A" -> removeItemByName();
            case "B" -> removeItemQuantity();
            default -> System.out.println("Invalid choice. Please choose either A or B.");
        }
    }
    private void removeItemByName() { // checks the remove item
        System.out.print("\nEnter the item name: ");
        String name = manage.nextLine().toLowerCase();
        boolean removed = storage.removeItem(name);
        if (removed) {
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }
    private void removeItemQuantity() { // verifies if the item exists and if the specified quantity is valid
        System.out.print("\nEnter the item name: ");
        String name = manage.nextLine().toLowerCase();
        int currentQuantity = storage.getQuantity(name);
        if (currentQuantity == 0) {
            System.out.println("Item not found.");
            return;
        }
        System.out.print("Enter the quantity to remove: ");
        int quantity = getItemQuantityInput();
        boolean removed = storage.removeQuantityOfItem(name, quantity);
        if (removed) {
            System.out.println("Removed " + quantity + " quantity of the item successfully.");
        } else {
            System.out.println("Error: The entered quantity is greater than the current quantity.");
        }
    }
    private void checkItemQuantity() {
        manage.nextLine();
        System.out.print("\nDo you want to see all items or a specific item?");
        System.out.println("\nA. All items");
        System.out.println("B. Specific item");

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter your choice: ");
            String choice = manage.nextLine().toUpperCase();

            switch (choice) {
                case "A" -> { // displays specific item
                    validInput = true;
                    System.out.println("Items in the inventory:");
                    Map<String, Integer> itemMap = storage.getItemMap();
                    for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
                case "B" -> { // displays specific item
                    validInput = true;
                    System.out.print("\nEnter the item name: ");
                    String name = manage.nextLine().toLowerCase();
                    int quantity = storage.getQuantity(name);
                    if (quantity == 0) {
                        System.out.println("Item is not in the inventory.");
                    } else {
                        System.out.println("Item quantity: " + quantity);
                    }
                }
                default -> System.out.println("\n\tInvalid Input! Please choose either A or B.");
            }
        }
    }
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        inventoryManagement.startMenu();
    }
}
class Inventory {
    private final Map<String, Integer> itemMap;
    public Inventory() {
        itemMap = new HashMap<>();
    }
    public void addItem(String itemName, int itemQuantity) { // Adds the specified item, If the item already exists the quantity is updated
        int currentQuantity = itemMap.getOrDefault(itemName, 0);
        itemMap.put(itemName, currentQuantity + itemQuantity);
    }
    public boolean removeItem(String itemName) { // removes the specified item from the inventory.
        if (itemMap.containsKey(itemName)) {
            itemMap.remove(itemName);
            return true;
        }
        return false;
    }
    public boolean removeQuantityOfItem(String itemName, int quantity) { // removes the specified quantity of an item
        int currentQuantity = itemMap.getOrDefault(itemName, 0);
        if (quantity <= currentQuantity) {
            itemMap.put(itemName, currentQuantity - quantity);
            return true;
        }
        return false;
    }
    public int getQuantity(String itemName) { // retrieves quantity of item
        return itemMap.getOrDefault(itemName, 0);
    }
    public boolean isEmpty() { // return if inventory is empty
        return itemMap.isEmpty();
    }
    public Map<String, Integer> getItemMap() { //return map items in the inventory
        return itemMap;
    }
}