sealed class Kebab {
    object Skewer : Kebab()
    data class Onion(val kebab: Kebab) : Kebab()
    data class Lamb(val kebab: Kebab) : Kebab()
    data class Tomato(val kebab: Kebab) : Kebab()
}

fun getRidOfOnions(kebab: Kebab): Kebab =
    when (kebab) {
        is Kebab.Skewer -> kebab
        is Kebab.Onion -> getRidOfOnions(kebab.kebab)
        is Kebab.Lamb -> Kebab.Lamb(getRidOfOnions((kebab.kebab)))
        is Kebab.Tomato -> Kebab.Tomato(getRidOfOnions(kebab.kebab))
    }

getRidOfOnions(Kebab.Onion(Kebab.Lamb(Kebab.Onion(Kebab.Skewer))))

// Make a function that puts tomatoes on top of onsions instead. Or replaces Lamb with Tomato.

// Make a function that counts tomatoes -- a function from kebab to int
