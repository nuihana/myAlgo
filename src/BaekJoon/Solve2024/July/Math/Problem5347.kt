package BaekJoon.Solve2024.July.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem5347 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val case = br.readLine().toInt()
        for (i in 0..<case) {
            val st = StringTokenizer(br.readLine())

            val a = st.nextToken().toLong()
            val b = st.nextToken().toLong()
            val gcd = if (a > b) GCD(a, b) else GCD(b, a)

            println(a * b / gcd)
        }
    }

    fun GCD(a: Long, b:Long):Long {
        if (a % b == 0L) return b
        return GCD(b, a % b)
    }
}