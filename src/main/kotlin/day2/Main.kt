package day2

import util.loadInput
import util.sep

const val ROCK = 1;
const val PAPER = 2;
const val SCISSORS = 3;

const val LOSE = 0;
const val DRAW = 3;
const val WIN = 6;

val MY_MAPPING = mapOf('X' to ROCK, 'Y' to PAPER, 'Z' to SCISSORS)
val OPPONENT_MAPPING = mapOf('A' to ROCK, 'B' to PAPER, 'C' to SCISSORS)

fun winning(myMove: Int, opponentMove: Int): Boolean {
    return (myMove == ROCK && opponentMove == SCISSORS)
            || (myMove == SCISSORS && opponentMove == PAPER)
            || (myMove == PAPER && opponentMove == ROCK)
}

fun calculateRound(opponentChar: Char, myChar: Char): Int {
    val myMove = MY_MAPPING.getValue(myChar)
    val opponentMove = OPPONENT_MAPPING.getValue(opponentChar)

    val outcome = if (myMove == opponentMove) {
        DRAW
    } else if (winning(myMove, opponentMove)) {
        WIN
    } else {
        LOSE
    }

    return outcome + myMove
}

fun main() {
    println(loadInput("day2-input.txt")
        .trim()
        .split(sep)
        .map { it.split(' ').map { x -> x.toCharArray()[0] } }
        .sumOf { calculateRound(it[0], it[1]) })
}