import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial{
    def main(args: Array[String]){
        
        var i = 0

        while (i <= 10){
            println(i)
            i += 1 
        }

        do {
            println(i)
            i += 1
        } while ( i <= 20)

        for ( i <- 1 to 10)
            println(i)

        var randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        for (i <- 0 until randLetters.length )
            println(randLetters(i))

        val aList = List(1,2,3,4,5)
        for (i <- aList){
            println("List items " + i)
        }

        var evenList = for { i <- 1 to 20
            if (i % 2) == 0
            } yield i

        for (i <- evenList)
            println(i)

        for ( i <- 1 to 5; j <- 6 to 10){
            println("i: " + i)
            println("j: " + j)
        }
            
        def printPrimes(){
            val primeList = List(1,2,3,5,7,11)
            for(i <- primeList){
                // break
                if (i == 11){
                    return
                }
                // continue
                if( i != 1){
                    println(i)
                }
            }
        }
        printPrimes

        var numberGuess = 0
        do {
            print("Guess a number ")
            numberGuess = readLine.toInt

        } while (numberGuess !=  15)

        printf("You guessed the secret number %d\n", 15)

        val name = "jacub"
        val age = 28
        val weight = 175.5

        println(s"Hello $name")
        println(f"I am ${age + 1} and weigh $weight%.2f")

        printf("'%5d'\n", 5)
        printf("'%-5d'\n", 5)

        printf("'%05d'\n", 5)
        printf("'%05f'\n", 3.14)

        printf("'%-5s'\n", "hi")

        var randSent = "I saw a dragon fly by"
        println("3rd index : " + randSent(3))
        println("String length : " + randSent.length())
        println(randSent.concat(" and explode"))

        println("Are strings equal " + "I saw a dragon fly by".equalsIgnoreCase(randSent))
        println("Dragon starts at : " + randSent.indexOf("dragon"))
        
        val randSentArray = randSent.toArray

        for ( v <- randSentArray)
            println(v)

        def funcName (param1:dataType, param2:dataType) : returnType = {
             function body
             return valueToReturn
        }

        def getSum(num1: Int = 1, num2: Int = 1)  : Int = {
            return num1 + num2
        }
        println("5 + 4 = " + getSum(5,4))
        println("5 + 4 = " + getSum(num2 = 5,num1 =4))

        void return, no param
        def sayHi() : Unit = {
            println("Hi how are you")
        }
        sayHi

        // variable num of args
        def getSum (args : Int*) : Int = {
            var sum : Int = 0

            for (num <- args){
                sum +=  num
            }
            sum                 // return not needed
        }
        println("Get Sum " + getSum(1,2,3,4,5,6))

        def factorial(num: BigInt) : BigInt = {
            if( num <= 1)
                1
            else
                num * factorial(num-1)
        }
        println("Factorial of 400 = " + factorial(400))

        val favNums = new Array[Int](20)

        val friends = Array("Bob", "Tom")
        friends(0) = "Sue"
        println(friends(0))

        val friends2 = ArrayBuffer[String]()
        friends2.insert(0, "Phil")
        friends2 += "Mark"
        friends2 ++= Array("Susy", "Paul")

        // DIDN'T WORK!!! friends2.insert(1,"Mike", "Sally", "Sam", "Mary", "Sue")

        friends2.remove(1,2)

        var friend : String = ""

        for(friend <- friends2)
            println(friend)

        for (j <- 0 to (favNums.length - 1 )){
            favNums(j) = j
            println(favNums(j))
        }

        val favNumsTime2 = for(num<- favNums) yield 2 * num
        favNumsTime2.foreach(println)

        var favNumsDiv4 = for(num <- favNums if num % 4 == 0 ) yield num 
        favNumsDiv4.foreach(println)

        var multTable = Array.ofDim[Int](10,10)

        for(i <- 0 to 9){
            for(j <- 0 to 9){
                multTable(i)(j) = i * j
            }
        }
        for(i <- 0 to 9){
            for(j <- 0 to 9){
                printf("%d : %d = %d\n", i, j, multTable(i)(j))
            }
        }
        println("Sum : " + favNums.sum)
        println("Min : " + favNums.min)
        println("Max : " + favNums.max)

        val sortedNums = favNums.sortWith(_>_)

        // NO WORK println(favNums.sortWith(_>_))
        println(List(10, 5, 8, 1, 7).sortWith(_ < _)) // ascending order
        // NO WORK  println(sortedNums.deep.mkString(", "))

        val employees = Map("Manager" -> "Bob Smith", "Secretary" ->  "Sue Brown")

        if(employees.contains("Manager"))
            printf("Manager  : %s\n", employees("Manager"))

        val customers = collection.mutable.Map(100 -> "Paul Smith", 101 -> "Sally Smith")

        printf("Customer 100 : %s\n", customers(100))
        
        customers(100) = "Tom Marks"

        customers(102) = "Megan Swift"

        for((k,v) <- customers)
            printf("%d : %s\n", k, v)

        var tupleMarge = (103,  "Marge Simpson", 10.25)

        printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)

        tupleMarge.productIterator.foreach { i => println(i) }

        println(tupleMarge.toString())
        
        val rover = new Animal
        rover.setName("Rover")
        rover.setSound("Woof")
        println(rover.toString)


        val whiskers = new Animal("Whiskers", "Meow")
        println(s"${whiskers.getName} with id ${whiskers.id} says ${whiskers.sound}")

        val spike = new Dog("Spike", "Woof", "Grrrrr")
        println(spike.toString)

        val fang = new Wolf("Fang")
        fang.moveSpeed = 36.0
        println(fang.move)

        val superman = new Superhero("Superman")
        println(superman.fly)
        println(superman.hitByBullet)
        println(superman.ricochet(2500))

        // alias a function
        val l10 = log10 _

        println(l10(1000))
        
        List(1000.0, 10000.0).map(l10).foreach(println)
        
        List(1,2,3,4,5).map((x : Int) => x * 50).foreach(println)

        List(1,2,3,4,5).filter(_ % 2  == 0).foreach(println)

        def times3(num : Int) = num * 3
        def times4(num : Int) = num * 4

        def multIt( func: (Int) => Double, num : Int) = {
            func(num)
        }

        printf("3 *  100 = %.1f\n", multIt(times3, 100))
        
        val divisorVal = 5

        val divisor5 = (num : Double ) => num / divisorVal

        println("5 / 5 = "  + divisor5(5.0))

        val writer = new PrintWriter("test.txt")
        writer.write("Just some random text\n Some more random text")
        writer.close()

        val textFromFile = Source.fromFile("test.txt", "UTF-8")
        val lineIterator = textFromFile.getLines

        for(line <- lineIterator)
            println(line)

        textFromFile.close()

        def divideNums(num1: Int, num2: Int) = try{
            num1 / num2
        } catch {
            case ex: java.lang.ArithmeticException => "Can't divide by zero"
        } finally {
            // clean up after exception
        }

        println("3/0 = " + divideNums(3,0))


    }

    class Animal(var name : String, var sound: String){
        this.setName(name)
        
        val id = Animal.newIdNum

        def getName() : String = name
        def getSound() : String = sound

        def setName(name  : String){
            if(!(name.matches(".*\\d")))
                this.name = name
            else
                this.name = "No Name"
        }

        def setSound(sound  : String){
            this.sound = name
        }

        def this(name : String){
            this("No Name", "No Sound")
            this.setName(name)
        }

        def this(){
            this("No Name", "No Sound")
        }

        override def toString() : String = {
            return "%s with the id %d says %s".format(this.name, this.id, this.sound)
        }
    }
    
    // static approach in scala
    object Animal {
        private var idNumber  = 0
        private def newIdNum = { idNumber += 1; idNumber }
    }

    class Dog(name: String, sound: String, growl: String) extends Animal(name, sound){
        def this(name: String, sound: String){
            this("No Name", sound, "No Growl")
            this.setName(name)
        }
        
        def this(name: String){
            this("No Name", "No Sound", "No Growl")
            this.setName(name)
        }

         def this(){
            this("No Name", "No Sound", "No Growl")
        }

        override def toString() : String  = {
            return "%s with the id %d says %s or %s".format(this.name, this.id, this.sound, this.growl)
        }
    }

    abstract class Mammal(val name : String){
        var moveSpeed : Double

        def move : String
    }
    
    class Wolf(name: String){
        var moveSpeed = 35.0;

        def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
    }

    trait Flyable {
        def fly : String
    }

    trait BulletProof{
        def hitByBullet : String

        def ricochet(startSpeed : Double) : String = {
            "the bullet ricochets of at a speed of %.1f ft/sec".format(startSpeed * .75)
        }
    }

    class Superhero( val name :String )extends Flyable with BulletProof{
        def fly = "%s flys through the air".format(this.name)


        def hitByBullet = "the bullet bounces off %s".format(this.name)
    }
}