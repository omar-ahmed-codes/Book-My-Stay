import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 3: Centralized Room Inventory Management
 * Book My Stay Hotel Booking System
 * Version 3.0
 */

/* RoomInventory class manages room availability using HashMap */
class RoomInventory {

    private HashMap<String, Integer> inventory;

    /* Constructor initializes the inventory */
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 6);
        inventory.put("Suite Room", 3);
    }

    /* Get availability for a specific room type */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /* Update availability */
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    /* Display entire inventory */
    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
        }
    }
}

/* Main Application */
public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("     Book My Stay - Version 3.0       ");
        System.out.println("   Centralized Inventory Management   ");
        System.out.println("======================================");

        /* Initialize inventory */
        RoomInventory inventory = new RoomInventory();

        /* Display initial inventory */
        inventory.displayInventory();

        /* Example update */
        System.out.println("\nUpdating availability...");
        inventory.updateAvailability("Single Room", 8);

        /* Display updated inventory */
        inventory.displayInventory();

        System.out.println("\nApplication terminated successfully.");
    }
}