package com.knoldus.dao.filters

// $COVERAGE-OFF$

final case class Or(left: Filter, right: Filter) extends Filter {

  override def equals(that: Any): Boolean =
    that match {
      case Or(`left`, `right`) | Or(`right`, `left`) => true
      case _ => false
    }

  override def hashCode(): Int = left.hashCode() * right.hashCode()

}
// $COVERAGE-ON$
