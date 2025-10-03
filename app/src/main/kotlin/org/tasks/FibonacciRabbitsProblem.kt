package org.tasks

object FibonacciRabbitsProblem : Task {
    override val name = "Mortal Fibonacci Rabbits"

    override fun run() {
        println("Enter number of months and life duration (n m):")
        val input = readLine()?.trim()
        if (input.isNullOrEmpty()) {
            println("No input provided")
            return
        }
        val parts = input.split(Regex("\\s+")).mapNotNull { it.toIntOrNull() }
        if (parts.size != 2) {
            println("Expected two integers")
            return
        }
        val (n, m) = parts
        val result = mortalRabbits(n, m)
        println(result)
    }

    private fun mortalRabbits(n: Int, m: Int): Long {
        val rabbits = LongArray(m)
        rabbits[0] = 1L
        for (month in 2..n) {
            val newborn = rabbits.drop(1).sum()
            for (i in m - 1 downTo 1) {
                rabbits[i] = rabbits[i - 1]
            }
            rabbits[0] = newborn
        }
        return rabbits.sum()
    }
}
