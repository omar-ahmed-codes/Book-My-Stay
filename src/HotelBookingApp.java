import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5: Booking Request (First-Come-First-Served)
 * Book My Stay Hotel Booking System
 * Version 5.0
 */

/* Reservation class representing a booking request */
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}

/* Booking Request Queue */
class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /* Add booking request to queue */
    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Booking request added for " + reservation.getGuestName());
    }

    /* Display queued requests */
    public void displayRequests() {
        System.out.println("\nCurrent Booking Requests (FIFO Order):");

        if (requestQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return;
        }

        for (Reservation r : requestQueue) {
            r.displayReservation();
        }
    }
}

/* Main Application */
public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("     Book My Stay - Version 5.0           ");
        System.out.println(" Booking Request Queue (First-Come-First) ");
        System.out.println("==========================================");

        BookingRequestQueue queue = new BookingRequestQueue();

        /* Guests submit booking requests */
        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Suite Room"));

        /* Display queued booking requests */
        queue.displayRequests();

        System.out.println("\nRequests stored successfully for future processing.");
    }
}