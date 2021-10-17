package Lab_1;

import Lab_1.ArrayList;

public class Map<V,K> {
    public Map() { list = new ArrayList<Pair<V,K>>(); }

    public void put(V value, K key) {
        if (list.size() == 0) {
            list.add(new Pair<>(value, key));
        } else {
            if (!this.keyContains(key)) {
                list.add(new Pair<>(value, key));
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getKey() != null) {
                        if (list.get(i).getKey().equals(key)) {
                            list.set(new Pair<>(value, key), i);
                            break;
                        }
                    } else {
                        if (key == null) {
                            list.set(new Pair<>(value, key), i);
                            break;
                        }
                    }
                }
            }
        }
    }

    public V get(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() != null) {
                if (list.get(i).getKey().equals(key)) {
                    return list.get(i).getData();
                }
            } else {
                if (key == null) {
                    return list.get(i).getData();
                }
            }
        }
        return null;
    }

    public V get(K key, V default_value) {
        def_value = default_value;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() != null) {
                if (list.get(i).getKey().equals(key)) {
                    return list.get(i).getData();
                }
            } else {
                if (key == null) {
                    return list.get(i).getData();
                }
            }
        }
        return default_value;
    }

    public boolean keyContains(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() != null) {
                if (list.get(i).getKey().equals(key)) {
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

    public V remove(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() != null) {
                if (list.get(i).getKey().equals(key)) {
                    V val = list.get(i).getData();
                    list.remove(i);
                    return val;
                }
            } else {
                if (key == null) {
                    V val = list.get(i).getData();
                    list.remove(i);
                    return val;
                }
            }
        }
        return def_value;
    }

    public ArrayList<K> getKeys() {
        ArrayList<K> keyArray = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            keyArray.add(list.get(i).getKey());
        }
        return keyArray;
    }

    public ArrayList<V> getValues() {
        ArrayList<V> valueArray = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            valueArray.add(list.get(i).getData());
        }
        return valueArray;
    }

    public ArrayList<Pair<V,K>> getEntries() {
        ArrayList<Pair<V,K>> entriesArray = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            entriesArray.add(list.get(i));
        }
        return  entriesArray;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private ArrayList<Pair<V,K>> list;
    private V def_value = null;
}
