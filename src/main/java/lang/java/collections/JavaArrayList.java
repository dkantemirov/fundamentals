package lang.java.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class JavaArrayList {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    for (int element : list)
      System.out.println(element);

    // Using an Iterator
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext())
      System.out.println(iterator.next());
  }
}
