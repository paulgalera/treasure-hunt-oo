package com.paul.utils

import groovy.transform.Immutable

@Immutable class InputChecker {
    final static List<Integer> INPUT = [11, 12, 13, 14, 15,
                                        21, 22, 23, 24, 25,
                                        31, 32, 33, 34, 35,
                                        41, 42, 43, 44, 45,
                                        51, 52, 53, 54, 55]

    static boolean isInputOk(Object param) {
        param instanceof Integer ? INPUT.contains(param) : false
    }
}
