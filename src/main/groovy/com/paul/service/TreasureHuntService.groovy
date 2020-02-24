package com.paul.service

import com.paul.domain.TreasureHunter
import com.paul.domain.TreasureMap

import javax.inject.Inject
import javax.inject.Singleton
import java.util.function.Function
import java.util.stream.Collectors

@Singleton
final class TreasureHuntService {

    TreasureHunter treasureHunter

    @Inject
    TreasureHuntService(TreasureHunter treasureHunter) {
        this.treasureHunter = new TreasureHunter(TreasureMap.getMAP() as ArrayList<ArrayList<Integer>>)
    }

    final String findTreasure(int startingPoint) {
        List<Integer> treasurePath = treasureHunter.goHuntingForTreasure(startingPoint)
        if (treasurePath != null) {
            treasurePath
                    .stream()
                    .map(new Function<Integer, String>() {
                        @Override
                        String apply(Integer a) {
                            "${Math.floor(a / 10).toInteger()} ${a % 10}"
                        }
                    })
                    .collect(Collectors.joining("\n"))
        } else {
            "NO TREASURE"
        }
    }
}
