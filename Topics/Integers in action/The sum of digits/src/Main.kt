fun main() {
    val value = readln().toInt()
    var sum = value / 100 + value % 100 / 10 + value % 10
    
    println(sum)
}
