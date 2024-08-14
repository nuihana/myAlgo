package BaekJoon.Solve2024.August.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.ceil
import kotlin.math.sqrt

class Problem11689 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var n = br.readLine().toLong()
        val x = (ceil(sqrt(n.toDouble())) + 1).toInt()

        var phi = n
        for (i in 2..<x) {
            if (n % i == 0L) phi = phi / i * (i - 1)
            while (n % i == 0L) {
                n /= i
            }
        }

        if (n != 1L) phi = phi / n * (n - 1)
        print(phi)
    }
}