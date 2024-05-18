package Service.impl;

import Service.BookingService;
import model.Show;
import util.TaxCalculator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookingServiceImpl implements BookingService {
    private Map<Integer, Show> shows;
    private double totalRevenue;
    private double totalServiceTax;
    private double totalSwachhBharatCess;
    private double totalKrishiKalyanCess;

    public BookingServiceImpl() {
        shows = new HashMap<>();
        initializeShows();
    }

    private void initializeShows() {
        shows.put(1, new Show(1, new HashSet<>(Set.of(
                "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9",
                "B1", "B2", "B3", "B4", "B5", "B6",
                "C2", "C3", "C4", "C5", "C6", "C7"
        ))));
        shows.put(2, new Show(2, new HashSet<>(Set.of(
                "A1", "A2", "A3", "A4", "A5", "A6", "A7",
                "B2", "B3", "B4", "B5", "B6",
                "C1", "C2", "C3", "C4", "C5", "C6", "C7"
        ))));
        shows.put(3, new Show(3, new HashSet<>(Set.of(
                "A1", "A2", "A3", "A4", "A5", "A6", "A7",
                "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8",
                "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"
        ))));
    }

    @Override
    public boolean showExists(int showNumber) {
        return shows.containsKey(showNumber);
    }

    @Override
    public void displayAvailableSeats(int showNumber) {
        Show show = shows.get(showNumber);
        if (show != null) {
            show.displayAvailableSeats();
        }
    }

    @Override
    public boolean bookSeats(int showNumber, String[] seats) {
        Show show = shows.get(showNumber);
        return show != null && show.bookSeats(seats);
    }

    @Override
    public void displayBookingDetails(int showNumber, String[] seats) {
        Show show = shows.get(showNumber);
        if (show != null) {
            double subtotal = show.calculateSubtotal(seats);
            double serviceTax = TaxCalculator.calculateServiceTax(subtotal);
            double swachhBharatCess = TaxCalculator.calculateSwachhBharatCess(subtotal);
            double krishiKalyanCess = TaxCalculator.calculateKrishiKalyanCess(subtotal);
            double total = subtotal + serviceTax + swachhBharatCess + krishiKalyanCess;

            System.out.println("Successfully Booked - Show " + showNumber);
            System.out.printf("Subtotal: Rs. %.2f\n", subtotal);
            System.out.printf("Service Tax @14%%: Rs. %.2f\n", serviceTax);
            System.out.printf("Swachh Bharat Cess @0.5%%: Rs. %.2f\n", swachhBharatCess);
            System.out.printf("Krishi Kalyan Cess @0.5%%: Rs. %.2f\n", krishiKalyanCess);
            System.out.printf("Total: Rs. %.2f\n", total);

            addRevenue(subtotal);
            addServiceTax(serviceTax);
            addSwachhBharatCess(swachhBharatCess);
            addKrishiKalyanCess(krishiKalyanCess);
        }
    }

    @Override
    public void displayTotalSales() {
        System.out.printf("Revenue: Rs. %.2f\n", totalRevenue);
        System.out.printf("Service Tax: Rs. %.2f\n", totalServiceTax);
        System.out.printf("Swachh Bharat Cess: Rs. %.2f\n", totalSwachhBharatCess);
        System.out.printf("Krishi Kalyan Cess: Rs. %.2f\n", totalKrishiKalyanCess);
    }

    private void addRevenue(double amount) {
        totalRevenue += amount;
    }

    private void addServiceTax(double amount) {
        totalServiceTax += amount;
    }

    private void addSwachhBharatCess(double amount) {
        totalSwachhBharatCess += amount;
    }

    private void addKrishiKalyanCess(double amount) {
        totalKrishiKalyanCess += amount;
    }
}
