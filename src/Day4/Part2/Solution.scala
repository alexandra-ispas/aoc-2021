package Day4.Part2

import scala.io.{BufferedSource, Source}

object Solution {

  def check(values: Array[Array[Int]], won: Array[Boolean]): Int = {
    for (idx <- 0 until values.length / 5) {
      if (!won(idx)) {
        for (i <- idx * 5 until (idx + 1) * 5) {
          if (values(i).forall(_ == values(i)(0))) {
            return idx
          }
        }

        for (j <- 0 until 5) {
          if (values(idx * 5)(j) == values(idx * 5 + 1)(j) &&
            values(idx * 5 + 1)(j) == values(idx * 5 + 2)(j) &&
            values(idx * 5 + 2)(j) == values(idx * 5 + 3)(j) &&
            values(idx * 5 + 3)(j) == values(idx * 5 + 4)(j)) {
            return idx
          }
        }
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day4/Part2/input.txt"
    val input: BufferedSource = Source.fromFile(filename)
    var lines = input.getLines().toArray

    /* remove empty lines */
    lines = lines.filter(x => x.nonEmpty)

    /* format input as matrices */
    val values: Array[Array[Int]] = new Array[Array[Int]](lines.length - 1)
    for (i <- 1 until lines.length) {
      values(i - 1) = new Array[Int](5)
      values(i - 1) = lines(i).split("\\s+").filter(x => x.nonEmpty).map(_.toInt)
    }
    val won: Array[Boolean] = new Array[Boolean](values.length / 5)

    for (nr <- lines(0).split(",").map(_.toInt)) {
      for (i <- values.indices) {
       values(i) = values(i).map(x => {
         if (x == nr) -1 else x
       })
      }

      var rez: Int = check(values, won)


      println("rez = " + rez)

      while (rez != -1) {
        won(rez) = true
        rez *= 5
        var sum: Int = 0
        values(rez).filter(x => x >= 0).foreach(sum += _)
        values(rez + 1).filter(x => x >= 0).foreach(sum += _)
        values(rez + 2).filter(x => x >= 0).foreach(sum += _)
        values(rez + 3).filter(x => x >= 0).foreach(sum += _)
        values(rez + 4).filter(x => x >= 0).foreach(sum += _)
        println(sum * nr)
        rez = check(values, won)
      }
      println("")
    }
  }
}
