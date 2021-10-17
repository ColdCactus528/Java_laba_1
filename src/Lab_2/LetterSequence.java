package Lab_2;

import Lab_1.ArrayList;
import Lab_1.Map;

public class LetterSequence {
    public LetterSequence() {
    }

    public void put(String s) {
        sequence = s;
        this.pars();
    }

    public String entryString() {
        String entry_str = new String("");
        ArrayList<Integer> value_list = list.getValues();
        ArrayList<String> key_list = list.getKeys();

        for (int i = 0; i < value_list.size(); i++) {
            entry_str += key_list.get(i) + ":" + value_list.get(i).toString() + "     ";
        }

        return entry_str;
    }

    public String stringWithoutRepetition() {
        String str = new String("");
        ArrayList<String> key_list = list.getKeys();

        for (int i = 0; i < key_list.size(); i++) {
            str += key_list.get(i) + " ";
        }

        return str;
    }

    private Map<Integer, String> pars() {
        list = new Map<>();
        String s = sequence.trim().replaceAll("\\s+", " ");
        int first_num = s.indexOf(" ");
        int flag = 0;
        int number = 1;

        if (first_num != -1) {

            while (first_num != -1) {
                String word = s.substring(flag, first_num);

                if (!list.keyContains(word)) {
                    list.put(number, word);
                } else {
                    list.put(list.get(word) + 1, word);
                }

                flag = first_num + 1;
                first_num = s.indexOf(" ", flag);
            }

            String word = s.substring(flag);
            if (!list.keyContains(word)) {
                list.put(number, word);
            } else {
                list.put(list.get(word) + 1, word);
            }
        }

        return list;
    }

    private Map<Integer, String> list;
    private String sequence;
}

