package BaekJoon.Solve2024.August.BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem14912 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        var res = 0
        for (i in 1..n) {
            res += getDCount(i, d)
        }
        print(res)
    }

    fun getDCount(num: Int, d: Int): Int {
        var calc = num
        var res = 0
        while (calc > 0) {
            if (calc % 10 == d) res++
            calc /= 10
        }
        return res
    }
}