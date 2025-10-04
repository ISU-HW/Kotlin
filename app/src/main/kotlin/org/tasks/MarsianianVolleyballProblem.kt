package org.tasks

import kotlin.math.abs
import kotlin.math.max

object MarsianianVolleyballProblem : Task {
    override val name = "MarsianianVolleyball"

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

        val minimalRallies: (Int, Int, Int) -> Int = { targetScore, score1, score2 ->
            if ((score1 >= targetScore || score2 >= targetScore) && abs(score1 - score2) >= 2) {
                0
            } else {
                val team1ScoreNeeded = if (score1 >= targetScore) 0 else targetScore - score1
                val team1DiffNeeded = if (score1 - score2 >= 2) 0 else 2 - (score1 - score2)
                val team1Rallies = max(team1ScoreNeeded, team1DiffNeeded)
                val team2ScoreNeeded = if (score2 >= targetScore) 0 else targetScore - score2
                val team2DiffNeeded = if (score2 - score1 >= 2) 0 else 2 - (score2 - score1)
                val team2Rallies = max(team2ScoreNeeded, team2DiffNeeded)
                minOf(team1Rallies, team2Rallies)
            }
        }

        val result = minimalRallies(k, x, y)
        println(result)
    }
}
