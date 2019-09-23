package ru.job4j.tracker;

public class SinglTrackerEager {
    private static final Tracker tracker = new Tracker();
    private static final SinglTrackerEager INSTANCE = new SinglTrackerEager();

    public static SinglTrackerEager getInstance(){
        return INSTANCE;
    }

    public Item add(Item item) {
        return this.tracker.add(item);
    }

    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }

    public Item[] findByName(String key) {
        return this.tracker.findByName(key);
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }
}
