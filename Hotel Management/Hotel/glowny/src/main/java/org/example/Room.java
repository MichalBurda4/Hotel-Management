package org.example;
/**
 * Klasa reprezentująca pojedynczy pokój w hotelu.
 */
class Room {
    private String guestName; // nazwa goscia
    private final int capacity; // Liczba miejsc w pokoju
    private final int price;    // Cena pokoju

    /**
     * Konstruktor tworzący obiekt Room.
     *
     * @param capacity Liczba miejsc w pokoju.
     * @param price    Cena za nocleg w pokoju.
     */
    public Room(int capacity, int price) {
        this.guestName = null;
        this.capacity = capacity;
        this.price = price;
    }

    /**
     * Rejestruje gościa w pokoju.
     *
     * @param guestName Nazwa gościa, który zameldowuje się w pokoju.
     */
    public void checkIn(String guestName) {
        this.guestName = guestName;
    }

    /**
     * Wymeldowuje gościa z pokoju.
     */
    public void checkOut() {
        this.guestName = null;
    }
    /**
     * Zwraca nazwę gościa obecnie zajmującego pokój.
     *
     * @return Nazwa gościa lub null, jeśli pokój jest niezajęty.
     */
    public String getGuestName() {
        return guestName;
    }
    /**
     * Sprawdza, czy pokój jest obecnie zajęty.
     *
     * @return true, jeśli pokój jest zajęty, false w przeciwnym razie.
     */
    public boolean isOccupied() {
        return guestName != null;
    }

    /**
     * Zwraca numer piętra, na którym znajduje się pokój.
     *
     * @param roomNumber Numer pokoju.
     * @return Numer piętra.
     */
    public int getFloor(int roomNumber) {
        return roomNumber / 100;
    }

    /**
     * Zwraca pojemność (liczbę miejsc) pokoju.
     *
     * @return Liczba miejsc w pokoju.
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Zwraca cenę za nocleg w pokoju.
     *
     * @return Cena za nocleg.
     */
    public int getPrice() {
        return price;
    }
}