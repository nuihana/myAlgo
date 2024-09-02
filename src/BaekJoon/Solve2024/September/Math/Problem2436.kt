package BaekJoon.Solve2024.September.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem2436 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val gcd = st.nextToken().toInt()
        val lcm = st.nextToken().toInt()

        val tmp = lcm / gcd

        var resA = 0L
        var resB = 0L
        var i = 1
        while (i * i <= tmp) {
            if (tmp % i == 0) {
                val a = i
                val b = tmp / i
                if (GCD(a, b) == 1) {
                    resA = (a * gcd).toLong()
                    resB = (b * gcd).toLong()
                }
            }
            i++
        }

        print("$resA $resB")
    }

    fun GCD(a: Int, b: Int): Int {
        if (a % b == 0) return b
        else return GCD(b, a % b)
    }
}