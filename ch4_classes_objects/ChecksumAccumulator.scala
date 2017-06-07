import scala.collection.mutable

/*
 * A singleton object has one and only one instance.
 *
 * A singleton object definition looks like a class def
 * except that it uses the word 'object' instead of 'class'.
 *
 * When a singleton object shares the same name as a class,
 * it's that class' "companion object".
 * The class is that object's "companion class".
 *
 * A class and its companion object can
 * access each other's private members. (Heh.)
 *
 */

// there will only ever be one of these
object ChecksumAccumulator {
  
  // just for the sake of having a private val
  // Make a map where the keys are Strings and the values are Ints
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    
    // check if the string is already in the Map
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator

      // for every char in the string
      for (c <- s)
        acc.add(c.toByte)

      val cs = acc.checksum()

      // Add a key-value pair to this mutable Map:
      // eg cache += ("new string key" -> 12345)
      cache += (s -> cs)

      // make sure that the return value is the Int as required
      cs 
    }
  }
}

class ChecksumAccumulator {

  // can't access private things using foo.thingName
  private var sum = 0

  // this is a method with side-effects.
  // a function evaluated only for its side-effects is known as a procedure
  def add(b: Byte): Unit = { sum += b}

  /* This seems to be some Java fun.
  ** ~ is the bitwise NOT operator when applied to ints
  ** There's something going on with signed and unsigned types.
  ** sum & 0xFF does the following:
  **  1) sum is promoted to int (ff ff ff fe)
  **  2) 0xFF is an int literal (00 00 00 fe)
  **  3) & is applied
  */
  def checksum(): Int = ~(sum & 0xFF) + 1
}


