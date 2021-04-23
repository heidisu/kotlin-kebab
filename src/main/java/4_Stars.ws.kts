sealed class Meza {
    object Shrimp : Meza()
    object Calamari : Meza()
    object Escargots : Meza()
    object Hummus : Meza()
}

sealed class Main {
    object Steak : Main()
    object Ravioli : Main()
    object Chicken : Main()
    object Eggplant : Main()
}
// some values
Meza.Shrimp
Main.Steak
Pair(Meza.Shrimp, Main.Steak)
Triple(Main.Steak, Main.Steak, Main.Steak)

// (couple more types)
sealed class Salad {
    object Green : Salad()
    object Cucmber : Salad()
    object Greek : Salad()
}

sealed class Dessert {
    object Sundae : Dessert()
    object Mousse : Dessert()
    object Torte : Dessert()
}

// type with stars :)
sealed class Dinner {
    data class ThreeCourse(val meza: Meza, val main: Main, val dessert: Dessert) : Dinner()
    data class FourCourse(val meza: Meza, val salad: Salad, val main: Main, val dessert: Dessert) : Dinner()
}

val aDinner = Dinner.FourCourse(Meza.Escargots, Salad.Green, Main.Steak, Dessert.Mousse)
val anotherDinner = Dinner.ThreeCourse(Meza.Shrimp, Main.Ravioli, Dessert.Torte)

fun vegetarian(dinner: Dinner): Dinner =
    when (dinner) {
        is Dinner.ThreeCourse ->
            when (dinner.main) {
                is Main.Steak -> Dinner.ThreeCourse(dinner.meza, Main.Eggplant, dinner.dessert)
                is Main.Chicken -> Dinner.ThreeCourse(dinner.meza, Main.Eggplant, dinner.dessert)
                else -> dinner
            }
        is Dinner.FourCourse ->
            when (dinner.main) {
                is Main.Steak -> dinner.copy(main = Main.Eggplant)
                is Main.Chicken -> dinner.copy(main = Main.Eggplant)
                else -> dinner
            }
    }


vegetarian(aDinner)
vegetarian(anotherDinner)

// Can we shorten the vegetarian function?
// Do we need to match that many patterns?
// Can we use a helper function?
// Who mistook the steak for chiecken?