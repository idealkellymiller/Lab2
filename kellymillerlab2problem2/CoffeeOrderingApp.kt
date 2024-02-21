package com.example.kellymillerlab2problem2

const val COFFEE_BASE_PRICE: Double = 4.00
const val CREAM_PRICE: Double = 0.5
const val CHOC_PRICE: Double = 1.0

class CoffeeOrderingApp {
    var quantity: Int = 0
        set(value) {
            if (value < 0) {
                field = 0
            } else if (value > 10) {
                field = 10
            } else {
                field = value
            }
        }

    var hasCream = false
    var hasChocolate = false

    fun adjustQuantity(increasing: Boolean) {
        if (increasing) {
            quantity++
        } else {
            quantity--
        }
    }

    // calculates the order price based on the order's attributes
    fun calculateOrderPrice(): Double {
        var totalPrice: Double = COFFEE_BASE_PRICE

        if (quantity <= 0) {
            return 0.0
        }

        if (hasCream) {
            totalPrice += CREAM_PRICE
        }

        if (hasChocolate) {
            totalPrice += CHOC_PRICE
        }

        totalPrice *= quantity

        return totalPrice

    }

}