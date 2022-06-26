package Day1.Part1

import scala.io.{BufferedSource, Source}

object Solution {
  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day1/Part1/input.txt"
    val input: BufferedSource = Source.fromFile(filename)
    var previous: Int = -1
    var counter: Int = 0
    for (line <- input.getLines) {
      if (previous > 0)
        if (line.toInt > previous)
          counter += 1
      previous = line.toInt
    }
    input.close()

    println(counter)
  }

}
