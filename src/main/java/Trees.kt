
sealed class Fruit()

object Fig: Fruit()
object Orange: Fruit()
object Peach: Fruit()
object Apple: Fruit()
object Pear: Fruit()

sealed class Tree()
object Bud: Tree()
data class LeftFruit(val fruit: Fruit?, val tree: Tree): Tree()
data class RightFruit(val tree: Tree, val fruit: Fruit?): Tree()
data class Split(val left: Tree, val right: Tree): Tree()

fun flip(tree: Tree): Tree =
    when(tree){
        is Bud -> Bud
        is LeftFruit -> RightFruit(tree.tree, tree. fruit)
        is RightFruit -> LeftFruit(tree.fruit, tree.tree)
        is Split -> Split(flip(tree.right), flip(tree.left))
    }

fun hasPear(tree: Tree) : Boolean =
    when(tree){
        is Bud -> false
        is LeftFruit -> tree.fruit == Pear || hasPear(tree.tree)
        is RightFruit -> tree.fruit == Pear || hasPear(tree.tree)
        is Split -> hasPear(tree.left) || hasPear(tree.right)
    }

fun eatPear(tree: Tree) : Tree =
    when(tree){
        is Bud -> Bud
        is LeftFruit ->
            when(tree.fruit){
                is Pear -> LeftFruit(null, eatPear(tree.tree))
                else -> tree
            }
        is RightFruit ->
            when(tree.fruit){
                is Pear -> RightFruit(eatPear(tree.tree), null)
                else -> tree
            }
        is Split -> Split(eatPear(tree.left), eatPear(tree.right))
    }
