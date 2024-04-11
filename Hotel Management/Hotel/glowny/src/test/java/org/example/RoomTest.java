package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void checkIn() {
        Room room = new Room(2, 200);
        room.checkIn("Michal Michal");
        assertTrue(room.isOccupied());
        assertEquals("Michal Michal", room.getGuestName());
    }

    @Test
    public void testRoomInitialization() {
        int capacity = 2;
        int price = 100;
        Room room = new Room(capacity, price);

        assertNull(room.getGuestName());
        assertEquals(capacity, room.getCapacity());
        assertEquals(price, room.getPrice());
    }
    @Test
    public void checkOut() {
        Room room = new Room(2, 200);
        room.checkIn("Michal Michal");
        room.checkOut();
        assertFalse(room.isOccupied());
        assertNull(room.getGuestName());
    }

    @Test
    public void getFloor() {
        Room room1 = new Room(2, 200);
        Room room2 = new Room(1, 150);
        assertEquals(1, room1.getFloor(101));
        assertEquals(2, room2.getFloor(202));
    }

    @Test
    public void testGetCapacity() {
        Room room = new Room(3, 250);
        assertEquals(3, room.getCapacity());
    }

    @Test
    public void testGetPrice() {
        Room room = new Room(2, 200);
        assertEquals(200, room.getPrice());
    }

    @Test
    public void isOccupied() {
        Room room1 = new Room(2, 200);
        Room room2 = new Room(1, 150);
        assertFalse(room1.isOccupied());
        assertFalse(room2.isOccupied());

        room1.checkIn("Michal Michl");
        assertTrue(room1.isOccupied());
    }
}