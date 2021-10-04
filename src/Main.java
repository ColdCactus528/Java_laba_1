public class Main {
    public static void main(String[] args) {
       Map<Integer,Integer> map = new Map ();
       map.Put(4, 0);
       map.Put(5, 1);
       map.Put(11, 2);
//       System.out.println(map.Get(1));
       for (int i = 0; i < map.Size(); i++) {
           System.out.println(map.Get(i));
       }

       ArrayList<Pair<Integer,Integer>> keyArray = map.GetEntries();
        for (int i = 0; i < keyArray.Size(); i++) {
            System.out.println(keyArray.Get(i).GetKey() + ": " + keyArray.Get(i).GetData());
        }

    }

}
