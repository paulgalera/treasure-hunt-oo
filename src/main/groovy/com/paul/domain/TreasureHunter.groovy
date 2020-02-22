package com.paul.domain

import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Slf4j
@Singleton
final class TreasureHunter {

    ArrayList<ArrayList<Integer>> treasureMap
    List<Integer> path = new ArrayList<>()

    private List<Integer> digForTreasure(int location, List<Integer> pathToTreasure=new ArrayList<Integer>()) {
        int clueFound = pokeLocation(location)
        pathToTreasure.add(location)
        if (clueFound == location)
            return pathToTreasure
        digForTreasure(clueFound, pathToTreasure)
    }

    private int pokeLocation(int location) {
        int row = Math.floor(location/10-1).toInteger()
        int col = (location % 10) -1
        log.info("digging in row: ${row}; col: ${col}" )
        int clueFound = treasureMap.get(row).get(col)
        log.info("found clue: $clueFound")
        clueFound
    }

    final List<Integer> goHuntingForTreasure (int location) {
        List<Integer> pathToTreasure = new ArrayList<>()
        List<Integer> initialSpots = Arrays.asList(location, 55, 15)

        pathToTreasure.add(pokeLocation(location))
        pathToTreasure
    }
}
