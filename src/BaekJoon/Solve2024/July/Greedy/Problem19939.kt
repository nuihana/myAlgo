package BaekJoon.Solve2024.July.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem19939 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        var n = st.nextToken().toInt()
        var k = st.nextToken().toInt()

        val min = if (k % 2 == 0) (k + 1) * (k / 2) else (k + 1) * (k / 2) + k / 2 + 1
        val res = if (n < min) -1 else if ((n - min) % k == 0) k - 1 else k

        print(res)
    }
}