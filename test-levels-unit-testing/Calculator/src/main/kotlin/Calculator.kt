class Calculator {
    fun Add(summand1: Double, summand2: Double): Double {
        return summand1 + summand2
    }

    fun Substract(minuend: Double, subtrahend: Double): Double {
        return minuend - subtrahend
    }

    fun Multiply(faktor1: Double, faktor2: Double): Double {
        return faktor1 * faktor2
    }

    fun Divide(dividend: Double, divisor: Double): Double {
        if (divisor == 0.0) {
            throw IllegalArgumentException("Divisor must not be 0")
        }
        return dividend / divisor
    }
}
