package fundamentals.scala.core

trait Identification
class User(val name: String) extends Identification
class SuperUser(name: String) extends User(name)

/**
 * Boilerplate Java analog [[fundamentals.java.core.Variance]].
 *
 * Scala supports variance annotations of type parameters of generic classes,
 * to allow them to be covariant, contravariant, or invariant if no annotations are used.
 */
object Variance extends App {
  object Annotations extends App {
    class Foo[+A] // A covariant class
    class Bar[-A] // A contravariant class
    class Baz[A] // An invariant class
  }

  object Covariance {
    // Covariant type parameter by default impl List[+A]
    def show(list: List[User]): Unit = list.foreach(u => println(u.name))
  }

  object Contravariance {
    // Lower bound
    def show[A >: SuperUser](list: List[A]): Unit = list.foreach(println)
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
