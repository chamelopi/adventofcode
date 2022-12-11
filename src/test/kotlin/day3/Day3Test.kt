package day3

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import util.sep

class Day3Test : DescribeSpec({
    describe("rucksack implementation") {
        it("should split rucksacks correctly") {
            forAll(
                row("vJrwpWtwJgWrhcsFMMfFFhFp", Pair("vJrwpWtwJgWr", "hcsFMMfFFhFp")),
                row("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", Pair("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL")),
                row("PmmdzqPrVvPwwTWBwg", Pair("PmmdzqPrV", "vPwwTWBwg")),
            ) { rucksack, expectedCompartments ->
                getCompartments(rucksack) shouldBe expectedCompartments
            }
        }

        it("should determine shared items correctly") {
            forAll(
                row(Pair("vJrwpWtwJgWr", "hcsFMMfFFhFp"), listOf('p')),
                row(Pair("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL"), listOf('L')),
                row(Pair("PmmdzqPrV", "vPwwTWBwg"), listOf('P')),
                row(Pair("PmmdzqPrV", "ajksESGIA"), listOf()),
            ) { compartments, sharedItems ->
                getSharedItems(compartments) shouldBe sharedItems
            }
        }

        it("should calculate priorities correctly") {
            forAll(
                row('p', 16), row('L', 38), row('P', 42),
                row('v', 22), row('t', 20), row('s', 19),
            ) { item, expectedPriority ->
                getPriorityOfItem(item) shouldBe expectedPriority
            }
        }

        it("should correctly determine the shared item between three rucksacks") {
            forAll(
                row(Triple("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","PmmdzqPrVvPwwTWBwg"), 'r'),
                row(Triple("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn","ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw"), 'Z')
            ) { rucksacks, commonItem ->
                getSharedItems(rucksacks) shouldBe commonItem
            }
        }
    }
})
