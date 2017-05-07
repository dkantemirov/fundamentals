package fundamentals.java.collections;

import java.util.ArrayList;

public class JavaArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i : list) System.out.println(i);
    }
}
