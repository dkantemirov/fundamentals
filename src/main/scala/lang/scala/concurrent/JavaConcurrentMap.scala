package lang.scala.concurrent

import java.util.concurrent._

object JavaConcurrentMap extends App {
  private var map: ConcurrentMap[Int, String] = new ConcurrentHashMap

  def concurrentHashMap(): Unit = {
    val service = Executors.newFixedThreadPool(3)
    service.execute(new WriteThreadOne)
    service.execute(new WriteThreadTwo)
    service.execute(new ReadThread)
    service.shutdownNow()
  }
  def concurrentSkipListMap(): Unit = {
    map = new ConcurrentSkipListMap[Int, String]()
    val service = Executors.newFixedThreadPool(3)
    service.execute(new WriteThreadOne)
    service.execute(new WriteThreadTwo)
    service.execute(new ReadThread)
    service.shutdownNow()
  }
  class WriteThreadOne extends Runnable {
    def run(): Unit = for (i <- 1 to 10) map.putIfAbsent(i, "A" + i)
  }
  class WriteThreadTwo extends Runnable {
    def run(): Unit = {
      for (i <- 1 to 5) map.put(i, "B" + i)
    }
  }
  class ReadThread extends Runnable {
    def run(): Unit = {
      val iterator = map.keySet().iterator()
      while (iterator.hasNext) {
        val key = iterator.next()
        println(s"$key : ${map.get(key)}")
      }
    }
  }

  concurrentHashMap()
  concurrentSkipListMap()
}
