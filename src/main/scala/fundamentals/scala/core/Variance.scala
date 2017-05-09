package fundamentals.scala.core

trait Identification
class User(val name: String) extends Identification
class SuperUser(name: String) extends User(name)

/**
  * Boilerplate Java analog [[fundamentals.java.core.Variance]].
  */
object Variance extends App {
  object Covariance {
    // Covariant type parameter by default impl List[+A]
    def show(list: List[User]): Unit = list.foreach(u => println(u.name))
  }

  object Contravariance {
    // Lower bound
    def show[T >: SuperUser](list: List[T]): Unit = list.foreach(println)
  }

  object Invariance {
    // We can rewrite default impl List[+A] to List[A]
  }

  val u = new User("user")
  val su = new SuperUser("su")
  val list = List(u)
  val list1 = List(su)

  // Covariance
  Covariance.show(list)

  // Contravariance
  Contravariance.show(list1)

  // Invariance
}
