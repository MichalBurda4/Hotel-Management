package org.example;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckinCommandTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testcheckin() {
        MyMap<Integer, Room> rooms = new MyMap<>();
        rooms.put(202, new Room(2, 100));

        String input = "202\nMichal Michal\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CheckinCommand.execute(rooms, new Scanner(System.in));

        String expectedOutput = "Podaj numer pokoju: Podaj imię gościa: Gość Michal Michal zarejestrowany w pokoju nr 202";
        assertEquals(expectedOutput, outputStream.toString().trim());
        assertEquals("Michal Michal", rooms.get(202).getGuestName());
        assertEquals(true, rooms.get(202).isOccupied());
    }


}


