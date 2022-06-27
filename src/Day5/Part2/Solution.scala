package Day5.Part2

import scala.collection.mutable
import scala.io.{BufferedSource, Source}
import scala.math.abs

object Solution {
  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day5/Part2/input.txt"
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
      var aux: List[Int] = null
      if(x1(i) == x2(i)) {
        for (y <- Integer.min(y1(i), y2(i)) to Integer.max(y1(i), y2(i))) {
          aux = List(x1(i), y)
          if (hashmap.contains(aux)) {
            hashmap(aux) += 1
          } else {
            hashmap(aux) = 1
          }
        }
      }
      if(y1(i) == y2(i)) {
        for (x <- Integer.min(x1(i), x2(i)) to Integer.max(x1(i), x2(i))) {
          aux = List(x, y1(i))
          if (hashmap.contains(aux)) {
            hashmap(aux) += 1
          } else {
            hashmap(aux) = 1
          }
        }
      }

      if(abs(x1(i) - x2(i)) == abs(y1(i) - y2(i))) {
        var xmin = if (x1(i) <= x2(i)) x1(i) else x2(i)
        var xmax = if (x1(i) > x2(i)) x1(i) else x2(i)
        var y = if (x1(i) <= x2(i)) y1(i) else y2(i)
        var id = 1

        if ((y == y1(i) && y > y2(i)) || y == y2(i) && y > y1(i))
          id = -1

        while(xmin <= xmax) {
          aux = List(xmin, y)
          if (hashmap.contains(aux)) {
            hashmap(aux) += 1
          } else {
            hashmap(aux) = 1
          }
          xmin += 1
          y += id
        }
      }
    }
    println(hashmap.count(x => x._2 >= 2))
  }

}
