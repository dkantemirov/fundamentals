package lang.scala

package object functional {
  val numbers: Seq[Int] = 1 to 100
  val evenNumbers: Seq[Int] = 2 to 100 by 2
  val oddNumbers: Seq[Int] = 1 to 100 by 2

  def assertResults(r: Int*): Unit = {
    assert(r.forall(_ == r.head), s"Results: $r")
    println(r.head)
  }
}
