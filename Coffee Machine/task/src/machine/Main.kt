package machine

import kotlin.math.min

class CoffeeMachine(
    var water: Int,
    var milk: Int,
    var coffee: Int,
    var disposableCups: Int,
    var money: Int,
) {

    private fun fill() {
        print("Write how many ml of water do you want to add: ")
        water += readln().toInt()
        print("Write how many ml of milk do you want to add: ")
        milk += readln().toInt()
        print("Write how many grams of coffee beans do you want to add: ")
        coffee += readln().toInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        disposableCups += readln().toInt()
    }

    private fun takeMoney() {
        println("I gave you $$money")
        money = 0
    }

    private fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        println()
        val option = readln()
        if (option != "back") {
            if (min(min(water / WATER_ML, milk / MILK_ML), coffee / COFFEE_G) > 0) {
                println("I have enough resources, making you a coffee!")
                when (option.toInt()) {
                    1 -> {
                        water -= 250
                        coffee -= 16
                        money += 4
                    }
                    2 -> {
                        water -= 350
                        milk -= 75
                        coffee -= 20
                        money += 7
                    }
                    3 -> {
                        water -= 200
                        milk -= 100
                        coffee -= 12
                        money += 6
                    }
                }

                disposableCups -= 1

            } else {
                println("Sorry, not enough water!")
            }
        }
    }

    private fun printInfo() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffee g of coffee beans")
        println("$disposableCups disposable cups")
        println("$$money of money")
    }

    fun work() {
        var option: String
        do {

            print("Write action (buy, fill, take, remaining, exit): ")
            option = readln()
            when (option) {
                "fill" -> fill()
                "take" -> takeMoney()
                "buy" -> buy()
                "remaining" -> {
                    println()
                    printInfo()
                }
                else -> Unit
            }

        } while (option != "exit")
    }

}

fun buildCoffeeMachine(): CoffeeMachine =
    CoffeeMachine(water = 400, milk = 540, coffee = 120, disposableCups = 9, money = 550)

fun main() {

    val coffeeMachine = buildCoffeeMachine()

    coffeeMachine.work()

}

const val WATER_ML = 200
const val MILK_ML = 50
const val COFFEE_G = 15
