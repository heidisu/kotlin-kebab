import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TreeTests {

    @Test
    fun `flipped bud is bud`() =
        assertEquals(Bud, flip(Bud))

    @Test
    fun `flipped rightTree is leftTree`() =
        assertEquals(LeftFruit(Peach, Bud), flip(RightFruit(Bud, Peach)))

    @Test
    fun `flipped leftTree is rightTree`() =
        assertEquals(RightFruit(Bud, Apple), flip(LeftFruit(Apple, Bud)))

    @Test
    fun `flipped split flips splits`() =
        assertEquals(Split(LeftFruit(Pear, Bud), RightFruit(Bud, Apple)), flip(Split(LeftFruit(Apple, Bud), RightFruit(Bud, Pear))))

    @Test
    fun `tree with pears has pears`() =
        assertEquals(true, hasPear(RightFruit(Bud, Pear)))

    @Test
    fun `tree with no pears has no pears`() =
        assertEquals(false, hasPear(RightFruit(Bud, Peach)))

    @Test
    fun `eat pears remove pears from tree`() =
        assertEquals(Split(LeftFruit(null, Bud), RightFruit(Bud, null)), eatPear(Split(LeftFruit(Pear, Bud), RightFruit(Bud, null))))

}