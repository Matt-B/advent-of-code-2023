package uk.co.matt_bailey.adventofcode2023

class Day05 {

    fun solvePart1(input: List<String>): Long {
        val seeds = input.first().replace("seeds: ", "").split(" ").map { it.toLong() }
        val maps = getMaps(input)
        val results = getSeedResults(seeds, maps)
        return results.min()
    }

    fun solvePart2(input: List<String>): Long {
        val seedRanges = "[0-9]+ [0-9]+".toRegex().findAll(input.first()).map {
            (it.value.split(" ").first().toLong()..<it.value.split(" ").first().toLong() + it.value.split(" ").last().toLong())
        }
        val maps = getMaps(input)
        var currentLocation = 1L
        while (!isSeedInRanges(getSeedForLocation(currentLocation, maps), seedRanges)) {
            currentLocation++
        }
        return currentLocation
    }

    private fun getMaps(input: List<String>): List<List<String>> {
        val seedToSoilMap = input.subList(input.indexOf("seed-to-soil map:") + 1, input.indexOf("soil-to-fertilizer map:") - 1)
        val soilToFertilizerMap = input.subList(input.indexOf("soil-to-fertilizer map:") + 1, input.indexOf("fertilizer-to-water map:") - 1)
        val fertilizerToWaterMap = input.subList(input.indexOf("fertilizer-to-water map:") + 1, input.indexOf("water-to-light map:") - 1)
        val waterToLightMap = input.subList(input.indexOf("water-to-light map:") + 1, input.indexOf("light-to-temperature map:") - 1)
        val lightToTemperatureMap = input.subList(input.indexOf("light-to-temperature map:") + 1, input.indexOf("temperature-to-humidity map:") - 1)
        val temperatureToHumidityMap = input.subList(input.indexOf("temperature-to-humidity map:") + 1, input.indexOf("humidity-to-location map:") - 1)
        val humidityToLocationMap = input.subList(input.indexOf("humidity-to-location map:") + 1, input.size - 1)
        return mutableListOf(seedToSoilMap, soilToFertilizerMap, fertilizerToWaterMap, waterToLightMap, lightToTemperatureMap, temperatureToHumidityMap, humidityToLocationMap)
    }

    private fun getSeedResults(seeds: List<Long>, maps: List<List<String>>): List<Long> {
        val results = mutableListOf<Long>()
        for (seed in seeds) {
            results.add(getSeedResult(seed, maps))
        }
        return results
    }

    private fun isSeedInRanges(seed: Long, seedRanges: Sequence<LongRange>): Boolean {
        for (seedRange in seedRanges) {
            if (seedRange.contains(seed)) {
                return true
            }
        }
        return false
    }

    private fun getSeedResult(seed: Long, maps: List<List<String>>): Long {
        var currentValue = seed
        for (map in maps) {
            val rangedMap = map.associate {
                val destinationStart = it.split(" ").first().toLong()
                val sourceStart = it.split(" ")[1].toLong()
                val rangeLength = it.split(" ").last().toLong()
                sourceStart..<(sourceStart + rangeLength) to destinationStart..<(destinationStart + rangeLength)
            }
            for (item in rangedMap) {
                if (item.key.contains(currentValue)) {
                    currentValue = item.value.first + (currentValue - item.key.first)
                    break
                }
            }
        }
        return currentValue
    }

    private fun getSeedForLocation(location: Long, maps: List<List<String>>): Long {
        var currentValue = location
        val reversedMaps = maps.reversed()
        for (map in reversedMaps) {
            val rangedMap = map.associate {
                val sourceStart = it.split(" ").first().toLong()
                val destinationStart = it.split(" ")[1].toLong()
                val rangeLength = it.split(" ").last().toLong()
                sourceStart..<(sourceStart + rangeLength) to destinationStart..<(destinationStart + rangeLength)
            }
            for (item in rangedMap) {
                if (item.key.contains(currentValue)) {
                    currentValue = item.value.first + (currentValue - item.key.first)
                    break
                }
            }
        }
        return currentValue
    }
}
