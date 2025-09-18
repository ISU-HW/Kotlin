package org.tasks

import java.text.NumberFormat
import java.util.Locale

object FibonacciRabbitsProblem : Task {
    override val name: String = "Mortal Fibonacci Rabbits"

    fun run() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }

        val rabbits = LongArray(m)
        rabbits[0] = 1L

        for (month in 2..n) {
            val newborn = rabbits.drop(1).sum()
            for (i in m - 1 downTo 1) {
                rabbits[i] = rabbits[i - 1]
            }
            rabbits[0] = newborn
        }

        val result = rabbits.sum()
        val formatter = NumberFormat.getInstance(Locale.US)
        println(formatter.format(result))
    }

}
