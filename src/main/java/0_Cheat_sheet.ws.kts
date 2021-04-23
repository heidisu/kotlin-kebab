// alt + enter to send line or selection to fsi/repl
// Reset fsi by clicking on "Kill Terminal" (the garbage can icon) in the VS Code terminal

// e.g. put cursor on line below and alt + enter
"Hello".length

// expressions evaluate to values. the expression above evaluates to the value 5
// the expression is a function application, and goes like <function> <argument>
// (String.length is the function, "Hello" is the argument)

// define a variable with val <name> = <expression>
val x = 2

val y = x + x

// most nice things are values...

// some values are numbers
2
5 + 3
5 + y

// some values are strings
"Hello"

// some values are booleans
true
false
4 < 7
true && false

// and some values are functions
{ x: Int -> x + x }

// variables can hold functions
val foo = { x: Int -> x + x }

// and functions can be applied to arguments
foo(4);
{ x: Int -> x + x }(4)

// there's a shorthand syntax for defining functions with let
// it goes something kind of like
// let <name> <arg> ... = <expression>
// (foo and foo2 are "the same" function)

val foo2 = { x: Int -> x + x }
foo2.invoke(4)

// multiple arguments via function that returns function
// (bar, bar2 and bar3 are "the same" function)

val bar = { x: Int -> { y: Int -> x + y * 2 } }
val bar2 = { x: Int, y: Int -> x + y * 2 }
fun bar3(x: Int, y: Int) = x + y * 2

bar(5)(6)

fun quux(x: Int): Int {
    val y = x + x
    val z = y * y
    return y + z
}
quux(3)

// we get types for more interesting values by combining the types of less interesting ones

// tuples, or products
// the , (in the expression) can be read as "and"
// the * (in the type) can also be read as "and"
val aTuple = Pair(2, "hello")
val aTriple = Triple(1, "two", 3.0)

fun glorp(x: Pair<Int, String>): String = x.second.repeat(x.first)
glorp(aTuple)

// a shape is a square or a rectangle or a circle
sealed class Shape {
    data class Square(val x: Double) : Shape()
    data class Rectangle(val x: Double, val y: Double) : Shape()
    data class Circle(val r: Double) : Shape()
}

val aShape = Shape.Square(5.0)
val anotherShape = Shape.Rectangle(3.2, 7.0)
val anOtterShape = Shape.Circle(4.7)

// pattern matching on types smart casts value
fun area(shape: Shape): Double =
    when (shape) {
        is Shape.Square -> shape.x * shape.x
        is Shape.Rectangle -> shape.x * shape.y
        is Shape.Circle -> Math.PI * Math.PI * shape.r
    }


area(aShape)
area(anotherShape)
area(anOtterShape)


// *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*
// *~*~*~*~* Other  Things *~*~*~*~*
// *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*

// one other thing is a lists

// making lists
emptyList<Int>()
listOf(1)
listOf(1, 2)

val baz = listOf(3, 1, 5, 0)

// standard lib comes with useful things to do to lists
baz.map { x -> x + x }

listOf(aShape, anotherShape, anOtterShape).map { area(it) }

baz.filter { x -> x > 2 }

listOf(1, 2, 3, 4, 5).fold(0) { res, x -> res + x }
listOf(aShape, anotherShape, anOtterShape).fold(0.0) { res, x -> res + area(x) }
// and stuff...

// also there are other other things. sets, maps, arrays, ...
// those exist. (mostly elsewhere.)
