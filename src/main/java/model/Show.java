package model;

import java.util.Set;
import java.util.TreeSet;

public class Show {
    private int showNumber;
    private Set<String> availableSeats;
    private double platinumPrice = 320.0;
    private double goldPrice = 280.0;
    private double silverPrice = 240.0;

    public Show(int showNumber, Set<String> availableSeats) {
        this.showNumber = showNumber;
        this.availableSeats = new TreeSet<>(availableSeats); // Use TreeSet to maintain order
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        displaySeatsByCategory('A', "Platinum");
        displaySeatsByCategory('B', "Gold");
        displaySeatsByCategory('C', "Silver");
    }

    private void displaySeatsByCategory(char category, String categoryName) {
        System.out.print(categoryName + " Seats: ");
        for (String seat : availableSeats) {
            if (seat.charAt(0) == category) {
                System.out.print(seat + " ");
            }
        }
        System.out.println();
    }

    public boolean bookSeats(String[] seats) {
        for (String seat : seats) {
            if (!availableSeats.contains(seat)) {
                System.out.print(seat + " is not available");
                return false;
            }
        }

        for (String seat : seats) {
            availableSeats.remove(seat);
        }

        return true;
    }

    public double calculateSubtotal(String[] seats) {
        double subtotal = 0.0;
        for (String seat : seats) {
            if (seat.charAt(0) == 'A') {
                subtotal += platinumPrice;
            } else if (seat.charAt(0) == 'B') {
                subtotal += goldPrice;
            } else if (seat.charAt(0) == 'C') {
                subtotal += silverPrice;
            }
        }
        return subtotal;
    }
}
