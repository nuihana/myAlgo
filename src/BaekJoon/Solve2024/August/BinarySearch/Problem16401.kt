package BaekJoon.Solve2024.August.BinarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem16401 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine())
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()

        var l = 0
        var r = 0
        val len = Array(n){ 0 }
        st = StringTokenizer(br.readLine())
        for (i in 0..<n) {
            len[i] = st.nextToken().toInt()
            r = r.coerceAtLeast(len[i])
        }

        var res = 0
        while (l <= r) {
            val value = (l + r) / 2

            if (isPossible(len, value, m)) {
                res = value
                l = value + 1
            } else {
                r = value - 1
            }
        }

        print(res)
    }

    fun isPossible(arr: Array<Int>, value: Int, pur: Int): Boolean {
        if (value == 0) return true

        var cnt = 0
        for (tmp in arr) {
            cnt += tmp / value
        }

        return cnt >= pur
    }
}