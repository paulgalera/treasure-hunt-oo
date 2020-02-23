package com.paul.domain

import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Slf4j
@Singleton
final class TreasureHunter {

    final static Integer MAX_STEPS_TO_TREASURE = 28

    ArrayList<ArrayList<Integer>> treasureMap

    private List<Integer> digForTreasure(int location, List<Integer> pathToTreasure = new ArrayList<Integer>()) {
        int clueFound = pokeLocation(location)
        pathToTreasure.add(location)
        if (clueFound == location) {
            return pathToTreasure
        }
        if (pathToTreasure.size() == MAX_STEPS_TO_TREASURE) {
            return null
        }
        digForTreasure(clueFound, pathToTreasure)
    }

    private int pokeLocation(int location) {
        int row = Math.floor(location / 10 - 1).toInteger()
        int col = (location % 10) - 1
        log.info("digging in row: ${row}; col: ${col}")
        int clueFound = treasureMap.get(row).get(col)
        log.info("found clue: $clueFound")
        clueFound
    }

    final List<Integer> goHuntingForTreasure(int location) {
        List<Integer> pathToTreasure = new ArrayList<>()
        List<Integer> initialSpots = Arrays.asList(location, 55, 15)
        pathToTreasure.addAll(goCheckInitialSpots(initialSpots))
        if (pathToTreasure.size() == 3) {
            pathToTreasure = digForTreasure(pokeLocation(pathToTreasure.get(pathToTreasure.size() - 1)), pathToTreasure)
        }
        pathToTreasure
    }

    private List<Integer> goCheckInitialSpots(List<Integer> initialSpots) {
        List<Integer> initialPath = new ArrayList<>()
        for (spot in initialSpots) {
            int clue = pokeLocation(spot)
            initialPath.add(spot)
            if (clue == spot) {
                break
            }
        }
        initialPath
    }
}
