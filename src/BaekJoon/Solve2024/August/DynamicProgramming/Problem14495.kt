package BaekJoon.Solve2024.August.DynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader

class Problem14495 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val dp = Array(120){ 0L }
        dp[1] = 1
        dp[2] = 1
        dp[3] = 1

        print(fibonacci(n, dp))
    }

    fun fibonacci(n: Int, dp: Array<Long>): Long {
        if (dp[n] > 0) return dp[n]
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 3, dp)
        return dp[n]
    }
}