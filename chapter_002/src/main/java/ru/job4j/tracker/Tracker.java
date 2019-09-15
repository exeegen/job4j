package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод заменяет заявку по ключу.
     *
     * @param id   Уникальный ключ.
     * @param item заявка.
     * @return возращает True при успеха.
     */
    public boolean replace(String id, Item item) {
        boolean success = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                success = true;
            }
        }
        return success;
    }

    /**
     * Метод удаляет заявку по уникальному ключу.
     *
     * @param id уникальный ключ.
     * @return возращает True при успеха.
     */
    public boolean delete(String id) {
        boolean success = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                success = true;
                System.arraycopy(items, i + 1, items, i, position - i - 1);
                items[--position] = null;
            }
        }
        return success;
    }

    /**
     * Метод возвращает копию массива items без null-элементов.
     *
     * @return массив Item.
     */
    public Item[] findAll() {
        Item[] newItems = new Item[position];
        System.arraycopy(items, 0, newItems, 0, position);
        return newItems;
    }

    /**
     * Метотод проверяет в цикле все элементы массива this.items,
     * сравнивая name и копируя их в результирующий массив.
     *
     * @param key имя.
     * @return результирующий массив заявок с одинаковыми именами.
     */
    public Item[] findByName(String key) {

        int index = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                index++;
            }
        }

        Item[] newItems = new Item[index];
        index = 0;

        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                newItems[index++] = items[i];
            }
        }
        return newItems;
    }

    /**
     * Метод ищет заявки по уникальному идентификатору.
     *
     * @param id уникальный идентификатор.
     * @return null или заявка.
     */
    public Item findById(String id) {
        Item item = null;
        for (Item i : items) {
            if (i == null) {
                break;
            } else if (i.getId().equals(id)) {
                item = i;
            }
        }
        return item;
    }

}
