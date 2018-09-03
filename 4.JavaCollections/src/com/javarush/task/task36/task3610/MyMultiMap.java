package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            size += list.size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        V lastAdded = null;
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            lastAdded = list.get(list.size() - 1);
            if (list.size() < repeatCount) {
                list.add(value);
            } else if (list.size() == repeatCount) {
                list.remove(0);
                list.add(value);
            }
        } else {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
        return lastAdded;
    }

    @Override
    public V remove(Object key) {
        V removedValue = null;
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            if (list == null || list.size() == 0) {
                map.remove(key);
                return null;
            }
            removedValue = list.get(0);
            list.remove(0);
            if (list.size() == 0) map.remove(key);
        }
        return removedValue;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List list = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            list.addAll((List) entry.getValue());
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.contains(value)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}