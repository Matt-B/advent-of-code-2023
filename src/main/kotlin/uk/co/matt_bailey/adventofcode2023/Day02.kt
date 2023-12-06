package uk.co.matt_bailey.adventofcode2023

class Day02 {
    fun solvePart1(input: List<String>): Int {
        var sumOfPossibleGames = 0
        for (line in input) {
            val gameId = line.split(":").first().replace("Game ", "")
            val sets = line.split(":").last().split(";")
            var possible = true
            for (set in sets) {
                val cubeSets = "[0-9]* (blue|red|green)".toRegex().findAll(set)
                for (cubeSet in cubeSets) {
                    val number = cubeSet.value.split(" ").first().toInt()
                    val colour = cubeSet.value.split(" ").last()
                    if (colour == "red" && number > 12) {
                        possible = false
                    }
                    if (colour == "green" && number > 13) {
                        possible = false
                    }
                    if (colour == "blue" && number > 14) {
                        possible = false
                    }
                }
            }
            if (possible) {
                sumOfPossibleGames += gameId.toInt()
            }
        }
        return sumOfPossibleGames
    }

    fun solvePart2(input: List<String>): Int {
        var sumOfPowers = 0
        for (line in input) {
            val maxCubes =
                mutableMapOf(
                    "blue" to 0,
                    "red" to 0,
                    "green" to 0,
                )
            val sets = line.split(":").last().trim()
            val cubeSets = "[0-9]* (blue|red|green)".toRegex().findAll(sets)
            for (cubeSet in cubeSets) {
                val number = cubeSet.value.split(" ").first().toInt()
                val colour = cubeSet.value.split(" ").last()
                if (maxCubes[colour]!! < number) {
                    maxCubes[colour] = number
                }
            }
            sumOfPowers += (maxCubes["blue"]!! * maxCubes["red"]!! * maxCubes["green"]!!)
        }
        return sumOfPowers
    }
}
