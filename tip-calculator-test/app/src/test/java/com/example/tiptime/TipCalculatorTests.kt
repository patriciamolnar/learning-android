package com.example.tiptime

import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.assertEquals

class TipCalculatorTests {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedAmount = NumberFormat.getCurrencyInstance().format(2.00)
        val actualAmount = calculateTip(amount, tipPercent, false)
        assertEquals(expectedAmount, actualAmount)
    }
}