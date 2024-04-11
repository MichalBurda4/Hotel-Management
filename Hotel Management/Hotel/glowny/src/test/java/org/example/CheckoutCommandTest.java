package org.example;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutCommandTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }


    @Test
    void errorCheckouttest() {
        MyMap<Integer, Room> rooms = new MyMap<>();

        String input = "abc\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CheckoutCommand.execute(rooms, new Scanner(System.in));

        String expectedOutput = "Podaj numer pokoju: Nieprawidłowy numer pokoju.";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    void checkouttest() {
        MyMap<Integer, Room> rooms = new MyMap<>();
        rooms.put(202, new Room(2, 150));

        String input = "202\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CheckoutCommand.execute(rooms, new Scanner(System.in));

        String expectedOutput = "Podaj numer pokoju: Pokój jest wolny.";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}
