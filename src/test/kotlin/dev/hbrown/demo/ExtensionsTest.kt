package dev.hbrown.demo

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import strikt.api.*
import strikt.assertions.*
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDate.of as dob
import java.time.ZoneOffset

const val fixedDate = "2021-03-21"

class ExtensionsTest {

    private val fixedClock = Clock.fixed(Instant.parse("${fixedDate}T00:00:00.00Z"), ZoneOffset.UTC)

    @Test
    internal fun `should not be able to create a date of birth in the future`() {
        val tomorrow = LocalDate.now().plusDays(1)

        expectThrows<InvalidDateOfBirthException> {
            tomorrow.getAgeInYears()
        }.and {
            get { dob }.isEqualTo(tomorrow)
        }
    }

    @ParameterizedTest(name = "[{index}] {0} on $fixedDate")
    @MethodSource("localDateToAge")
    internal fun `should be able to calculate age from a local date`(p: DateOfBirthAgePair) {
        val (dateOfBirth: LocalDate, ageInYears: Int) = p

        expectThat(dateOfBirth.getAgeInYears(fixedClock)).isEqualTo(ageInYears)
    }

    @Suppress("unused") //used as MethodSource for [`should be able to calculate age from a local date`]
    private fun localDateToAge(): List<DateOfBirthAgePair> = listOf(
        DateOfBirthAgePair(dob(2021, 1, 1), 0),
        DateOfBirthAgePair(dob(2000, 1, 1), 21),

        DateOfBirthAgePair(dob(1974, 3, 20), 47),
        DateOfBirthAgePair(dob(1974, 3, 21), 47),
        DateOfBirthAgePair(dob(1974, 3, 22), 46),
    )

    data class DateOfBirthAgePair(val dateOfBirth: LocalDate, val ageInYears: Int) {
        override fun toString() = "$dateOfBirth is $ageInYears years"
    }

}
