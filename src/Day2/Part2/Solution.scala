package Day2.Part2

import scala.io.{BufferedSource, Source}

object Solution {
  def main(args: Array[String]): Unit = {
    var horizontal: Int = 0
    var depth: Int = 0
    var aim: Int = 0

    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day2/Part2/input.txt"
    val input: BufferedSource = Source.fromFile(filename)

    for (line <- input.getLines) {
      var elems = line.split("\\s+")
      elems(0) match {
        case "forward" => {
          horizontal += elems(1).toInt
          depth += elems(1).toInt * aim
        }
        case "down" => aim += elems(1).toInt
        case "up" => aim -= elems(1).toInt
      }
    }

    println(depth * horizontal)
  }
}
