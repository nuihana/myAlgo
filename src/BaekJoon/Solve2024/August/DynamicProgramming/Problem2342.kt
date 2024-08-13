package BaekJoon.Solve2024.August.DynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem2342 {
    val cost = arrayOf(
        arrayOf(1, 2, 2, 2, 2),
        arrayOf(0, 1, 3, 4, 3),
        arrayOf(0, 3, 1, 3, 4),
        arrayOf(0, 4, 3, 1, 3),
        arrayOf(0, 3, 4, 3, 1)
    )

    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val list = ArrayList<Int>()
        while (true) {
            val n = st.nextToken().toInt()
            if (n == 0) break
            list.add(n)
        }

        val size = list.size
        val dp = Array(size){ Array(5){ Array(5){ 0 } } }
        print(search(0, 0, 0, size, dp, list))
    }

    fun search(idx: Int, l: Int, r: Int, size: Int, dp: Array<Array<Array<Int>>>, list: ArrayList<Int>): Int {
        if (idx == size) return 0
        if (dp[idx][l][r] != 0) return dp[idx][l][r]
        var next = list[idx]
        dp[idx][l][r] = Math.min(search(idx + 1, next, r, size, dp, list) + cost[l][next],
                                    search(idx + 1, l, next, size, dp, list) + cost[r][next])
        return dp[idx][l][r]
    }
}