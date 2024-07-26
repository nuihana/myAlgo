package BaekJoon.Solve2024.July.DynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem18353 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val soldiers = Array(n){ 0 }
        val st = StringTokenizer(br.readLine())
        for (i in 0..<n) {
            soldiers[i] = st.nextToken().toInt()
        }

        val dp = Array(n){ 1 }
        var res = 1;
        for (i in 1..<n) {
            for (j in 0..<i) {
                if (soldiers[j] > soldiers[i]) {
                    dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
                }
            }
            res = res.coerceAtLeast(dp[i])
        }

        print(n - res)
    }
}