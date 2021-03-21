package dev.hbrown.demo

import java.time.Clock
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun LocalDate.getAgeInYears(clock: Clock = Clock.systemUTC()): Int = if(this.isAfter(LocalDate.now(clock))) {
    throw InvalidDateOfBirthException(this)
} else {
    ChronoUnit.YEARS.between(this, LocalDate.now(clock)).toInt()
}

class InvalidDateOfBirthException(val dob: LocalDate): RuntimeException("Date of birth cannot be in the future. Date of Birth is: $dob")
