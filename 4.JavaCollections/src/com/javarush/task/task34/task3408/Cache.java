package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V object = cache.get(key);
        if (object == null) {
            Constructor<V> constr = clazz.getDeclaredConstructor(key.getClass());
            object = constr.newInstance(key);
            cache.put(key, object);
        }
        return object;
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            K key = (K) getKey.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
