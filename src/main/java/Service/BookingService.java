package Service;

public interface BookingService {
    boolean showExists(int showNumber);
    void displayAvailableSeats(int showNumber);
    boolean bookSeats(int showNumber, String[] seats);
    void displayBookingDetails(int showNumber, String[] seats);
    void displayTotalSales();
}
