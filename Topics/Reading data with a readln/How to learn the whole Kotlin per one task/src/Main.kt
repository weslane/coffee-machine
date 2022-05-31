fun main() {
    // put your code here
    val inputs = mutableListOf<String>()
    for (i in 0..RANGE) {
        inputs.add(readln())
    }

    for (input in inputs) {
        print(input)
        print(" ")
    }
}

const val RANGE = 4