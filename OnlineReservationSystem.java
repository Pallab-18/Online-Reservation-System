import java.util.Scanner;

public class OnlineReservationSystem {

    private static boolean[] seats = new boolean[60]; // initialize an array of 60 seats, all empty
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            // display menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            // get user input
            int option;
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid option! Please enter a valid option number.");
                sc.nextLine(); // consume the invalid input
                continue; // restart the loop
            }

            switch (option) {

                case 1:
                    viewSeatMap();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    //sc.close(); // close the scanner
                    System.exit(0); // exit the program

                default:
                    System.out.println("Invalid option!");
            }
        }

    }

    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); // print an "X" if the seat is reserved
            } else {
                System.out.print((i + 1) + " "); // print the seat number if it's empty
            }
            if ((i + 1) % 10 == 0) {
                System.out.println(); // move to the next line after printing 10 seats
            }
        }
    }

    private static void reserveSeat() {
        System.out.print("\nEnter seat number (1-60): ");
        int seatNumber;
        try {
            seatNumber = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid seat number! Please enter a valid seat number.");
            sc.nextLine(); // consume the invalid input
            return; // return without reserving the seat
        }

        if (seatNumber < 1 || seatNumber > 60) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat reserved!");
        }
    }

    private static void cancelReservation() {
        System.out.print("\nEnter seat number (1-60): ");
        int seatNumber;
        try {
            seatNumber = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid seat number! Please enter a valid seat number.");
            sc.nextLine(); // consume the invalid input
            return; // return without canceling the reservation
        }

        if (seatNumber < 1 || seatNumber > 60) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; // unreserve the seat
            System.out.println("Reservation canceled!");
        }
    }
}
