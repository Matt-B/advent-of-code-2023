package uk.co.matt_bailey.adventofcode2023

class Day06 {

    fun solvePart1(input: List<String>): Long {
        val times = input.first().replace("Time:", "").trim().split("\\s+".toRegex()).map { it.toLong() }
        val distances = input.last().replace("Distance:", "").trim().split("\\s+".toRegex()).map { it.toLong() }
        val races = mutableListOf<Pair<Long, Long>>()
        for ((index, time) in times.withIndex()) {
            races.add(Pair(time, distances[index]))
        }
        val waysToWin = mutableListOf<Long>()
        for (race in races) {
            waysToWin.add(getNumberOfWaysToWin(race))
        }
        return waysToWin.reduce { acc, i -> acc * i }
    }

    private fun getRaceResult(race: Pair<Long, Long>, buttonPressTime: Long): Boolean {
        val timeToTravelDistance = race.first - buttonPressTime
        return ((buttonPressTime * timeToTravelDistance) > race.second) && (timeToTravelDistance > 0)
    }

    private fun getNumberOfWaysToWin(race: Pair<Long, Long>): Long {
        var currentButtonPressTime = 1L
        while (!getRaceResult(race, currentButtonPressTime)) {
            currentButtonPressTime++
        }
        val firstWinningValue = currentButtonPressTime
        currentButtonPressTime = race.first
        while (!getRaceResult(race, currentButtonPressTime)) {
            currentButtonPressTime--
        }
        val lastWinningValue = currentButtonPressTime
        return (firstWinningValue..lastWinningValue).count().toLong()
    }

    fun solvePart2(input: List<String>): Long {
        val time = input.first().replace("Time:", "").replace(" ", "").toLong()
        val distance = input.last().replace("Distance:", "").replace(" ", "").toLong()
        val race = Pair(time, distance)
        return getNumberOfWaysToWin(race)
    }
}
