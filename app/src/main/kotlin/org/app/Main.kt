package org.app

import org.tasks.*

fun main() {
    val tasks = listOf<Task>(EulerProblem, MarsianianVolleyballProblem)

    while (true) {
        println()
        println("Choose task (or press Enter to exit):")
        tasks.forEachIndexed { i, t -> println("${i + 1}. ${t.name}") }

        val input = readLine()?.trim()
        if (input.isNullOrEmpty()) {
            println("Goodbye!")
            return
        }

        val choice = input.toIntOrNull()
        if (choice != null && choice in 1..tasks.size) {
            tasks[choice - 1].run()
        } else {
            println("Incorrect")
        }
    }
}
