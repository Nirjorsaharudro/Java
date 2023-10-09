import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

interface Workers {
    void setWorkersName(String name);
    void setWorkersId(int id);
}

interface Pet {
    void setPetId(int id);
    void setPetType(String type);
    void setPrice(String price);
    int getPetId();
}

class Pets implements Workers, Pet {
    private String workersName;
    private int workersId;
    private int petId;
    private String petType;
    private String petPrice;

    @Override
    public void setWorkersName(String name) {
        this.workersName = name;
    }

    @Override
    public void setWorkersId(int id) {
        this.workersId = id;
    }

    @Override
    public void setPetId(int id) {
        this.petId = id;
    }

    @Override
    public void setPetType(String type) {
        this.petType = type;
    }

    @Override
    public void setPrice(String price) {
        this.petPrice = price;
    }

    public String getWorkersName() {
        return workersName;
    }

    public int getWorkersId() {
        return workersId;
    }

    public int getPetId() {
        return petId;
    }

    public String getPetType() {
        return petType;
    }

    public String getPetPrice() {
        return petPrice;
    }

    @Override
    public String toString() {
        return "Worker: " + workersName + ", Worker ID: " + workersId +
               "\nPet: ID " + petId + ", Type: " + petType + ", Price: "+ petPrice;
    }
}

public class PetShopManagementSystem {
    public static void main(String[] args) {
        List<Pets> petsList = new ArrayList<>();
        List<String> inventory = new ArrayList<>();
        int transactionId = 1;
        int income = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPet Shop Management System");
            System.out.println("1. Add Pet");
            System.out.println("2. List Pets");
            System.out.println("3. Edit Pet");
            System.out.println("4. Remove Pet");
            System.out.println("5. Sell Pet");
            System.out.println("6. Add Item to Inventory");
            System.out.println("7. Sell Item");
            System.out.println("8. List Inventory");
            System.out.println("9. Account Balance");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    Pets pet = new Pets();
                    System.out.print("Enter Worker Name: ");
                    pet.setWorkersName(scanner.nextLine());
                    System.out.print("Enter Worker ID: ");
                    pet.setWorkersId(scanner.nextInt());
                    System.out.print("Enter Pet ID: ");
                    pet.setPetId(scanner.nextInt());
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter Pet Type: ");
                    pet.setPetType(scanner.nextLine());
                    System.out.print("Enter Pet Price: ");
                    pet.setPrice(scanner.nextLine());

                    petsList.add(pet);
                    System.out.println("Pet added successfully!");
                    break;

                case 2:
                    if (petsList.isEmpty()) {
                        System.out.println("No pets available.");
                    } else {
                        System.out.println("\nList of Pets:");
                        for (Pets p : petsList) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the ID of the pet to edit: ");
                    int petId = scanner.nextInt();
                    int found = 1;
                    scanner.nextLine();  // Consume the newline character
                 for (Pet pet_new : petsList) {
                    int id = pet_new.getPetId();
                    if (id == petId) {
                    found = 0;
                    System.out.print("Enter new Pet Type (Enter to keep existing): ");
                    String newType = scanner.nextLine();
                    if (!newType.isEmpty()) {
                        pet_new.setPetType(newType);
                    }
                    System.out.print("Enter new Pet Price (Enter to keep existing): ");
                    String newPriceStr = scanner.nextLine();
                    if (!newPriceStr.isEmpty()) {
                        //double newPrice = Double.parseDouble(newPriceStr);
                         pet_new.setPrice(newPriceStr);
                    }
                    System.out.println("Pet information updated.");
                    }
                }
                if(found == 1)
                    System.out.println("Pet not found."); 
                break; 
                case 4:
                     System.out.print("Enter the ID of the pet to Remove: ");
                    int petId_2 = scanner.nextInt();
                    int found2 = 1;
                    scanner.nextLine();  // Consume the newline character
                 for (Pet pet_new : petsList) {
                    if (pet_new.getPetId() == petId_2) {
                        found2 = 0;
                        petsList.remove(pet_new);
                        System.out.println("Pet removed successfully.");
                    }
                 }
                if(found2 == 1)
                    System.out.println("Pet not found."); 
                break;
                case 5:
                    // Selling a pet
                    System.out.print("Enter the ID of the pet to sell: ");
                    int petIdToSell = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    Iterator<Pets> iterator = petsList.iterator();
                    while (iterator.hasNext()) {
                        Pets petToSell = iterator.next();
                        if (petToSell.getPetId() == petIdToSell) {
                            System.out.print("The selling price: ");
                            String sell_price = petToSell.getPetPrice();
                            System.out.println(sell_price);
                            
                            income += Integer.parseInt(sell_price);
                            // Perform the sale and remove the pet from the list
                            iterator.remove();
                            
                            System.out.println("Pet sold successfully for $" + sell_price);
                            break;
                        }
                    }
                    break;
                case 6:
                    // Add Item to Inventory
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    inventory.add(itemName);
                    System.out.println("Item added to inventory.");
                    break;
                case 7:
                    // Sell Item
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        System.out.print("Enter item name to sell: ");
                        String itemToSell = scanner.nextLine();
                        if (inventory.contains(itemToSell)) {
                            System.out.print("Enter Item Price: ");
                            int sel_item = scanner.nextInt();
                            System.out.println(Integer.toString(sel_item));
                            System.out.println("Item sold: " + itemToSell);
                            income += sel_item;
                            // Record the transaction with transactionId, itemToSell, and date/time
                            transactionId++;
                        } else {
                            System.out.println("Item not found in inventory.");
                        }
                    }
                    break;
                case 8:
                    // List Inventory
                    System.out.println("\nInventory:");
                    for (String item : inventory) {
                        System.out.println(item);
                    }
                    break;
                case 9:
                    System.out.print("Current Account Balance is: " + Integer.toString(income));
                    break;
                case 10:
                    System.out.println("Exiting Pet Shop Management System.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
