package lang.scala.benchmark

import org.scalameter.api._

object RegressionTest extends Bench.OnlineRegressionReport {
  val sizes: Gen[Int] = Gen.range("size")(1000000, 5000000, 2000000)
  val arrays: Gen[Array[Int]] = for (sz <- sizes) yield (0 until sz).toArray

  override def persistor: SerializationPersistor = new SerializationPersistor

  performance of "Array" in {
    measure method "foreach" in {
      using(arrays) config ( //exec.benchRuns -> 50,
      // exec.independentSamples -> 2
      ) in { xs =>
        var sum = 0
        xs.foreach(x => sum += x)
      }
    }
  }
}