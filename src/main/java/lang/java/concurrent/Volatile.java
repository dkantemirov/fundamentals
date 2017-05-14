package lang.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile provides fast thread-safe lock-free access to a field without synchronization.
 * Volatile solves 3 problems:
 * <ul>
 * <li>Memory visibility.</li>
 * <li>Atomic writes for double and long fields.</li>
 * <li>Forbids instructions reordering.</li>
 * </ul>
 * For every read request for a volatile variable, a thread reads the value from the main memory.
 * For every write request for a volatile variable, a thread writes the value to the main memory.
 * In other words, a thread does not cache the value of a volatile variable in its working memory.
 * Note that using a volatile variable is useful only in a multi-threaded environment for variables
 * that are shared among threads. It is faster and cheaper than using a synchronized block.
 * But it's not enough if you need several operations over a field as one atomic transaction,
 * such as increment.
 */
public class Volatile {

  static class Example {
    private volatile String foo;

    public String getFoo() {
      return foo;
    }

    public void setFoo(String in) {
      this.foo = in;
    }
  }

  /**
   * Because if 2 threads simultaneously read and increment it and save the result then
   * the result of the first increment will be overwritten with the result of the second increment.
   * To prevent this from happening we need to use synchronization.
   */
  static class IncrementProblem {
    // This code is broken
    private volatile int id;

    public void incrementId() {
      id++;
    }
  }

  // Prevent increment problem using synchronization
  static class PreventIncrementProblem {
    private int id;

    public synchronized int nextId() {
      return ++id;
    }
  }

  // Prevent increment problem using java.util.concurrent.atomic package
  static class PreventIncrementProblem2 {
    private AtomicInteger id = new AtomicInteger();

    public int incrementId() {
      return id.incrementAndGet();
    }
  }

}
