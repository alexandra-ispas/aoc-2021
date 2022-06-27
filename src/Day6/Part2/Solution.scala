package Day6.Part2

import scala.collection.mutable
import scala.io.{BufferedSource, Source}

object Solution {
  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day6/Part2/input.txt"
    val input: BufferedSource = Source.fromFile(filename)

    val days = input.getLines().toArray
    input.close()

    var values = days(0).split(',').map(_.toInt)
    var hashmap = new mutable.HashMap[Long, Long]

    values.foreach(v => if (hashmap.contains(v)) {
      hashmap(v) += 1
    } else {
      hashmap(v) = 1
    })

    for (day <- 0 until(256)) {
      var aux = new mutable.HashMap[Long, Long]
      for ((days, counter) <- hashmap) {
        if (days == 0) {
          if (aux.contains(6)) {
            aux(6) += counter
          } else {
            aux(6) = counter
          }
          if (aux.contains(8)) {
            aux(8) += counter
          } else {
            aux(8) = counter
          }
        } else {
          if (aux.contains(days - 1)) {
            aux(days - 1) += counter
          } else {
            aux(days - 1) = counter
          }
        }
      }
      hashmap = aux
    }
    println(hashmap.values.toArray.sum)
  }
}
