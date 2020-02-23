package com.paul.service

import com.paul.domain.TreasureHunter
import com.paul.domain.TreasureMap
import groovy.util.logging.Slf4j

import javax.inject.Inject
import javax.inject.Singleton
import java.util.function.Function
import java.util.stream.Collectors

@Singleton
@Slf4j
final class TreasureHuntService {

    @Inject
    TreasureHunter treasureHunter

    final String findTreasure(int startingPoint) {
        ArrayList<ArrayList<Integer>> treasureMap = TreasureMap.getMAP()
        treasureHunter.setTreasureMap(treasureMap)
        treasureHunter.goHuntingForTreasure(startingPoint)
                .stream()
                .map(new Function<Integer, String>() {
                    @Override
                    String apply(Integer a) {
                        "${Math.floor(a / 10).toInteger()} ${a % 10}"
                    }
                })
                .collect(Collectors.joining("\n"))
    }
}
