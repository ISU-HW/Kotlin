package org.tasks

import kotlin.math.abs
import kotlin.math.max

object MarsianianVolleyballProblem : Task {
    override val name: String = "MarsianianVolleyball"

    override fun run() {
        println("Enter target score and two current scores (k x y):")
        val input = readLine()?.trim()
        if (input.isNullOrEmpty()) {
            println("No input provided")
            return
        }

        val parts = input.split(Regex("\\s+")).mapNotNull { it.toIntOrNull() }
        if (parts.size != 3) {
            println("Expected three integers")
            return
        }

        val (k, x, y) = parts
        val result = minimalRallies(k, x, y)
        println(result)
    }

    private fun minimalRallies(k: Int, x: Int, y: Int): Int {
        if ((x >= k || y >= k) && abs(x - y) >= 2) return 0

        val team1ScoreNeeded = if (x >= k) 0 else k - x
        val team1DiffNeeded = if (x - y >= 2) 0 else 2 - (x - y)
        val team1Rallies = max(team1ScoreNeeded, team1DiffNeeded)

        val team2ScoreNeeded = if (y >= k) 0 else k - y
        val team2DiffNeeded = if (y - x >= 2) 0 else 2 - (y - x)
        val team2Rallies = max(team2ScoreNeeded, team2DiffNeeded)

        return minOf(team1Rallies, team2Rallies)
    }
}
