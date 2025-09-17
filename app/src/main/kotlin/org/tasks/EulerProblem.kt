package org.tasks

object EulerProblem : Task {
    override val name = "max period 1/d"

    override fun run() {
        fun periodLength(d: Int): Int {
            var n = d
            while (n % 2 == 0) n /= 2
            while (n % 5 == 0) n /= 5
            if (n == 1) return 0
            var k = 1
            var t = 10 % n
            while (t != 1) {
                t = (t * 10) % n
                k++
            }
            return k
        }

        var maxD = 0
        var maxLen = 0
        for (d in 3 until 1000) {
            val len = periodLength(d)
            if (len > maxLen) {
                maxLen = len
                maxD = d
            }
        }
        println("d = $maxD, period length = $maxLen")
    }
}
