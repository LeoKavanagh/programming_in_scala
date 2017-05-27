import scala.io.Source

def widthOfLength(s: String): Int = {
  s.length.toString.length
}

if (args.length > 0) {

  // use toList because otherwise you get an iterator
  // that you can only pass over once
  val lines = Source.fromFile(args(0)).getLines().toList

  // find the longest line in a functional way
  // reduceLeft just takes a function as its only argument
  val longestLine = lines.reduceLeft(
    (a, b) => if (a.length > b.length) a else b
  )

  // how wide the margin has to be for character count
  val maxWidth = widthOfLength(longestLine)

  for(line <- lines){
    
    val numSpaces = maxWidth -  widthOfLength(line)
    val padding = " " * numSpaces

    println(padding + line.length + " | " + line)

  }
}
else
  Console.err.println("Please enter filename")


