package BaekJoon.Solve2024.August.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow
import kotlin.math.sqrt

class Problem2417 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toLong()
        var l = 0L
        var r = n

        var res = 0L
        while (l <= r) {
            val mid = (l + r) / 2
            if (n <= mid.toDouble().pow(2.0)) {
                res = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        print(res)
    }
}