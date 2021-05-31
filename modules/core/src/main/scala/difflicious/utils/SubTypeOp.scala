package difflicious.utils

import scala.annotation.compileTimeOnly

trait SubTypeOp[A] {
  @compileTimeOnly("subClass should only be called in a Differ.configure* path")
  def subType[B <: A]: B = sys.error("subClass should only be called as part of path in Differ.configure*")
}

trait ToSubTypeOp {
  implicit def toSubTypeOp[A](a: A): SubTypeOp[A] = new SubTypeOp[A] {}
}
