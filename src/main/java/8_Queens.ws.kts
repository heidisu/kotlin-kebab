fun <T> wat(): T {
    throw NotImplementedError()
}

/*
Have you ever heard about the eight queens puzzle? (https://en.wikipedia.org/wiki/Eight_queens_puzzle)
invalidPositions should compare two (x, y)-tuples with positions for two queens,
and return true if they are attacking each other

validSolution takes a (queen, board)-tuple as arguments
the queen is an (x, y)-tuple with the position of a queen
the board is a list of (x, y)-tuples for already positioned queens
it should return true if it is fine to add the queen to the board
        (if the new queen is not attacking any of the queens already positioned)

newBoards takes a y and a board as arguments
the y is a column number, an int
        the board is a list of (x, y)-tuples positioned queens
it should:
make new boards by adding queens to different rows in the y column
(i.e. by making new (x, y)-tuples for possible positions for the new queen)
and return the new boards that do not have any queens attacking each other
Some maybe useful functions:
abs : int -> int
Seq.map : ('a -> 'b) -> seq<'a> -> seq<'b>
Seq.filter : ('a -> bool) -> seq<'a> -> seq<'a>
(a seq is a lot like a stream, a little like a list)
*/

fun queens(n: Int): Sequence<Sequence<Pair<Int, Int>>>{
    fun invalidPosition(pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean = wat()
    fun validSolution(queen: Pair<Int, Int>, board: Sequence<Pair<Int, Int>>): Boolean =
        board.find { invalidPosition(queen, it) } == null

    fun newBoards (y: Int,  board : Sequence<Pair<Int, Int>>): Sequence<Sequence<Pair<Int, Int>>> = wat() // todo

    fun allNewBoards(boards: Sequence<Sequence<Pair<Int, Int>>>, y: Int) = boards.flatMap { newBoards(y, it) }
    return IntRange(1, n).fold(emptySequence()){ res, i -> allNewBoards(res, i) }
}

queens(4)

queens(8).toList().size