import Lab_2.LetterSequence;
import Lab_2.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание номер 2: слияние списков");
        LinkedList<Integer> list0 = new LinkedList<>();
        list0.add(1);
        list0.add(8/3);
        list0.add(4);
        list0.add(14);

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(3);
        list1.add(15);
        list1.add(16);

        System.out.println("Первый список:");
        for (int i = 0; i < list0.size(); i++) {
            System.out.println(list0.get(i));
        }

        System.out.println("");

        System.out.println("Второй список:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        System.out.println("");

        System.out.println("Слияние списков:");
        LinkedList<Integer> list = LinkedList.merge(list0, list1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("");

        System.out.println("Лабораторная работа номер 2: подсчет токенов в строке, очистка строки от повторения токенов");
        String s = "     pP pp       Pp pp PP pP pp ff PP pp     ";
        System.out.println("Строка на вход в програму -> " + s);
        LetterSequence sequence = new LetterSequence();
        sequence.put(s);
        System.out.println("Подсчет токенов: " + sequence.entryString());
        System.out.println("");
        System.out.println("Очистка строки от повторений: " + sequence.stringWithoutRepetition());

    }

}
