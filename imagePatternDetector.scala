import math._
import scala.util._
import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

// class to manage debugging and sorting coordinates
class coords(var x: Int, var y: Int){
    def toArray() : Array[Int] = {
             val coordinateArray = new Array[Int](2)
             coordinateArray(0) = this.x
             coordinateArray(1) = this.y
             return coordinateArray
        }
    override def toString() : String  = {
        return "%d,%d".format(this.x, this.y)
    }
}
object Player extends App {
    
    def solve(imageWidth: Int, imageHeight: Int, image: Array[String], patternWidth: Int, patternHeight: Int, pattern: Array[String]): Array[Int] = {
       
        // return coordinates
        var x : Int = -1
        var y : Int = -1
        
        // comparison substrings
        var right : String = ""
        var down : String = ""
        
        // stores all matches
        var coordinates = new ArrayBuffer[coords]()

        // consider each row
        for (i <- 0 to (image.length - 1)){ // row
            
            // consider each starting column where pattern fits width-wise
            for (j <- 0 to (imageWidth - 1 - (patternWidth-1))){

                // if top row is match, continue to examine for whole pattern match
                right = image(i).substring(j, j+patternWidth)
                if(right.equals(pattern(0)) && ((imageHeight - i  - patternHeight) >= 0)){

                    // boolean true if whole pattern matches
                    var matching : Int = 1

                    // consider each row from starting column where pattern fits height-wise
                    for(k <- 0 to (patternHeight - 1))
                    {
                        down = image(i+k).substring(j, j+patternWidth)
                        // if mismatch anywhere in pattern, boolean = false, don't add to coordinates
                        if(!down.equals(pattern(k))){
                            matching = 0;
                        }
                    }

                    // whole pattern match occurred, add to coordinates
                    if (matching == 1){
                        var x : Int = j
                        var y : Int = i
                        val c = new coords(x,y)
                        coordinates += c
                        System.err.println(c.toString)
                    }
                }
            }
        }

        // sort all coordinates by y-coordinate asc
        val sortedByY = coordinates.sortBy(_.y)

        // return coord, initialized such that no matches have occurred
        var first_c = new coords(-1,-1)
        
        // consider all coords
        for(i <- 0 to (sortedByY.length - 1) ){
            if(i == 0)
                first_c = sortedByY(i)
            else{
                // if y-coordinate is equal to best match y-coodinate
                if(sortedByY(i).y == first_c.y)
                {
                    // consider x tie break
                    if(sortedByY(i).x < first_c.x)
                        first_c = sortedByY(i)
                }
                // given sorted by, as soon as larger y occurs, nothing can beat first_c
                else if(sortedByY(i).y != first_c.y)
                    return first_c.toArray
            }
        }
        
        return first_c.toArray
    }
    /* Ignore and do not change the code below */

    val Array(imageWidth, imageHeight) = (readLine split " ").filter(_ != "").map (_.toInt)
    val image = Array.tabulate(imageHeight) { _ => readLine }
    val Array(patternWidth, patternHeight) = (readLine split " ").filter(_ != "").map (_.toInt)
    val pattern = Array.tabulate(patternHeight) { _ => readLine }
    val outStream = System.out
    System.setOut(System.err)
    val coordinates: Array[Int] = solve(imageWidth, imageHeight, image, patternWidth, patternHeight, pattern)
    System.setOut(outStream)
    coordinates.foreach(println)
}