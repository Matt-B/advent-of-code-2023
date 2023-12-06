package uk.co.matt_bailey.adventofcode2023

import java.io.File
import kotlin.test.Test

class Day03Test {
    private val exampleInput =
        listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...\$.*....",
            ".664.598..",
        )

    @Test
    fun `Part 1 - Can solve provided example`() {
        val answer = Day03().solvePart1(exampleInput)
        assert(answer == 4361)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {
        val inputs = File("src/test/resources/day3.txt").readLines()
        val answer = Day03().solvePart1(inputs)
        assert(answer == 543867)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {
        val answer = Day03().solvePart2(exampleInput)
        assert(answer == 467835)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {
        val inputs = File("src/test/resources/day3.txt").readLines()
        val answer = Day03().solvePart2(inputs)
        assert(answer == 79613331)
    }
}
