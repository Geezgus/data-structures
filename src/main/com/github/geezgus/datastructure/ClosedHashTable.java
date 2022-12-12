package com.github.geezgus.datastructure;

@SuppressWarnings("unchecked")
public class ClosedHashTable<T> extends AbstractCollection<T> implements Collection<T> {

    LinkedList<T>[] buckets;

    public ClosedHashTable(int numberOfBuckets) {
        buckets = new LinkedList[numberOfBuckets];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(T item) {
        final int code = item.hashCode();
        return code < 0 ? -code % buckets.length : code % buckets.length;
    }

    public void add(T item) {
        if (buckets[hash(item)].add(item)) {
            size++;
        }
    }

    public void remove(T item) {
        if (buckets[hash(item)].remove(item)) {
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length - 1; i++) {
            sb.append(i).append(": ").append(buckets[i]).append('\n');
        }
        sb.append(buckets.length - 1).append(": ").append(buckets[buckets.length - 1]);

        return sb.toString();
    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    @Override
    public boolean contains(T item) {
        return buckets[hash(item)].contains(item);
    }

}
