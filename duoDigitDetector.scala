import math._
import scala.util._
import scala.io.StdIn._

object Solution extends App 
{
    
    def isDuoDigit(number: Int): String = 
    {
        // placehold number -> in so it can be reassigned
        var in = number

        // bucket vars, max 2 in duo digit
        var digit_1 = 11
        var digit_2 = 11

        // will hold digit under examination
        var temp : Int = 0
        do {
            // gather least significant digit and chop in by factor of ten
            temp = in % 10
            in /= 10

            // if buckets aren't full assign
            if (digit_1 == 11)
                digit_1 = temp
            else if (digit_2 == 11)
                digit_2 = temp
            else { // at first sign of failure return "f"
                if ( temp != digit_1 &&  temp != digit_2)
                    return "n"
            }
        } while (in != 0)
            // passed test
            return "y"
    }
    /* Ignore and do not change the code below */

    val number = readLine.toInt
    val outStream = System.out
    System.setOut(System.err)
    val result: String = isDuoDigit(number)
    System.setOut(outStream)
    println(result)
}