package org.example;

import java.util.Scanner;

/**
 * Klasa odpowiadająca za zameldowanie się gościa
 */
public class CheckinCommand {
    // Prywatny konstruktor, aby ukryć domyślny konstruktor publiczny
    private CheckinCommand() {
        // Pusta implementacja lub ewentualne inicjalizacje
    }

    /**
     * Odpowiada za wykonanie polecenia "checkin"
     *
     * @param rooms   Mapa, która przechowuje pokoje hotelowe
     * @param scanner Odczytanie danych wejściowych
     */
    public static void execute(MyMap<Integer, Room> rooms, Scanner scanner) {
        System.out.print("Podaj numer pokoju: ");
        int roomNumberToCheckIn;

        try {
            roomNumberToCheckIn = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowy numer pokoju.");
            return;
        }

        Room roomToCheckIn = rooms.get(roomNumberToCheckIn);
        if (roomToCheckIn != null) { // Sprawdza, czy pokój jest dostępny
            if (!roomToCheckIn.isOccupied()) { // Jeśli nikogo nie ma w pokoju to:
                System.out.print("Podaj imię gościa: ");
                String guestName = scanner.nextLine();
                roomToCheckIn.checkIn(guestName);
                System.out.println("Gość " + guestName + " zarejestrowany w pokoju nr " + roomNumberToCheckIn);
            } else {
                System.out.println("Pokój jest już zajęty.");
            }
        } else {
            System.out.println("Nieprawidłowy numer pokoju.");
        }
    }
}
