package lang.scala.patterns.behavioral

/**
 * Наблюдатель или Publish/subscribe.
 * Определяет зависимость типа «один ко многим» между объектами
 * таким образом, что при изменении состояния одного объекта все
 * зависящие от него оповещаются об этом событии.
 */
object Observer extends App {

  trait Observer[S] {
    def receiveUpdate(subject: S)
  }

  trait Subject[S] {
    this: S =>
    private var observers: List[Observer[S]] = Nil

    def addObserver(observer: Observer[S]): Unit = observers = observer :: observers

    def notifyObservers(): Unit = observers.foreach(_.receiveUpdate(this))
  }

  class Account(initialBalance: Double) {
    private var currentBalance = initialBalance

    def balance: Double = currentBalance

    def deposit(amount: Double): Unit = currentBalance += amount

    def withdraw(amount: Double): Unit = currentBalance -= amount
  }

  class ObservedAccount(initialBalance: Double) extends Account(initialBalance) with Subject[Account] {
    override def deposit(amount: Double): Unit = {
      super.deposit(amount)
      notifyObservers()
    }

    override def withdraw(amount: Double): Unit = {
      super.withdraw(amount)
      notifyObservers()
    }
  }

  class AccountReporter extends Observer[Account] {
    def receiveUpdate(account: Account): Unit =
      println("Observed balance change: " + account.balance)
  }

}
