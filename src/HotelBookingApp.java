import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 4: Room Search & Availability Check
 * Book My Stay Hotel Booking System
 * Version 4.0
 */

/* Abstract Room Class */
abstract class Room {
    protected String roomType;
    protected int beds;
    protected double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Price per night: $" + price);
    }
}

/* Room Types */
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 100.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 180.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 300.0);
    }
}

/* Centralized Inventory */
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 10);
        inventory.put("Double Room", 6);
        inventory.put("Suite Room", 0); // example unavailable room
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Map<String, Integer> getAllAvailability() {
        return inventory;
    }
}

/* Search Service */
class RoomSearchService {

    public static void searchAvailableRooms(RoomInventory inventory) {

        System.out.println("\nAvailable Rooms:\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        if (inventory.getAvailability("Single Room") > 0) {
            single.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailability("Single Room"));
            System.out.println();
        }

        if (inventory.getAvailability("Double Room") > 0) {
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailability("Double Room"));
            System.out.println();
        }

        if (inventory.getAvailability("Suite Room") > 0) {
            suite.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailability("Suite Room"));
            System.out.println();
        }
    }
}

/* Main Application */
public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("    Book My Stay - Version 4.0       ");
        System.out.println("   Room Search & Availability Check  ");
        System.out.println("=====================================");

        RoomInventory inventory = new RoomInventory();

        // Guest searches available rooms
        RoomSearchService.searchAvailableRooms(inventory);

        System.out.println("Search completed. Inventory unchanged.");
    }
}