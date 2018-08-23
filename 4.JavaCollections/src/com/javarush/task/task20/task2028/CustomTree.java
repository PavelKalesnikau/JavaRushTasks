package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    int N; // количество элементов

    public CustomTree() {
        this.root = new Entry<>("root");
        N = 0;
    }

    /**
     * добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName),
     * искать место для вставки начинаем слева направо.
     *
     * @param s
     * @return
     */
    @Override
    public boolean add(String s) {
        // поиск элемента для вставки
        Entry<String> entryToInsert = findEntryToInsert();
        if (entryToInsert == null) return false;

        // вставка потомка
        Entry childEntry = new Entry(s);
        childEntry.parent = entryToInsert;
        childEntry.lineNumber = entryToInsert.lineNumber + 1;

        if (entryToInsert.availableToAddLeftChildren) {
            entryToInsert.leftChild = childEntry;
            N++;
            return true;
        } else if (entryToInsert.availableToAddRightChildren) {
            entryToInsert.rightChild = childEntry;
            N++;
            return true;
        } else
            return false;
    }

    private Entry<String> findEntryToInsert() {
        Entry<String> entry;
        LinkedList<Entry<String>> queue = new LinkedList<Entry<String>>();

        if (root == null) return null;

        queue.add(root);

        while (!queue.isEmpty()) {
            entry = queue.poll();

            entry.checkChildren();
            if (entry.isAvailableToAddChildren())
                return entry;

            else {
                if (entry.leftChild != null) queue.add(entry.leftChild);
                if (entry.rightChild != null) queue.add(entry.rightChild);
            }
        }
        if (restore()) return findEntryToInsert();
        return null;
    }

    private boolean restore() {
        LinkedList<Entry<String>> queue = new LinkedList<Entry<String>>();
        boolean restored = false;
        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> node = queue.poll();
            if (node.leftChild == null && node.rightChild == null) {
                node.availableToAddLeftChildren = true;
                node.availableToAddRightChildren = true;
                if (!restored) restored = true;
            }else{
                if (node.leftChild!=null) queue.add(node.leftChild);
                if (node.rightChild!=null) queue.add(node.rightChild);
            }
        }
        return restored;
    }

    /**
     * возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.
     *
     * @param s
     */
    public String getParent(String s) {
        Entry entry = findEntry(s);
        if (entry != null) return entry.parent.elementName;
        else return "null";
    }

    @Override
    public boolean remove(Object o) throws UnsupportedOperationException {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        String name = (String) o;

        Entry entryToDelete = findEntry(name);
        Entry parent = entryToDelete.parent;
        if (parent.leftChild != null && parent.leftChild.equals(entryToDelete)) {
            {
                parent.leftChild = null;
                N -= countNodes(entryToDelete);
            }
        } else if (parent.rightChild != null && parent.rightChild.equals(entryToDelete)) {
            {
                parent.rightChild = null;
                N -= countNodes(entryToDelete);
            }
        } else return false;

        return true;
    }

    private Entry<String> findEntry(String s) {
        LinkedList<Entry<String>> queue;
        queue = new LinkedList<Entry<String>>();

        if (root == null || s.isEmpty()) return null;

        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> entry = queue.poll();

            if (entry.elementName.equalsIgnoreCase(s))
                return entry;
            else {
                if (entry.leftChild != null) queue.add(entry.leftChild);
                if (entry.rightChild != null) queue.add(entry.rightChild);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public String get(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public int countNodes(Entry<String> entry) {
        int count = 1; // number of nodes including nodes of childs
        LinkedList<Entry<String>> queue = new LinkedList<Entry<String>>();
        if (entry.leftChild != null) {
            queue.add(entry.leftChild);
        }
        if (entry.rightChild != null) {
            queue.add(entry.rightChild);
        }
        while (!queue.isEmpty()) {
            count += countNodes(queue.poll());
        }
        return count;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?> entry = (Entry<?>) o;
            return Objects.equals(elementName, entry.elementName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(elementName);
        }

        void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
