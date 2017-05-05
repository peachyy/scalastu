/*
 * Copyright (C) 2007-2008 Artima, Inc. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Example code from:
 *
 * Programming in Scala (First Edition, Version 6)
 * by Martin Odersky, Lex Spoon, Bill Venners
 *
 * http://booksites.artima.com/programming_in_scala
 */

object Misc {
  object Obj1 {
    implicit def intToString(x: Int) = x.toString
    implicit def int2double(x: Int): Double = x.toDouble

    val aMap =
      Map(1 -> "one", 2 -> "two", 3 -> "three")

    def maxListUpBound[T <: Ordered[T]](elements: List[T]): T = 
      elements match {
        case List() =>
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxListUpBound(rest)
          if (x > maxRest) x
          else maxRest
      }

    def maxList[T](elements: List[T])
          (implicit orderer: T => Ordered[T]): T =
    
      elements match {
        case List() => 
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxList(rest)  // (orderer) is implicit
          if (x > maxRest) x           // orderer(x) is implicit
          else maxRest
      }
  }

  object Obj2 {
    def maxList[T](elements: List[T])
          (implicit converter: T => Ordered[T]): T =
      // same body...
      elements match {
        case List() => 
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxList(rest)  // (orderer) is implicit
          if (x > maxRest) x           // orderer(x) is implicit
          else maxRest
      }
  }

  object Obj3 {
    def maxList[T](elements: List[T])
          (implicit iceCream: T => Ordered[T]): T =
      // same body...
      elements match {
        case List() => 
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxList(rest)  // (orderer) is implicit
          if (x > maxRest) x           // orderer(x) is implicit
          else maxRest
      }
  }

  object Obj4 {
    def maxList[T <% Ordered[T]](elements: List[T]): T =
      elements match {
        case List() => 
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxList(rest)  // (orderer) is implicit
          if (x > maxRest) x           // orderer(x) is implicit
          else maxRest
      }
  }
}
