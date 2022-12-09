package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class Day2Test : DescribeSpec({
    describe("rock paper scissors implementation part 1") {
        it("should evaluate to DRAW for equal moves") {
            forAll(
                row('A', 'X', DRAW + ROCK),
                row('B', 'Y', DRAW + PAPER),
                row('C', 'Z', DRAW + SCISSORS),
            ) { opp, my, points ->
                calculateRound(opp, my) shouldBe points
            }
        }

        it("should evaluate to WIN for winning moves") {
            forAll(
                row('A', 'Y', WIN + PAPER),
                row('B', 'Z', WIN + SCISSORS),
                row('C', 'X', WIN + ROCK),
            ) { opp, my, points ->
                calculateRound(opp, my) shouldBe points
            }
        }

        it ("should evaluate to LOSE for losing moves") {
            forAll(
                row('A', 'Z', LOSE + SCISSORS),
                row('B', 'X', LOSE + ROCK),
                row('C', 'Y', LOSE + PAPER),
            ) { opp, my, points ->
                calculateRound(opp, my) shouldBe points
            }
        }
    }

    describe("rock paper scissors implementation part 2") {
        it("should pick correct move for LOSING outcome") {
            forAll(
                row('A', 'X', LOSE + SCISSORS),
                row('B', 'X', LOSE + ROCK),
                row('C', 'X', LOSE + PAPER),
            ) { opp, outcome, points ->
                calculateRoundAndMove(opp, outcome) shouldBe points
            }
        }

        it("should pick the same move for DRAW outcome") {
            forAll(
                row('A', 'Y', DRAW + ROCK),
                row('B', 'Y', DRAW + PAPER),
                row('C', 'Y', DRAW + SCISSORS),
            ) { opp, outcome, points ->
                calculateRoundAndMove(opp, outcome) shouldBe points
            }
        }

        it("should pick correct move for WINNING outcome") {
            forAll(
                row('A', 'Z', WIN + PAPER),
                row('B', 'Z', WIN + SCISSORS),
                row('C', 'Z', WIN + ROCK),
            ) { opp, outcome, points ->
                calculateRoundAndMove(opp, outcome) shouldBe points
            }
        }
    }
})
