package lang.java.concurrent;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * <b>Java ConcurrentHashMap Internal Working</b>
 *
 * <p>Concurrency for retrieval: Retrieval of elements from ConcurrentHashMap does not use locking.
 * It may overlap with update operation. We get the elements of last successfully completed
 * update operation. In case of aggregate operations such as putAll and clear(), concurrent
 * retrieval may show insertion or removal of only some elements.
 * </p>
 *
 * <p>Iteration of ConcurrentHashMap: Iterators and Enumerations also return the elements which
 * have been concurrently added while iterating. ConcurrentHashMap does not throw
 * ConcurrentModificationException.</p>
 *
 * <p>Concurrency for updates: Concurrent updates are thread safe. ConcurrentHashMap constructor
 * has an optional concurrency level argument. The default value is 16. This is the estimated number
 * of concurrently updating threads. It is used in internal sizing to accommodate concurrently updating
 * threads. Hash table is internally partitioned into the concurrency level number so that it can avoid
 * updating concurrent thread contention.</p>
 */
public class JavaConcurrentMap {
  private volatile static ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();

  private static void concurrentHashMap() {
    //ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
    ExecutorService service = Executors.newFixedThreadPool(3);
    service.execute(new WriteThreadOne());
    service.execute(new WriteThreadTwo());
    service.execute(new ReadThread());
    service.shutdownNow();
  }

  /**
   * <p>A scalable concurrent ConcurrentNavigableMap implementation. The map is sorted according to
   * the natural ordering of its keys, or by a Comparator provided at map creation time, depending
   * on which constructor is used.</p>
   *
   * <p>ConcurrentHashMap does not guarantee* the runtime of its operations as part of its contract.
   * It also allows tuning for certain load factors (roughly, the number of threads concurrently
   * modifying it).</p>
   *
   * <p>ConcurrentSkipListMap, on the other hand, guarantees average O(log(n)) performance on a wide
   * variety of operations. It also does not support tuning for concurrency's sake.
   * ConcurrentSkipListMap also has a number of operations that ConcurrentHashMap doesn't:
   * ceilingEntry/Key, floorEntry/Key, etc. It also maintains a sort order, which would otherwise
   * have to be calculated (at notable expense) if you were using a ConcurrentHashMap.</p>
   *
   * <p>Basically, different implementations are provided for different use cases. If you need quick
   * single key/value pair addition and quick single key lookup, use the HashMap. If you need faster
   * in-order traversal, and can afford the extra cost for insertion, use the SkipListMap.</p>
   */
  private static void concurrentSkipListMap() {
    map = new ConcurrentSkipListMap<>(Collections.reverseOrder());
    ExecutorService service = Executors.newFixedThreadPool(3);
    service.execute(new WriteThreadOne());
    service.execute(new WriteThreadTwo());
    service.execute(new ReadThread());
    service.shutdownNow();
  }

  public static void main(String[] args) {
    concurrentHashMap();
    concurrentSkipListMap();
  }

  static class WriteThreadOne implements Runnable {

    @Override
    public void run() {
      for (int i = 1; i <= 10; i++)
        map.putIfAbsent(i, "A" + i);
    }
  }
  static class WriteThreadTwo implements Runnable {
    @Override
    public void run() {
      for (int i = 1; i <= 5; i++)
        map.put(i, "B" + i);
    }
  }
  static class ReadThread implements Runnable {
    @Override
    public void run() {
      Iterator<Integer> iterator = map.keySet().iterator();
      while (iterator.hasNext()) {
        Integer key = iterator.next();
        System.out.println(key + " : " + map.get(key));
      }
    }
  }
}
