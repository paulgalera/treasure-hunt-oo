package com.paul.service

import javax.inject.Singleton

@Singleton
class TreasureHuntService {
    String findTreasure(int startingPoint) {
        return "Still looking for a treasure..." + startingPoint
    }
}
