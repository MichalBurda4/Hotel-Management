package org.example;

import java.util.Scanner;

/**
 * Klasa odpowiadająca za wyświetlanie informacji o konkretnym pokoju.
 */
public class ViewCommand {
    private ViewCommand() {

    }

    /**
     * Odpowiada za wykonanie polecenia "checkin"
     *
     * @param rooms   Mapa, która przechowuje pokoje hotelowe
     * @param scanner Odczytanie danych wejściowych
     */
    public static void execute(MyMap<Integer, Room> rooms, Scanner scanner) {
        System.out.print("Podaj numer pokoju: ");
        int roomNumberToView;

        try {
            roomNumberToView = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowy numer pokoju.");
            return;
        }

        Room roomToView = rooms.get(roomNumberToView);
        if (roomToView != null) {
            System.out.println("Informacje o pokoju nr " + roomNumberToView);
            System.out.println("Status: " + (roomToView.isOccupied() ? "Zajęty" : "Wolny"));

            if (roomToView.isOccupied()) {
                System.out.println("Gość: " + roomToView.getGuestName());
            }

            int floor = roomToView.getFloor(roomNumberToView);
            if (floor != -1) {
                System.out.println("Numer piętra: " + floor);
            } else {
                System.out.println("Błąd!");
            }

            System.out.println("Ilość miejsc: " + roomToView.getCapacity());
            System.out.println("Cena: " + roomToView.getPrice() + " zł");
        } else {
            System.out.println("Błąd: Nieprawidłowy numer pokoju.");
        }
    }
}
