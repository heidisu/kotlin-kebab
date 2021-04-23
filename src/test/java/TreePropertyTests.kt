import io.kotest.core.spec.style.StringSpec
import io.kotest.property.RandomSource
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.forAll

class TreePropertyTests : StringSpec({
    val arbitraryFruit= arbitrary { rs: RandomSource ->
        when(rs.random.nextInt(6)){
            0 -> Fig
            1 -> Orange
            2 -> Peach
            3 -> Apple
            4 -> Pear
            else -> null
        }
    }

    val arbitraryTree = arbitrary { rs: RandomSource ->
        val treeHeight = rs.random.nextInt(20)
        fun genTree(size: Int): Tree{
            if (size == 0) {
                return Bud
            } else {
                return when(rs.random.nextInt(3)){
                    0 -> LeftFruit(arbitraryFruit.sample(rs).value, genTree(size/2))
                    1 -> RightFruit(genTree(size/2), arbitraryFruit.sample(rs).value)
                    else -> Split(genTree(size/2), genTree(size/2))
                }
            }
        }
        genTree(treeHeight)
    }

    "Doubleflipped trees are equal to themselves" {
        arbitraryTree.forAll { tree ->
            flip(flip(tree)) == tree
        }
    }

    "Eating pears does not change a tree if it doesn't have pears" {
        arbitraryTree.forAll { tree ->
            if (hasPear(tree)){
                println(tree)
                eatPear(tree) != tree
            } else {
                eatPear(tree) == tree
            }
        }
    }

    "Flipped asymmetric tree is not equal to self" {
        arbitraryFruit.forAll { fruit ->
            val tree = LeftFruit (fruit, Bud)
             tree != flip(tree)
        }
    }
})