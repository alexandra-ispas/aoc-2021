package Day1.Part2

import scala.io.{BufferedSource, Source}

object Solution {
  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day1/Part2/input.txt"
    val input: BufferedSource = Source.fromFile(filename)
    var previous: Int = -1
    var counter: Int = 0
    val lines = input.getLines().toArray
    var currentSum: Int = 0
    for (i <- 0 to(lines.length - 3)) {
      currentSum = lines(i).toInt + lines(i + 1).toInt + lines(i + 2).toInt
      if (previous > 0 && currentSum > previous)
          counter += 1
      previous = currentSum
    }

    input.close()

    println(counter)
  }
}
