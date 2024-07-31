package BaekJoon.Solve2024.July.DynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

class Problem2688 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var t = br.readLine().toInt()
        val dp = Array(65){ Array(10){ BigInteger("0") } }
        while (t-- > 0) {
            val n = br.readLine().toInt()
            println(calc(n, dp))
        }
    }

    fun calc(len: Int, dp: Array<Array<BigInteger>>): BigInteger {
        var res = BigInteger("0")
        for (i in 0..9) {
            res = res.add(memoization(len, i, dp))
        }

        return res
    }

    fun memoization(len: Int, idx: Int, dp: Array<Array<BigInteger>>): BigInteger {
        if (len == 1) return BigInteger("1")

        if (len == 2) {
            val res = 10 - idx
            dp[len][idx] = BigInteger(res.toString())
            return dp[len][idx]
        }

        if (dp[len][idx] > BigInteger("0")) {
            return dp[len][idx]
        }

        var res = BigInteger("0")
        for (i in idx..9) {
            res = res.add(memoization(len - 1, i, dp))
        }

        dp[len][idx] = res
        return dp[len][idx]
    }
}