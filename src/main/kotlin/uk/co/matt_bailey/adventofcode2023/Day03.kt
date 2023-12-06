package uk.co.matt_bailey.adventofcode2023

class Day03 {
    fun solvePart1(input: List<String>): Int {
        var partNumberSum = 0
        for (line in input) {
            val numbers = "[0-9]+".toRegex().findAll(line)
            for (number in numbers) {
                var surroundingCharacters = ""
                val startIndex = if (number.range.first == 0) 0 else number.range.first - 1
                val endIndex = if (number.range.last >= line.length - 1) line.length - 1 else number.range.last + 1
                val rangeToInspect = startIndex..endIndex
                surroundingCharacters += line.substring(rangeToInspect).replace(number.value, "")
                if (input.indexOf(line) > 0) {
                    surroundingCharacters += input[input.indexOf(line) - 1].substring(rangeToInspect)
                }
                if (input.indexOf(line) < input.size - 1) {
                    surroundingCharacters += input[input.indexOf(line) + 1].substring(rangeToInspect)
                }
                val surroundingSymbols = surroundingCharacters.replace(".", "")
                if ("[^a-zA-Z0-9]".toRegex().findAll(surroundingSymbols).toList().isNotEmpty()) {
                    partNumberSum += number.value.toInt()
                }
            }
        }
        return partNumberSum
    }

    fun solvePart2(input: List<String>): Int {
        var sumOfGearRatios = 0
        for ((index, line) in input.withIndex()) {
            val numbersInLines = mutableListOf<MatchResult>()
            if (index > 0) {
                numbersInLines.addAll("[0-9]+".toRegex().findAll(input[index - 1]))
            }
            numbersInLines.addAll("[0-9]+".toRegex().findAll(line))
            if (index < input.size - 1) {
                numbersInLines.addAll("[0-9]+".toRegex().findAll(input[index + 1]))
            }
            val gears = "\\*".toRegex().findAll(line)
            for (gear in gears) {
                val gearIndex = gear.range.first
                val startIndex = if (gearIndex == 0) 0 else gearIndex - 1
                val endIndex = if (gearIndex >= line.length - 1) line.length - 1 else gearIndex + 1
                val rangeToInspect = startIndex..endIndex
                val adjacentPartNumbers = mutableListOf<String>()
                for (number in numbersInLines) {
                    if (number.range.intersect(rangeToInspect).isNotEmpty()) {
                        adjacentPartNumbers.add(number.value)
                    }
                }
                if (adjacentPartNumbers.size == 2) {
                    sumOfGearRatios += adjacentPartNumbers.first().toInt() * adjacentPartNumbers.last().toInt()
                }
            }
        }
        return sumOfGearRatios
    }
}
