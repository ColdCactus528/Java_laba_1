package Lab_2;

import org.jetbrains.annotations.NotNull;

public class LinkedList<T> {
    private class Node {
        public T data;
        public Node next;
        public Node prev;
    }

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node temp = new Node();
        temp.data = data;
        temp.prev = tail;

        if (this.tail == null) {
            this.head = temp;
        } else {
            this.tail.next = temp;
        }

        this.tail = temp;
        size += 1;
    }

    public T get(int number) {
        if (number > size)
            number = size;
        if (number < 0)
            number = 0;

        Node temp = head;
        for (int i = 0; i < number; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    public int size() {
        return  size;
    }

    public static <T extends Comparable<T>> @NotNull LinkedList<T> merge(@NotNull LinkedList<T> list_0, LinkedList<T> list_1) {
        LinkedList<T> new_list = new LinkedList<>();
        int i = 0;
        int j = 0;

        while (i < list_0.size() && j < list_1.size()) {
            T get_i = list_0.get(i);
            T get_j = list_1.get(j);

            if (get_i.compareTo(get_j) < 0) {
                new_list.add(get_i);
                i += 1;
            } else {
                new_list.add(get_j);
                j += 1;
            }
        }

        if (list_0.size() > list_1.size()) {
            for (; i < list_0.size(); i++)
                new_list.add(list_0.get(i));
        } else {
            for (; j < list_1.size(); j++)
                new_list.add(list_1.get(j));
        }

        return new_list;
    }

    private int size;
    private Node head;
    private Node tail;
}
