package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap map;

    @Override
    public boolean add(Object e) {

        if (map.put(e, PRESENT) == null) return true;
        else return false;
    }

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.max(16, Math.ceil(collection.size() / .75f));
        this.map = new HashMap(capacity);
        this.addAll(collection);
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object e) {
        return map.containsKey(e);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        AmigoSet copy;
        try {
            copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError(e);
        }
        return copy;
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return true;
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out)  {

        try {
            out.defaultWriteObject();
            int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
            float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
            out.writeInt(capacity); // serialize capacity
            out.writeFloat(loadFactor); //  serialize loadFactor

// write Set
            out.writeInt(this.size());
            AmigoSet cloneSet = (AmigoSet) this.clone();
            Iterator iterator = cloneSet.iterator();
            while (iterator.hasNext()){
                Object object = iterator.next();
                out.writeObject(object);
                iterator.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in) {
        try {
            in.defaultReadObject();
            int capacity = (int) in.readInt();
            float loadFactor = (float) in.readFloat();
            this.map = new HashMap(capacity, loadFactor);
// read Set
            int size = in.readInt();
            for (int i = 0; i < size; i++) {
                Object object = in.readObject();
                this.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AmigoSet<?> amigoSet = (AmigoSet<?>) o;
        return Objects.equals(map, amigoSet.map);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), map);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 1. Create file
        File file = File.createTempFile("solution", ".dat");
// 2. Serialization of object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ArrayList arrayList = new ArrayList();
        arrayList.add("Hello");
        arrayList.add(", ");
        arrayList.add("readers");
        arrayList.add("!");
        AmigoSet before_amigoSet = new AmigoSet<>(arrayList);
        int size = before_amigoSet.size();
        oos.writeObject(before_amigoSet);
        oos.close();
// 3. De-serialization of object
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        AmigoSet after_amigoSet = (AmigoSet) ois.readObject();
        int size_after = after_amigoSet.size();
        ois.close();
// 4. Comparing objects (their strings)
        System.out.println(before_amigoSet.equals(after_amigoSet));
    }
}
