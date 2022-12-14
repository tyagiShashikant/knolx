package com.knoldus.utils

import scala.concurrent.Future
import scala.util.{ Failure, Success, Try }

object TryExtensions {

  implicit class TryOps[T](t: Try[T]) {

    def toFuture: Future[T] = Future.fromTry(t)

  }

  implicit class TryObjOps(t: Try.type) {

    /**
      * Analogue of Future.sequence
      */
    def sequence[T](tries: IterableOnce[Try[T]]): Try[List[T]] =
      tries.iterator
        .foldLeft[Try[List[T]]](Success(List.empty[T])) { (soFar, nextTry) =>
          nextTry match {
            case Success(r) => soFar.map(r :: _)
            case Failure(f) => Failure(f)
          }
        }
        .map(_.reverse)
  }

}
