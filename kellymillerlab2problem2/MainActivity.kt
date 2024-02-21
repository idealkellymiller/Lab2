package com.example.kellymillerlab2problem2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible

import com.example.kellymillerlab2problem2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val coffeeOrder = CoffeeOrderingApp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         val view = binding.root
        setContentView(view)

        binding.plusBtn.setOnClickListener {
            coffeeOrder.adjustQuantity(true)
            binding.quantityNum.text = coffeeOrder.quantity.toString()
        }

        binding.minusBtn.setOnClickListener {
            coffeeOrder.adjustQuantity(false)
            binding.quantityNum.text = coffeeOrder.quantity.toString()
        }

        binding.creamCheckbox.setOnClickListener {
            coffeeOrder.hasCream = binding.creamCheckbox.isChecked

        }

        binding.chocolateCheckbox.setOnClickListener {
            coffeeOrder.hasChocolate = binding.chocolateCheckbox.isChecked

        }

        binding.orderButton.setOnClickListener {
            val total: Double = coffeeOrder.calculateOrderPrice()
            val totalStr = "$" + String.format("%.2f", total)
            binding.priceTxt.text = getString(R.string.price_txt) + totalStr

            updateToppingSummaryView()

            binding.orderSummary.isVisible = true
        }
    }

    // updates the topping summaries
    private fun updateToppingSummaryView() {
        if (coffeeOrder.hasChocolate) {
            binding.chocSumTxt.text = getString(R.string.choc_sum_txt) + getString(R.string.yes)
        } else {
            binding.chocSumTxt.text = getString(R.string.choc_sum_txt) + getString(R.string.no)
        }

        if (coffeeOrder.hasCream) {
            binding.creamSumTxt.text = getString(R.string.cream_sum_txt) + getString(R.string.yes)
        } else {
            binding.creamSumTxt.text = getString(R.string.cream_sum_txt) + getString(R.string.no)
        }
    }
}