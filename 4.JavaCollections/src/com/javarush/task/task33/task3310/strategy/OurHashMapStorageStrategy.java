package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int treshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    private int hash(Long k) {
        return k.hashCode();
    }

    private int indexFor(int hash, int length) {
        return 0;
    }

    private Entry getEntry(Long key) {
        for (int i = 0; i < table.length; i++) {
            if (key == table[i].key) return table[i];
        }
        return null;
    }

    private void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCap = (oldTable == null) ? 0 : oldTable.length;
        Entry[] newTable = new Entry[newCapacity];
        for (int i = 0; i < oldCap; i++) {
            Entry e;
            newTable[i] = oldTable[i];
        }
        table = newTable;

    }

    private void transfer(Entry[] newTable) {

    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {

    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {

    }

    @Override
    public boolean containsKey(Long key) {
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        return false;
    }

    @Override
    public void put(Long key, String value) {

    }

    @Override
    public Long getKey(String value) {
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null;
    }
}
