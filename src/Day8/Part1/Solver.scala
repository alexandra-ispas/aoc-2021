package Day8.Part1

import scala.io.{BufferedSource, Source}
import scala.util.{Success, Try}

object Solver {

  private val sizeAndDigitMapping: Map[Int, Int] = Map(
    2 -> 1,
    4 -> 4,
    3 -> 7
  )

  def main(args: Array[String]): Unit = {
    val filename = "/Users/alexandraispas/Desktop/aoc-2021/src/Day8/Part1/input.txt"
    val input: BufferedSource = Source.fromFile(filename)

    input.getLines().foreach(line => {
      val trainingAndInput: Array[String] = line.split('|')
      val training: Array[Int] = trainingAndInput(0).split(' ').map(_.toInt)
      val data: Array[Int] = trainingAndInput(1).split(' ').map(_.toInt)
      val digitsRepresentation: Map[String, Int] = getDigitsRepresentation(training.map(_.toString))
      println(digitsRepresentation)
    })
  }

  private def getDigitsRepresentation(training: Array[String]): Map[String, Int] = {
    var digitsRepresentation: Map[String, Int] = Map()
    training.foreach(digit => {
      Try(sizeAndDigitMapping.get(digit.length)) match {
        case Success(value) => digitsRepresentation += (digit -> value)
        case _ => // do nothing
      }
    })
    digitsRepresentation
  }
}
