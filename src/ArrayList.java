public class ArrayList<T> {
    public ArrayList() { size = 0; count = 0;}

    public ArrayList(int quantity) {
        count = 0;
        size = quantity*2;
        array = new Object[size];
    }

    public void Add(T data) {
        if (size >= count+1) {
            array[count] = data;
            count += 1;
        } else {
            Object[] new_array;
           if (size == 0) {
               size = 1;
               new_array = new Object[size * 2];
           } else {
             new_array = new Object[size * 2];
             System.arraycopy(this.array, 0, new_array, 0, this.Size());
           }
           size *= 2;
           array = new_array;
           this.Add(data);
        }
    }

    public void Add(T data, int index) {
        if (index < 0)
            index = 0;
        if (index > count)
            index = count;

        if (size >= count+1) {
            System.arraycopy(this.array, index, this.array, index+1, count-index);
            this.array[index] = data;
            count += 1;
        } else {
            Object[] new_array = new Object[size * 2];
            System.arraycopy(this.array, 0, new_array, 0, index);
            System.arraycopy(this.array, index, new_array, index+1, count-index);
            new_array[index] = data;
            count +=1;
            array = new_array;
        }
    }

    public T Remove(int index) {
        if (index < 0)
            index = 0;
        if (index > count)
            index = count;

        T temp = (T) this.array[index];
        System.arraycopy(this.array, index+1, this.array, index, count-index);
        count -= 1;
        return temp;
    }

    public T Set(T data, int index ) {
        if (index < 0) {
            index = 0;
        } else {
            index = count - 1;
        }
        T temp = (T) array[index];
        array[index] = data;
        return temp;
    }


    public boolean Contain(T data) {
        for (int i = 0; i < count; i++) {
            if (data == (T) array[i]) {
                return true;
            }
        }
        return false;
    }

    public int IndexOf(T data) {
        for (int i = 0; i < count; i++) {
            if (data == (T) array[i]) {
                return i;
            }
        }
        return -1;
    }

    public T Get(int index) {
        if (index >= count) {
            return (T) array[count-1];
        }

        if (index < 0) {
            return (T) array[0];
        }

        return (T) array[index];
    }

    public boolean IsEmpty() {
        if (count >= 1)
            return false;
        return true;
    }

    public int Size() {
        return this.count;
    }



    private int count;
    private int size;
    private Object[] array;

}
