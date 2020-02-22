package com.paul.service

import com.paul.domain.TreasureHunter
import com.paul.domain.TreasureMap
import groovy.util.logging.Slf4j

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Slf4j
final class TreasureHuntService {

    @Inject
    TreasureHunter treasureHunter

    final String findTreasure(int startingPoint) {
        ArrayList<ArrayList<Integer>> treasureMap = TreasureMap.getMAP()
        treasureHunter.setTreasureMap(treasureMap)
        treasureHunter.digForTreasure(startingPoint)
    }
}
