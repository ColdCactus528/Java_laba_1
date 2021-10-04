public class Map<V,K> {
    public Map() { list = new ArrayList<Pair<V,K>>(); }

    public void Put(V value, K key) {
        if (list.Size() == 0) {
            list.Add(new Pair<>(value, key));
        } else {
            if (!this.KeyContains(key)) {
                list.Add(new Pair<>(value, key));
            }
        }
    }

    public V Get(K key) {
        for (int i = 0; i < list.Size(); i++) {
            if (list.Get(i).GetKey() != null) {
                if (list.Get(i).GetKey().equals(key)) {
                    return list.Get(i).GetData();
                }
            } else {
                if (key == null) {
                    return list.Get(i).GetData();
                }
            }
        }
        return null;
    }

    public V Get(K key, V default_value) {
        def_value = default_value;
        for (int i = 0; i < list.Size(); i++) {
            if (list.Get(i).GetKey() != null) {
                if (list.Get(i).GetKey().equals(key)) {
                    return list.Get(i).GetData();
                }
            } else {
                if (key == null) {
                    return list.Get(i).GetData();
                }
            }
        }
        return default_value;
    }

    public boolean KeyContains(K key) {
        for (int i = 0; i < list.Size(); i++) {
            if (list.Get(i).GetKey() != null) {
                if (list.Get(i).GetKey().equals(key)) {
                    return true;
                }
            } else {
                if (key == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public V Remove(K key) {
        for (int i = 0; i < list.Size(); i++) {
            if (list.Get(i).GetKey() != null) {
                if (list.Get(i).GetKey().equals(key)) {
                    V val = list.Get(i).GetData();
                    list.Remove(i);
                    return val;
                }
            } else {
                if (key == null) {
                    V val = list.Get(i).GetData();
                    list.Remove(i);
                    return val;
                }
            }
        }
        return def_value;
    }

    public ArrayList<K> GetKeys() {
        ArrayList<K> keyArray = new ArrayList<>();
        for (int i = 0; i < list.Size(); i++) {
            keyArray.Add(list.Get(i).GetKey());
        }
        return keyArray;
    }

    public ArrayList<V> GetValues() {
        ArrayList<V> valueArray = new ArrayList<>();
        for (int i = 0; i < list.Size(); i++) {
            valueArray.Add(list.Get(i).GetData());
        }
        return valueArray;
    }

    public ArrayList<Pair<V,K>> GetEntries() {
        ArrayList<Pair<V,K>> entriesArray = new ArrayList<>();
        for (int i = 0; i < list.Size(); i++) {
            entriesArray.Add(list.Get(i));
        }
        return  entriesArray;
    }

    public int Size() {
        return list.Size();
    }

    public boolean IsEmpty() {
        return list.IsEmpty();
    }

    private ArrayList<Pair<V,K>> list;
    private V def_value = null;
}
