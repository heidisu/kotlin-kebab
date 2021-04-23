// (boilerplatey)
fun <T> wat(): T {
    throw NotImplementedError()
}

sealed class Number {
    object Zero : Number()
    data class OneMoreThan(val number: Number) : Number()
}

val zero = Number.Zero
val one = Number.OneMoreThan(Number.Zero)
val two = Number.OneMoreThan(one)

// make five with Zero and OneMoreThan
// let five =
// what is the type of five?

// What is the difference between Zero and 0
0 // what is the type of 0?

//Are there more nums than bools?
//Are there more nums than positive ints?

// functions from recursive types tend to be recursive
fun plus(a: Number, b: Number): Number =
    when (a) {
        is Number.Zero -> b
        is Number.OneMoreThan -> Number.OneMoreThan(plus(a.number, b))
    }

plus(two, two)


// replace wat() with stuff to make a multiplication-function
fun mult(a: Number, b: Number): Number =
    when (a) {
        is Number.Zero -> wat()
        is Number.OneMoreThan -> wat()
    }
mult(plus(two, two), two)

// Extra bonus difficult things:
//
// What is the same in the definition of plus and mult?
// What is different?
// Can we make a function with the samey parts in it?
fun foldNumber(z: Number, omt: (Number) -> Number, n: Number): Number =
    when (n) {
        is Number.Zero -> z
        is Number.OneMoreThan -> omt(foldNumber(z, omt, n.number))
    }

// foldNumber checks if the number is Zero or OneMoreThan something, recursively like,
// and does one thing for Zero case and another thing for OneMoreThan case.
// We need to pass in what to do, or return, for the Zero case: The z argument.
// And what to do for the OneMoreThan case: The omt argument.
// And then, maybe later, the number we wanna work on: The n argument.

fun plus2(a: Number, b: Number): Number = foldNumber(wat(), wat(), a)
plus2(two, two)

fun mult2(a: Number, b: Number): Number = foldNumber(wat(), wat(), a)
mult2(plus(two, two), two)
