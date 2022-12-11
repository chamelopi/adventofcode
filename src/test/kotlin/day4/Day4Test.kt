package day4

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class Day4Test : DescribeSpec({
    describe("camp cleanup implementation") {
        it("should correctly parse elf pairs from input string") {
            forAll(
                row("2-4,6-8", Pair(2..4, 6..8)),
                row("2-3,4-5", Pair(2..3, 4..5)),
                row("5-7,7-9", Pair(5..7, 7..9)),
            ) { input, expectedPairs ->
                parseRange(input) shouldBe expectedPairs
            }
        }

        it("should correctly find full overlaps") {
            forAll(
                row(Pair(2..5, 6..7), false),
                row(Pair(1..4, 3..5), false),
                row(Pair(1..10, 3..8), true),
            ) { ranges, expectedOverlaps ->
                hasFullOverlap(ranges) shouldBe expectedOverlaps
            }
        }

        it("should correctly find partial overlaps") {
            forAll(
                row(Pair(2..5, 6..7), false),
                row(Pair(1..4, 3..5), true),
                row(Pair(2..4, 1..2), true),
                row(Pair(1..10, 3..8), true),
            ) { ranges, expectedOverlaps ->
                hasPartialOverlap(ranges) shouldBe expectedOverlaps
            }
        }
    }
})