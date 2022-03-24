/*
Simple calculator using variable and function to compute
operands: ADD, SUBTRACT, MULTIPLY, DIVIDE, REMINDER AND EXPONENT
 */
import kotlin.math.pow

const val ADD = "+"
const val SUBTRACT = "-"
const val MULTIPLY = "*"
const val DIVIDE = "/"
const val REMINDER = "%"
const val EXPONENT = "^"

var ERROR_MSG: String? = null

val testArgOne = 3.5
val testArgwo = 4.0

// Error message for invalid Operand or inputted values
fun setErrorMsg(er: String) = ERROR_MSG ?: er ?: "An Error Occurred"

//Display computed value
//fun displayComputedResult(result: String) = println("Result:: $result")

fun checkOperand(operand: String): Boolean {
    return when (operand) {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, REMINDER, EXPONENT -> true
        else -> false
    }
}

//Denominator should be none zero
fun evaluateDenominator(denominator: Double, operand: String) = denominator == 0.0 && operand == DIVIDE

//Check inputted operand is the list and the denominator should not be zero
fun calculate(argsOne: Double, argsTwo: Double, operand: String): String {
    return when {
        !checkOperand(operand) -> setErrorMsg("Invalid  Operand !!")
        evaluateDenominator(argsTwo, operand) -> setErrorMsg("Zero Denominator Error !!")
        else -> operandFunction(argsOne, argsTwo, operand)
    }

}

fun operandFunction(argOne: Double, argTwo: Double, operand: String): String {
    return when (operand) {
        ADD -> (argOne + argTwo).toString()
        MULTIPLY -> (argOne * argTwo).toString()
        SUBTRACT -> (argOne - argTwo).toString()
        DIVIDE -> (argOne / argTwo).toString()
        REMINDER -> (argOne % argTwo).toString()
        EXPONENT -> (argOne.pow(argTwo)).toString()
        else -> null.toString()
    }
}

fun main() {
    println("Check An Argument:: ${calculate(testArgOne, 0.0, DIVIDE)}")
}
