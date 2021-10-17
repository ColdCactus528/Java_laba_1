package Lab_1;

public class Pair<V, K> {
    Pair(V data, K clue) {
        value = data;
        key = clue;
    }

    public void setData(V data) {
        value = data;
    }

    public void setKey(K clue) {
        key = clue;
    }

    public V getData() {
        return value;
    }

    public K getKey() {
        return key;
    }

    private V value;
    private K key;
}
