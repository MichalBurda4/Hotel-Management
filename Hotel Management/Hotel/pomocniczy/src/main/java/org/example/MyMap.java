//lab4 zad 8
package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Klasa reprezentująca prostą implementację mapy.
 *
 * @param <K> Typ klucza.
 * @param <V> Typ wartości.
 */
class MyMap<K, V>{
    private final List<K> keys = new ArrayList<>();
    private final List<V> values = new ArrayList<>();


    /**
     * Dodanie elementu do mapy pod podanym kluczem.
     * Jeśli podany klucz istnieje, to metoda powinna podmienić wartość.
     *
     * @param key   klucz (nie null)
     * @param value wartość kryjącą się pod kluczem (nie null)
     */
    public void put(K key, V value) {
        if (key != null && value != null) { //sprawdzanie, czy podany klucz istnieje
            int index = keys.indexOf(key); //jeśli istnieje to:
            if (index != -1) {
                values.set(index, value);
            } else {
                keys.add(key);
                values.add(value);
            }
        }
    }

    /**
     * Usunięcie podanego klucza oraz wartości, która jest przechowywana pod tym
     kluczem.
     * @param key klucz do usunięcia
     * @return true, jeśli uda się usunąć klucz, false w przeciwnym przypadku
     */
    public boolean remove(K key) {
        if (key != null) { //jesli klucz nie jest nullem (jeśli klucz istnieje) to:
            int index = keys.indexOf(key);
            if (index != -1) {
                keys.remove(index);
                values.remove(index);
                return true;
            }
        }
        return false;
    }

    /**
     * Zwraca wartość pod podanym kluczem lub null, jeśli nie ma podanego klucza.
     * @param key klucz (nie ull)
     * @return wartość pod kluczem lub null, jeśli nie ma wartości dla podanego klucza
     */
    public V get(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            return values.get(index);
        }
        return null;
    }
    /**
     * Zwraca listę kluczy
     * @return java.util.List lista kluczy
     */
    public List<K> keys() {
        return new ArrayList<>(keys);
    }

    /**
     * Sprawdza, czy podany klucz istnieje w mapie.
     * @param key wartość klucza do sprawdzenia.
     * @return true, jeśli klucz istnieje.
     */
    public boolean contains(K key) {
        return keys.contains(key);
    }

    /**
     * Zwraca liczbę elementów w mapie.
     *
     * @return Liczba elementów w mapie.
     */
    public int size() {
        return keys.size();
    }

    /**
     * Sprawdza, czy mapa jest pusta.
     *
     * @return true, jeśli mapa jest pusta, false w przeciwnym razie.
     */




    public Collection<V> values() {
        return new ArrayList<>(values);
    }
}