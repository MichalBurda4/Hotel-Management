package org.example;

import java.util.List;

public class ListCommand {
    private ListCommand() {

    }

    /**
     * Odpowiada za wykonanie polecenia "list"
     *
     * @param rooms Mapa, która przechowuje pokoje hotelowe
     */
    public static void execute(MyMap<Integer, Room> rooms) {
        List<Integer> roomNumbers = rooms.keys();
        System.out.println("Informacje o wszystkich pokojach:");

        for (Integer roomNumber : roomNumbers) {
            Room room = rooms.get(roomNumber);
            int floor = room.getFloor(roomNumber);
            System.out.println("Pokój nr " + roomNumber + ": " +
                    "Status: " + (room.isOccupied() ? "Zajęty" : "Wolny") + ", " +
                    "Numer piętra: " + floor + ", " +
                    "Ilość miejsc: " + room.getCapacity() + ", " +
                    "Cena za dobę: " + room.getPrice() + " zł");
        }
    }
}

