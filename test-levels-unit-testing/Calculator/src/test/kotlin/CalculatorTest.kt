import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class CalculatorTest{
    private val calculator: Calculator = Calculator()

    @Test
    fun testAdd() {
        assertEquals(3.0, calculator.Add(1.0, 2.0))
    }
    @Test
    fun testSubstract() {
        assertEquals(1.0, calculator.Substract(2.0, 1.0))
    }
    @Test
    fun testMultiply() {
        assertEquals(6.0, calculator.Multiply(2.0, 3.0))
    }
    @Test
    fun testDivide() {
        assertEquals(2.0, calculator.Divide(6.0, 3.0))
    }
}