import Service.BookingService;
import Service.impl.BookingServiceImpl;


import java.util.Scanner;

/*
For detailed instructions, please refer to the README file.
It contains all the necessary guidelines and information for submitting and working with this project.
 */

public class Start {
    //you may remove the static keyword if required, and please DO NOT CREATE a new object for scanner class
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //your code from here......
        BookingService bookingService = new BookingServiceImpl();
        boolean continueBooking = true;

        while (continueBooking) {
            System.out.print("Enter Show no: ");
            int showNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (bookingService.showExists(showNumber)) {
                bookingService.displayAvailableSeats(showNumber);
                System.out.print("Enter seats: ");
                String seatInput = scanner.nextLine();
                String[] seats = seatInput.split(",\\s*");

                if (bookingService.bookSeats(showNumber, seats)) {
                    bookingService.displayBookingDetails(showNumber, seats);
                } else {
                    System.out.println(",Please select different seats.");
                }

                System.out.print("Would you like to continue (Yes/No): ");
                continueBooking = scanner.nextLine().equalsIgnoreCase("Yes");
            } else {
                System.out.println("Invalid Show Number. Please try again.");
            }
        }

        bookingService.displayTotalSales();
        scanner.close();
    }

}
