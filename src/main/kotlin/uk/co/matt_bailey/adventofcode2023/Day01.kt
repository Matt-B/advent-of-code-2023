package uk.co.matt_bailey.adventofcode2023

class Day01 {

    fun solvePart1(input: List<String>): Int {
        var runningCount = 0
        for(line in input) {
            val matches = "[0-9]".toRegex().findAll(line)
            runningCount += (matches.first().value + matches.last().value).toInt()
        }

        return runningCount
    }

    fun solvePart2(input: List<String>): Int {
        var runningCount = 0
        for(line in input) {
            val matches = "(?=([0-9]|(one|two|three|four|five|six|seven|eight|nine)))".toRegex().findAll(line)
            runningCount += (ifTextReturnDigit(matches.first().groupValues[1]) + ifTextReturnDigit(matches.last().groupValues[1])).toInt()
        }

        return runningCount
    }

    private fun ifTextReturnDigit(value: String): String {
        if (value.length > 1) {
            when (value) {
                "one" -> return "1"
                "two" -> return "2"
                "three" -> return "3"
                "four" -> return "4"
                "five" -> return "5"
                "six" -> return "6"
                "seven" -> return "7"
                "eight" -> return "8"
                "nine" -> return "9"
                "zero" -> return "0"
            }
        }
        return value
    }
}
