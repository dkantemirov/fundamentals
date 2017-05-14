package lang.scala.core

class AccessLevelsForClassMembers {
  /**
   * There is no public keyword in Scala. The default access level (when no modifier is specified)
   * corresponds to Java’s public access level.
   */
  def publicLevel: String = "public"
  private def privateLevel: String = "private"
  protected def protectedLevel: String = "protected"
  private[core] def privateScopeLevel: String = "private"
}

class AccessLevels {
  /**
   * A sealed class may not be directly inherited, except if the inheriting template is defined in
   * the same source file as the inherited class. However, subclasses of a sealed class can inherited
   * anywhere.
   */
  sealed trait SealedA

  class A extends SealedA

  class PublicClass

  private class PrivateClass

  protected class ProtectedClass
}