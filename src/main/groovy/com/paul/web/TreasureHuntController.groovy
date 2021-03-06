package com.paul.web

import com.paul.service.TreasureHuntService
import com.paul.utils.InputChecker
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType
import io.micronaut.retry.annotation.CircuitBreaker

import javax.inject.Inject

@CompileStatic
@Controller("/")
class TreasureHuntController {

    TreasureHuntService treasureHuntService

    @Inject
    TreasureHuntController(TreasureHuntService treasureHuntService) {
        this.treasureHuntService = treasureHuntService
    }

    @Get("{startPoint}")
    @Produces(MediaType.TEXT_PLAIN)
    @CircuitBreaker(attempts = "2", reset = "30s")
    String index(int startPoint) {
        if (InputChecker.isInputOk(startPoint)) {
            treasureHuntService.findTreasure(startPoint)
        }
        else{
            "Holy smoke...$startPoint is a wrong index for a 5x5 TreasureMap!"
        }
    }
}