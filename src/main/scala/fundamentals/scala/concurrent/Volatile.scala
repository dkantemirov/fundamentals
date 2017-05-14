package fundamentals.scala.concurrent

import java.util.concurrent.atomic.AtomicInteger

/**
 * Volatile provides fast thread-safe lock-free access to a field without synchronization.
 * Volatile solves 3 problems:
 * - Memory visibility.
 * - Atomic writes for double and long fields.
 * - Forbids instructions reordering.
 * For every read request for a volatile variable, a thread reads the value from the main memory.
 * For every write request for a volatile variable, a thread writes the value to the main memory.
 * In other words, a thread does not cache the value of a volatile variable in its working memory.
 * Note that using a volatile variable is useful only in a multi-threaded environment for variables
 * that are shared among threads. It is faster and cheaper than using a synchronized block.
 * But it's not enough if you need several operations over a field as one atomic transaction,
 * such as increment.
 */
object Volatile {

  class Example(@volatile private var foo: String)

  /**
   * Because if 2 threads simultaneously read and increment it and save the result then
   * the result of the first increment will be overwritten with the result of the second increment.
   * To prevent this from happening we need to use synchronization.
   */
  class IncrementProblem(@volatile private var id: Int) {
    def incrementId(): Unit = id += 1
  }

  // Prevent increment problem using synchronization
  class PreventIncrementProblem(private var id: Int) {
    def nextId: Int = this.synchronized {
      id += 1
      id
    }
  }

  // Prevent increment problem using java.util.concurrent.atomic package
  class PreventIncrementProblem2(id: AtomicInteger = new AtomicInteger()) {
    def incrementId: Int = id.incrementAndGet()
  }

}
