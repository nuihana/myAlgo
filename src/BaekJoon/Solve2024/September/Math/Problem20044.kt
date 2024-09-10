package BaekJoon.Solve2024.September.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem20044 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val cnt = br.readLine().toInt() * 2
        val arr = Array(cnt){ 0 }
        val st = StringTokenizer(br.readLine())
        for (i in 0..< cnt) {
            arr[i] = st.nextToken().toInt()
        }

        arr.sort()
        var res = Int.MAX_VALUE
        for (i in 0..< cnt / 2) {
            val power = arr[i] + arr[cnt - 1 - i]
            res = res.coerceAtMost(power)
        }

        print(res)
    }
}