sealed class Seasoning {
    object Salt : Seasoning()
}


// makings stuff with the type
val a = Seasoning.Salt
val c: Seasoning.Salt = Seasoning.Salt
val salts = listOf(a, c, Seasoning.Salt)
val moarsalts: List<Seasoning.Salt> = listOf(a, c)

salts


// A function from salt is roughly as interesting as the type
fun salty(s: Seasoning): Boolean =
    when (s) {
        is Seasoning.Salt -> true
    }

salty(Seasoning.Salt)

// What is the function salty a function from and to? Can you make it a function to an int or a string?

// Try to make something like this work
// let b = [Pepper; Pepper]
// try to mix salt and pepper in a list and see what happens
