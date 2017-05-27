//::: is concatenate
//:: is cons. It's shorter and it has the shorter name.
//:: *prepends* to the list to the right of the double colon


val x = List(1,  2)
val y = List(3, 4)

val thing = x ::: y // concatenate is the longer one

println("thing is " + thing)

val zeroAndX = 0 :: x
println("zero and x" + zeroAndX)  

// list methods that I shouldn't forget
val x = (0 to 10).toList

// evaluate these in a repl
x filter (s => s % 2 == 0)

// checks if condition is true for all elements
x forall (s => s > 7)
x forall (s => s < 70)

x.exists(s => s == 5)


/*---------------------------------------*/
// Tuples
// Elements of tuples are 1-indexed because that's what Haskell and ML do

val tup = ("blah", 1)

//tup map println // doesn't work
for(a <- tup){
  println(a)
}

