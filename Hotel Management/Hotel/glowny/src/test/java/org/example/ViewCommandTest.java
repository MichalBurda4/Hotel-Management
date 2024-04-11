package org.example;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewCommandTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void viewtest() {
        MyMap<Integer, Room> rooms = new MyMap<>();

        String input = "404\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ViewCommand.execute(rooms, new Scanner(System.in));

        String expectedOutput = "Podaj numer pokoju: Błąd: Nieprawidłowy numer pokoju.";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
}
