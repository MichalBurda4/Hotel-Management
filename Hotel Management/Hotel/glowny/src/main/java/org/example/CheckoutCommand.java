package org.example;

import java.util.Scanner;

/**
 * Klasa odpowiadająca za wymeldowanie się gościa
 */
public class CheckoutCommand {
    // Prywatny konstruktor, aby ukryć domyślny konstruktor publiczny
    private CheckoutCommand() {

    }

    /**
     * Odpowiada za wykonanie polecenia "checkout"
     *
     * @param rooms   Mapa, która przechowuje pokoje hotelowe
     * @param scanner Odczytanie danych wejściowych
     */
    public static void execute(MyMap<Integer, Room> rooms, Scanner scanner) {
        System.out.print("Podaj numer pokoju: ");
        int roomNumberToCheckOut;

        try {
            roomNumberToCheckOut = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowy numer pokoju.");
            return;
        }

        Room roomToCheckOut = rooms.get(roomNumberToCheckOut);
        if (roomToCheckOut != null) {
            if (roomToCheckOut.isOccupied()) {
                String guestName = roomToCheckOut.getGuestName();
                roomToCheckOut.checkOut();
                System.out.println("Gość " + guestName + " wymeldowany z pokoju nr " + roomNumberToCheckOut);
            } else {
                System.out.println("Pokój jest wolny.");
            }
        } else {
            System.out.println("Nieprawidłowy numer pokoju.");
        }
    }
}
