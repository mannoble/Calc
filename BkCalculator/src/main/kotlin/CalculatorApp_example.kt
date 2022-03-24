import kotlin.math.pow

/*
Simple calculator using Sealed and Enum class
Applicable operand, ADD, SUBTRACT, MULTIPLY, DIVIDE, REMINDER AND EXPONENT
 */

//Operand in Enum Class
enum class OperandEnum {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, REMINDER, EXPONENT
}

fun errorMsg(er: String) = er

// Operand in Sealed Class
sealed class OperandSealed {
    object ADD : OperandSealed()
    object SUBTRACT : OperandSealed()
    object MULTIPLY : OperandSealed()
    object DIVIDE : OperandSealed()
    object REMINDER : OperandSealed()
    object EXPONENT : OperandSealed()

}

// Check inputted value: arguments and Operand
fun computeUsingEnum(arg1: Double, arg2: Double, op: OperandEnum): String {
    return when (op) {
        OperandEnum.ADD -> (arg1 + arg2).toString()
        OperandEnum.SUBTRACT -> (arg1 - arg2).toString()
        OperandEnum.MULTIPLY -> (arg1 * arg2).toString()
        OperandEnum.DIVIDE -> if (arg2 != 0.0) (arg1 / arg2).toString() else errorMsg("Zero Denominator")
        OperandEnum.REMINDER -> (arg1 % arg2).toString()
        OperandEnum.EXPONENT -> (arg1.pow(arg2)).toString()


    }

}

// Check inputted value using Sealed class and Operand, Return: either final computed  result or Error message
fun computeUsingSealed(arg1: Double, arg2: Double, op: OperandSealed): String {
    return when (op) {
        is OperandSealed.ADD -> (arg1 + arg2).toString()
        is OperandSealed.SUBTRACT -> (arg1 - arg2).toString()
        is OperandSealed.DIVIDE -> (if (arg2 != 0.0) (arg1 / arg2).toString() else errorMsg("Zero Denominator "))
        is OperandSealed.MULTIPLY -> (arg1 * arg2).toString()
        is OperandSealed.REMINDER -> (arg1 % arg2).toString()
        is OperandSealed.EXPONENT -> (arg1.pow(arg2)).toString()
    }


}

fun main() {
    val testArg1 = 8.0
    val testArg2 = 2.0
    println(computeUsingEnum(testArg1, testArg2, OperandEnum.EXPONENT))
    println("Getting Sealed Result:: ${computeUsingSealed(testArg1, testArg2, OperandSealed.DIVIDE)}")


}

