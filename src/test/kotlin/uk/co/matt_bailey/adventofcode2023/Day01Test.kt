package uk.co.matt_bailey.adventofcode2023

import kotlin.test.Test
import java.io.File

class Day01Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val exampleInput = listOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet"
        )

        val answer = Day01().solvePart1(exampleInput)
        assert(answer == 142)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {
        val inputs = File("src/test/resources/day1.txt").readLines()
        val answer = Day01().solvePart1(inputs)
        assert(answer == 54601)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val exampleInput = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        )

        val answer = Day01().solvePart2(exampleInput)
        assert(answer == 281)

    }

    @Test
    fun `Part 2 - Can solve full exercise`() {
        val inputs = File("src/test/resources/day1.txt").readLines()
        val answer = Day01().solvePart2(inputs)
        assert(answer == 54078)
    }
}
