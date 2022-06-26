package Day3.Part2

import scala.io.{BufferedSource, Source}


object Solution {
  def binary_to_decimal(arr: Array[Int]): Double = {
    var result: Double = 0

    for (i <- arr.indices) {
      result += math.pow(2, arr.length - 1 - i) * arr(i)
    }

    result
  }

  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day3/Part2/input.txt"
    val input: BufferedSource = Source.fromFile(filename)
    var lines = input.getLines().toArray

    var copy = new Array[String](lines.length)
    lines.copyToArray(copy)

    var idx = 0

    while (lines.length > 1 && idx <= lines(0).toArray.length) {
      val ones = lines.filter(x => { val y = x.toArray
        y(idx) == '1'})

      val zeros = lines.filter(x => {
        val y = x.toArray
        y(idx) == '0'
      })

      lines = if (ones.length >= zeros.length) ones else zeros
      idx += 1
    }

    idx = 0
    while (copy.length > 1 && idx <= copy(0).toArray.length) {
      val ones = copy.filter(x => { val y = x.toArray
        y(idx) == '1'})

      val zeros = copy.filter(x => {
        val y = x.toArray
        y(idx) == '0'
      })

      copy = if (ones.length < zeros.length) ones else zeros
      idx += 1
    }

    println(binary_to_decimal(copy(0).toArray.map(_.asDigit)) * binary_to_decimal(lines(0).toArray.map(_.asDigit)))

  }
}
