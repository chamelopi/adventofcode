package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe


class Day2Test : DescribeSpec({
    describe("Rock Paper Scissors implementation") {
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
})
