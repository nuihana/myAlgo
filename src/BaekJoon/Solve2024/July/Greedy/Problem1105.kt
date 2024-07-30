package BaekJoon.Solve2024.July.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem1105 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val l = st.nextToken()
        val r = st.nextToken()

        if (l.length != r.length) {
            print(0)
        } else {
            var answer = 0
            var i = 0
            while (i < l.length && l[i] == r[i]) {
                if (l[i] == '8') answer++
                i++
            }

            print(answer)
        }
    }
}