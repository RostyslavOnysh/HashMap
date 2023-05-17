package HomeWork.jv_hashMap.Solv;


import java.util.Objects;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MULTIPLIER = 2;
    private Node<K, V>[] table;
    private int size;
    private int threshold;


    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
    }

    @Override
    public void put(K key, V value) {
        if (size > threshold) {
            resize();
        }
        int index = getIndex(key);
        Node<K, V> current = table[index];
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }
            if (current.next == null) {
                current.next = new Node<>(key, value, null);
                size++;
                return;
            }
            current = current.next;
        }
        table[index] = new Node<>(key, value, null);
        size++;
    }

    @Override
    public V getValue(K key) {
       Node <K,V> result;
       return (result = getNode(key)) == null ? null : result.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void resize() {
        int newLength = table.length * MULTIPLIER;
        Node<K, V>[] oldArray = table;
        table = new Node[newLength];
        size = 0;
        Node<K, V> current;
        for (Node<K, V> kvNode : oldArray) {
            current = kvNode;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
        threshold = (int) (newLength * DEFAULT_LOAD_FACTOR);
    }

    private Node<K, V> getNode(Object key) {
        int index = getIndex((K) key);
        Node<K, V> result = table[index];
        while (result != null) {
            if (Objects.equals(key, result.key)) {
                return result;
            }
            result = result.next;
        }
        return null;
    }

    private int getIndex(K key) {
        return (key == null) ? 0 : (Math.abs(key.hashCode())) % table.length;
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
