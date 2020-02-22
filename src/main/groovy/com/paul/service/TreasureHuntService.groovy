package com.paul.service

import com.paul.domain.TreasureHunter
import com.paul.domain.TreasureMap
import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Singleton
@Slf4j
final class TreasureHuntService {

    final String findTreasure(int startingPoint) {
        ArrayList<ArrayList<Integer>> treasureMap = TreasureMap.getMAP()
        TreasureHunter treasureHunter = new TreasureHunter(treasureMap)
        log.info("row: ${Math.floor(startingPoint/10-1).toInteger()}; col: ${(startingPoint % 10) -1}" )
        return "Still looking for a treasure..." + startingPoint
    }
}
