package BaekJoon.Solve2024.July.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem2502 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val d = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        val sum = Array(d + 1){ 0 }
        sum[1] = 1
        sum[2] = 1

        val a = dp(sum, d - 2)
        val b = dp(sum, d - 1)

        var aRes = 1
        var bRes = 1

        while (true) {
            while (a * aRes + b * bRes < k && a * aRes + b * bRes != k) {
                bRes++
            }

            if (a * aRes + b * bRes == k) break
            aRes++
            bRes = 1
        }

        println(aRes)
        print(bRes)
    }

    fun dp(arr: Array<Int>, idx: Int): Int {
        if (arr[idx] > 0) return arr[idx]
        arr[idx] = dp(arr, idx - 1) + dp(arr, idx - 2)
        return arr[idx]
    }
}