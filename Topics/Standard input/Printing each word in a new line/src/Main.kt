import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    // put your code here
    val inputList = mutableListOf<String>()
    for (count in 0..RANGE) {
        inputList.add(scanner.next())
    }

    for (input in inputList) {
        println(input)
    }
}

const val RANGE = 4