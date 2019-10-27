package dev.dakoda.alr.domain.character

import dev.dakoda.alr.domain.MockCharacter
import dev.dakoda.dassert.dassert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.valiktor.ConstraintViolationException

class StatTest {

    @Test
    fun `When creating a weapon with a negative monetary value, then throw a Valiktor constraint violation exception`() {
        assertThrows<ConstraintViolationException> {
            Stat(
                type = StatType.COURAGE,
                value = -1f
            )
        }
    }

    @Test
    fun `When creating a weapon, it is instantiated correctly`() {
        val stat: Stat? = MockCharacter.stat(
            type = StatType.COURAGE,
            value = 20f
        )

        dassert {
            with(stat!!) {
                type equals StatType.COURAGE
                value equals 20f
            }
        }
    }

    @Test
    fun `Two equally instantiated Stat objects are equal`() {
        val first = MockCharacter.stat(
            type = StatType.DEXTERITY,
            value = 100f
        )
        val second = MockCharacter.stat(
            type = StatType.DEXTERITY,
            value = 100f
        )

        dassert {
            first equals second
            first.hashCode() equals second.hashCode()
        }
    }

    @Test
    fun `Unequally instantiated Stat objects are not equal`() {
        val first = MockCharacter.stat(
            type = StatType.WISDOM,
            value = 100f
        )
        val second = MockCharacter.stat(
            type = StatType.DEXTERITY,
            value = 100f
        )
        val third = MockCharacter.stat(
            type = StatType.DEXTERITY,
            value = 50f
        )

        dassert {
            first isNotEqualTo second
            second isNotEqualTo third
            third isNotEqualTo first
        }
    }

    @Test
    fun `A Stat object can only be equal to another Stat object`() {
        val first = MockCharacter.stat(
            type = StatType.DEXTERITY,
            value = 100f
        )
        val second = "Stat"

        dassert {
            first isNotEqualTo second
        }
    }
}