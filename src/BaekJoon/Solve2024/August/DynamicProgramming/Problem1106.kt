package BaekJoon.Solve2024.August.DynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem1106 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val pur = st.nextToken().toInt()
        val cityCnt = st.nextToken().toInt()

        val dp = Array(100 + pur){ Int.MAX_VALUE }
        dp[0] = 0
        for (i in 1..cityCnt) {
            st = StringTokenizer(br.readLine())
            val cost = st.nextToken().toInt()
            val earn = st.nextToken().toInt()
            for (j in earn..<100 + pur) {
                if (dp[j - earn] != Int.MAX_VALUE) dp[j] = dp[j].coerceAtMost(cost + dp[j - earn])
            }
        }

        var res = Int.MAX_VALUE
        for (i in pur..<100 + pur) {
            res = res.coerceAtMost(dp[i])
        }
        print(res)
    }
}