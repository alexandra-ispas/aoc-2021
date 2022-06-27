package Day6.Part1

import scala.io.{BufferedSource, Source}

object Solution {
  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day6/Part1/input.txt"
    val input: BufferedSource = Source.fromFile(filename)

    val days = input.getLines().toArray
    input.close()

    var values = days(0).split(',').map(_.toInt)

    var day = 0
    while (day < 80) {
      values = values.map(x => x - 1)
      var nr = 0
      values = values.map(x => if (x == -1) {
        nr += 1
        6
      } else x)

      while (nr > 0) {
        values = values :+ 8
        nr -=1
      }
      day += 1
    }
    println(values.length)
  }
}
