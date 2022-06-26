package Day3.Part1

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
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day3/Part1/input.txt"
    val input: BufferedSource = Source.fromFile(filename)
    val lines = input.getLines().toArray
    val bits_no = lines(0).toArray.length

    val ones = new Array[Int](bits_no)
    val zeros = new Array[Int](bits_no)

    val gamma = new Array[Int](bits_no)
    val epsilon = new Array[Int](bits_no)

    for (line <- lines) {
      val bits: Array[Char] = line.toArray
      for(i <- 0 until bits_no) {
        if(bits(i) == '0') {
          zeros(i) += 1
        } else if (bits(i) == '1') {
          ones(i) += 1
        }
      }
    }

    for (i <- 0 until bits_no) {
      if(ones(i) > zeros(i)) {
        gamma(i) = 1
      } else {
        epsilon(i) = 1
      }
    }

    println(binary_to_decimal(gamma) * binary_to_decimal(epsilon))
  }
}
