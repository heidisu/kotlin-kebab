sealed class Seasoning {
    object Salt : Seasoning()
    object Pepper : Seasoning()
}

val seasonings = listOf(Seasoning.Salt, Seasoning.Pepper, Seasoning.Pepper, Seasoning.Salt)
seasonings

// functions from types of multiple thing should match with multiple things...
fun salty(s: Seasoning): Boolean =
    when (s) {
        is Seasoning.Salt -> true
        is Seasoning.Pepper -> false
    }

salty(Seasoning.Pepper)
salty(Seasoning.Salt)

// Try making something with three or four different things