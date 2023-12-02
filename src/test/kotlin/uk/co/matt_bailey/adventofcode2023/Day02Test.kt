package uk.co.matt_bailey.adventofcode2023

import kotlin.test.Test
import java.io.File

class Day02Test {

    private val exampleInput = listOf(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
    )

    @Test
    fun `Part 1 - Can solve provided example`() {
        val answer = Day02().solvePart1(exampleInput)
        assert(answer == 8)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {
        val inputs = File("src/test/resources/day2.txt").readLines()
        val answer = Day02().solvePart1(inputs)
        assert(answer == 2716)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {
        val answer = Day02().solvePart2(exampleInput)
        assert(answer == 2286)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {
        val inputs = File("src/test/resources/day2.txt").readLines()
        val answer = Day02().solvePart2(inputs)
        assert(answer == 72227)
    }
}
