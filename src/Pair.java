public class Pair<V, K> {
    Pair(V data, K clue) {
        value = data;
        key = clue;
    }

    public void SetData(V data) {
        value = data;
    }

    public void SetKey(K clue) {
        key = clue;
    }

    public V GetData() {
        return value;
    }

    public K GetKey() {
        return key;
    }

    private V value;
    private K key;
}
