package Day5.Part1

import scala.collection.mutable
import scala.io.{BufferedSource, Source}

object Solution {
  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day5/Part1/input.txt"
    val input: BufferedSource = Source.fromFile(filename)
    var lines = input.getLines().toArray

    var x1: Array[Int] = new Array[Int](lines.length)
    var y1: Array[Int] = new Array[Int](lines.length)

    var x2: Array[Int] = new Array[Int](lines.length)
    var y2: Array[Int] = new Array[Int](lines.length)

    for (line <- lines) {
      val numbers = line.split(" -> ").map(x => x.split(',').map(_.toInt))
      x1(lines.indexOf(line)) = numbers(0)(0)
      y1(lines.indexOf(line)) = numbers(0)(1)

      x2(lines.indexOf(line)) = numbers(1)(0)
      y2(lines.indexOf(line)) = numbers(1)(1)
    }

    var hashmap = new mutable.HashMap[List[Int], Int]()

    for (i <- x1.indices) {
      if(x1(i) == x2(i)) {
        for (y <- Integer.min(y1(i), y2(i)) to Integer.max(y1(i), y2(i))) {
          var aux = List(x1(i), y)
          if (hashmap.contains(aux)) {
            hashmap(aux) += 1
          } else {
            hashmap(aux) = 1
          }
        }
      }
      if(y1(i) == y2(i)) {
        for (x <- Integer.min(x1(i), x2(i)) to Integer.max(x1(i), x2(i))) {
          var aux = List(x, y1(i))
          if (hashmap.contains(aux)) {
            hashmap(aux) += 1
          } else {
            hashmap(aux) = 1
          }
        }
      }
    }
    println(hashmap.count(x => x._2 >= 2))
  }

}
