package BaekJoon.Solve2024.August.Math

import java.io.BufferedReader
import java.io.InputStreamReader

class Problem3049 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val res = n * (n - 1) * (n - 2) * (n - 3) / 24
        print(res)
    }
}