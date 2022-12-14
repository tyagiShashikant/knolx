package com.knoldus.dao.filters

@SuppressWarnings(Array("MethodNames"))
case object FalseFilter extends Filter {
  override def and(that: Filter): Filter = this

  override def or(that: Filter): Filter = that

  override def unary_! : Filter = TrueFilter // scalastyle:off disallow.space.before.token
}
