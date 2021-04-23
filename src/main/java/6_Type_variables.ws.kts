fun <T> wat(): T {
    throw NotImplementedError()
}

sealed class Fruit {
    object Apple : Fruit()
    object Pear : Fruit()
}

sealed class Meat {
    object Beef : Meat()
    object Mutton : Meat()
}


// food is a Plate of whatever...
data class Plate<T>(val food: T)

// what is the type of..?
Plate(Fruit.Apple)
Plate(Meat.Mutton)

fun isBeef(plate: Plate<Meat>): Boolean =
    when(plate.food){
        is Meat.Beef -> true
        is Meat.Mutton -> false
    }

isBeef (Plate(Meat.Beef))


data class Box<T>(val content: T)

Box(1)

// can you make a box<food<fruit>>?
// can you make a function from food<meat> to box<fruit>?

sealed class Either<A, B>{
    data class Left<A, B>(val value: A): Either<A, B>()
    data class Right<A, B>(val value: B): Either<A, B>()
}


val fruitOrMeat1 : Either<Fruit, Meat> = Either.Left(Fruit.Apple)

// can you make a either<fruit, meat> using the Right constructor?
val fruitOrMeat2 : Either<Fruit, Meat> = wat()

// can you make an either<food<meat>, box<fruit>>?
// (and can you make one using the Left constructor and one using the Right?)

sealed class Num<A>{
    data class Zero<A>(val value: A): Num<A>()
    data class OneMoreThan<A>(val value: A): Num<A>()
}

// can you make some zero with false, Five with your name and two of 1 (as in the int)


// Bonus...
// What am I? val weirdo = Num.OneMoreThan(Num.Zero(Num.OneMoreThan(Num.OneMoreThan(Num.Zero(1)))))