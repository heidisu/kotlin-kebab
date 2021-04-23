sealed class Seasoning {
    object Salt : Seasoning()
    object Pepper : Seasoning()
}

sealed class Food {
    data class Meat(val seasoning: Seasoning) : Food()
    data class Carrots(val number: Int) : Food()
    object SeaWater : Food()
}

// Meat, Carrots and SeaWater are food's constructors
// Meat needs an argument of seasoning to construct a value of type food
// Carrots needs an argument of int to construct a value of type food

Food.Meat(Seasoning.Pepper)
Food.Carrots(2)

// functions from types with things with things can match with things within things

fun salty(food: Food): Boolean =
    when (food) {
        is Food.Meat ->
            when (food.seasoning) {
                is Seasoning.Salt -> true
                is Seasoning.Pepper -> false
            }
        is Food.Carrots -> false
        is Food.SeaWater -> true
    }

salty(Food.Carrots(2))

// Potato chips is also salty food. Add some.
// Or maybe make some SeasonedCarrots - if you season them with salt they are probably salty too...