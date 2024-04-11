package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyMapTest {
    @Test
    void removeExistingKey() {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.put("one", 1);
        myMap.put("two", 2);

        assertTrue(myMap.remove("one"));
        assertNull(myMap.get("one"));
        assertEquals(1, myMap.size());
    }
    @Test
    void removeNullKey() {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.put("one", 1);

        assertFalse(myMap.remove(null));
        assertEquals(1, myMap.size());
    }
    @Test
    void putNewKey() {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.put("one", 1);

        assertEquals(1, myMap.size());
        assertEquals(1, myMap.get("one"));
    }
    @Test
    void putExistingKey() {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.put("one", 1);

        myMap.put("one", 10);

        assertEquals(1, myMap.size()); // Rozmiar nie powinien się zmienić
        assertEquals(10, myMap.get("one")); // Wartość powinna być zaktualizowana
    }
    @Test
    void sizeOfEmptyMap() {
        MyMap<String, Integer> myMap = new MyMap<>();

        assertEquals(0, myMap.size());
    }

}