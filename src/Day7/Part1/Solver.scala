package Day7.Part1

import scala.collection.mutable
import scala.io.{BufferedSource, Source}
import scala.math.abs

object Solver {
  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day7/Part1/input.txt"
    val input: BufferedSource = Source.fromFile(filename)

    val nrs = input.getLines().toArray
    var positions: Array[Int] = nrs(0).split(',').map(_.toInt)

    var average_pos: Double = positions.sum / positions.length

    var min_fuel = Int.MaxValue

    for (i <- positions.min until (average_pos.toInt + 1)) {
      var p = 0
      for (j <- positions) {
        p += abs(i - j)
      }
      if (p < min_fuel)
        min_fuel = p
    }
    println(min_fuel)
  }
}
