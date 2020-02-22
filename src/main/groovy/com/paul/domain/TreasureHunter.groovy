package com.paul.domain

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TreasureHunter {

    ArrayList<ArrayList<Integer>> treasureMap

    TreasureHunter(ArrayList<ArrayList<Integer>> treasureMap) {
        this.treasureMap = treasureMap
    }

    int digForTreasure(int location) {
        treasureMap.get(Math.floor(location/10-1).toInteger()).get((location % 10) -1)
    }
}
