package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListCommandTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void listtesty() {
        MyMap<Integer, Room> rooms = new MyMap<>();
        rooms.put(101, new Room(1, 150));
        rooms.put(102, new Room(2, 200));


        ListCommand.execute(rooms);

        String expectedOutput = "Informacje o wszystkich pokojach:" +
                "Pokój nr 101: Status: Wolny, Numer piętra: 1, Ilość miejsc: 1, Cena za dobę: 150 zł" +
                "Pokój nr 102: Status: Wolny, Numer piętra: 1, Ilość miejsc: 2, Cena za dobę: 200 zł";

        assertEquals(expectedOutput, outputStream.toString().trim().replace(System.lineSeparator(), ""));
    }
}

