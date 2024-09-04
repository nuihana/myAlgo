package BaekJoon.Solve2024.September.Sort

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem16212 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val arr = Array(n){ 0 }
        val st = StringTokenizer(br.readLine())
        for (i in 0..< n) {
            arr[i] = st.nextToken().toInt()
        }

        arr.sort()
        val sb = StringBuilder()
        for (num in arr) {
            sb.append(num).append(" ")
        }
        print(sb.toString())
    }
}