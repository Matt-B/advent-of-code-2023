package uk.co.matt_bailey.adventofcode2023

class Day04 {

    fun solvePart1(input: List<String>): Int {
        var totalScore = 0
        for (line in input) {
            val winningNumbers = "[0-9]{1,2}".toRegex().findAll(line.split(":").last().split("|").first()).map { it.value.toInt() }.toList()
            val ourNumbers = "[0-9]{1,2}".toRegex().findAll(line.split(":").last().split("|").last()).map { it.value.toInt() }.toList()
            var score = 0
            for ((index, number) in winningNumbers.intersect(ourNumbers.toSet()).withIndex()) {
                if (index == 0) {
                    score = 1
                } else {
                    score *= 2
                }
            }
            totalScore += score
        }
        return totalScore
    }

    fun solvePart2(input: List<String>): Int {
        val numberOfCards = IntArray(input.size) { 1 }
        for ((lineIndex, line) in input.withIndex()) {
            val winningNumbers = "[0-9]{1,2}".toRegex().findAll(line.split(":").last().split("|").first()).map { it.value.toInt() }.toList()
            val ourNumbers = "[0-9]{1,2}".toRegex().findAll(line.split(":").last().split("|").last()).map { it.value.toInt() }.toList()
            val matchingNumbers = winningNumbers.intersect(ourNumbers.toSet())
            if (matchingNumbers.isNotEmpty()) {
                for ((index, number) in matchingNumbers.withIndex()) {
                    numberOfCards[lineIndex + (index + 1)] += numberOfCards[lineIndex]
                }
            }
        }
        return numberOfCards.sum()
    }
}
