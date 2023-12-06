package uk.co.matt_bailey.adventofcode2023

import java.io.File
import kotlin.test.Test

class Day06Test {

    private val exampleInput =
        listOf(
            "Time:      7  15   30",
            "Distance:  9  40  200",
        )

    @Test
    fun `Part 1 - Can solve provided example`() {
        val answer = Day06().solvePart1(exampleInput)
        assert(answer == 288L)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {
        val inputs = File("src/test/resources/day6.txt").readLines()
        val answer = Day06().solvePart1(inputs)
        assert(answer == 449550L)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {
        val answer = Day06().solvePart2(exampleInput)
        assert(answer == 71503L)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {
        val inputs = File("src/test/resources/day6.txt").readLines()
        val answer = Day06().solvePart2(inputs)
        assert(answer == 28360140L)
    }
}
