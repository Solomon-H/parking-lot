package org.parking;
import java.util.Scanner;

public class ParkingLot {
    private boolean[] spots;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        spots = new boolean[capacity];
    }

    public boolean parkCar() {
        for (int i = 0; i < capacity; i++) {
            if (!spots[i]) {
                spots[i] = true;
                System.out.println("Car parked at spot " + (i + 1));
                return true;
            }
        }
        System.out.println("Parking lot is full");
        return false;
    }

    public boolean leaveSpot(int spotNumber) {
        if (spotNumber <= 0 || spotNumber > capacity) {
            System.out.println("Invalid spot number");
            return false;
        }
        if (!spots[spotNumber - 1]) {
            System.out.println("No car parked at spot " + spotNumber);
            return false;
        }
        spots[spotNumber - 1] = false;
        System.out.println("Car left spot " + spotNumber);
        return true;
    }

    public boolean isFull() {
        for (boolean spot : spots) {
            if (!spot) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        for (boolean spot : spots) {
            if (spot) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot(3);

        while (true) {
            System.out.println("Enter command: park / leave / status / exit");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "park":
                    parkingLot.parkCar();
                    break;
                case "leave":
                    System.out.println("Enter spot number to leave:");
                    int spotNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    parkingLot.leaveSpot(spotNumber);
                    break;
                case "status":
                    System.out.println("Is parking lot full? " + parkingLot.isFull());
                    System.out.println("Is parking lot empty? " + parkingLot.isEmpty());
                    break;
                case "exit":
                    System.out.println("Exiting program");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
