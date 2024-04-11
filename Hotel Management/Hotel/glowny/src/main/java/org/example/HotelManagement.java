package org.example;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * Klasa zarządzająca hotelem.
 */
//test1
public class HotelManagement {
    /** Mapa zawierające hotelowe pokoje. */
    private static final MyMap<Integer, Room> rooms = new MyMap<>();
    /** Odczyt danych wejściowych*/
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();

        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("exit")) {
                isRunning = false;
            } else {
                executeCommand(command);
            }
        }

    }
    /** Ścieżka do pliku XLSX, który zawiera informacje o pokojach hotelowych. */
    private static final String FILE_PATH = "hotel1.xlsx";
    /**
     * Odczyt danych z pliku .xlsx.
     */
    static void initializeRooms() {
        try (InputStream fileInputStream = Files.newInputStream(Paths.get(FILE_PATH)); //metoda get z klasy Paths pobiera ścieżkę do pliku FILE_PATH
             Workbook workbook = new XSSFWorkbook(fileInputStream)) { //tworzenie obiektu kasy Workbook

            Sheet sheet = workbook.getSheetAt(0); //pobieramy pierwszy arkusz z obiektu Workbook

            for (Row row : sheet) {
                Cell roomNumberCell = row.getCell(0); //pobieranie komórki o indeksie 0
                Cell capacityCell = row.getCell(1); //pobieranie komórki o indeksie 1
                Cell priceCell = row.getCell(2); //pobieranie komórki o indeksie 2

                if (roomNumberCell != null && capacityCell != null && priceCell != null) { //sprawdza, czy komórki są niepuste
                    int roomNumber = (int) roomNumberCell.getNumericCellValue();
                    int capacity = (int) capacityCell.getNumericCellValue();
                    int price = (int) priceCell.getNumericCellValue();

                    rooms.put(roomNumber, new Room(capacity, price)); //dodanie pokoju do mapy
                }
            }

        } catch (IOException e) {
            System.err.println("Błąd");
        }

    }

    /**
     * Wyświetlanie komend.
     */
    private static void printMenu() {
        System.out.println("Witam w systemie zarządzającym hotelem!");
        System.out.println("Podaj komendę :)");
        System.out.println("Dostępne komendy:");
        System.out.println("lista - wyświetla wszystkie informacje o pokojach");
        System.out.println("list - listuje wszystkie pokoje");
        System.out.println("view - wyświetla informacje o pokoju");
        System.out.println("checkin - dokonuje rejestracji gościa");
        System.out.println("checkout - wymeldowuje gościa");
        System.out.println("save - zapisuje stan do pliku CSV lub XLSX");
        System.out.println("exit - wyjście z programu");

        System.out.print("Podaj komendę: ");
    }

    /**
     * Wykonywanie komend.
     */
    static void executeCommand(String command) {
        switch (command) {
            case "lista":
                ListaCommand.execute(rooms);
                break;
            case "list":
                ListCommand.execute(rooms);
                break;
            case "view":
                ViewCommand.execute(rooms, scanner);
                break;
            case "checkin":
                CheckinCommand.execute(rooms, scanner);
                break;
            case "checkout":
                CheckoutCommand.execute(rooms, scanner);
                break;
            case "save":
                SaveCommand.execute();
                break;
            case "exit":
                System.out.println("Dziękujemy za korzystanie z programu!");
                scanner.close();
                System.exit(0);
                return;
            default:
                System.out.println("Błąd: Nieprawidłowa komenda.");
        }
    }



}


