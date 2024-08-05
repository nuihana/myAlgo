package BaekJoon.Solve2024.August.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

class Problem1256 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val aCnt = st.nextToken().toInt()
        val zCnt = st.nextToken().toInt()
        var ord = st.nextToken().toInt()

        val dp = Array(101){ Array(101){ 0 } }
        for (i in 1..100) {
            dp[i][0] = 1
            dp[0][i] = 1
        }

        for (i in 1..aCnt) {
            for (j in 1..zCnt) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                if (dp[i][j] > 1000000000) dp[i][j] = 1000000000
            }
        }

        if (ord > dp[aCnt][zCnt]) {
            print(-1)
            return
        }

        var a = aCnt
        var z = zCnt
        val res = StringBuilder()
        for (i in 0..<aCnt + zCnt) {
            if (a == 0) {
                res.append("z")
                z--
                continue
            } else if (z == 0) {
                res.append("a")
                a--
                continue
            }

            val tmp = dp[a - 1][z]
            if (ord <= tmp) {
                res.append("a")
                a--
            } else {
                ord -= tmp
                res.append("z")
                z--
            }
        }

        print(res.toString())
    }
}