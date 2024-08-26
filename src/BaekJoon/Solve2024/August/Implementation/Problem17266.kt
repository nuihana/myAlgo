package BaekJoon.Solve2024.August.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem17266 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val len = br.readLine().toInt()
        val barCnt = br.readLine().toInt()

        val st = StringTokenizer(br.readLine())
        val barIdx = ArrayList<Int>()
        barIdx.add(0)
        for (i in 1..barCnt) {
            val idx = st.nextToken().toInt()
            if (idx == 0 || idx == len) continue
            barIdx.add(idx)
        }
        barIdx.add(len)

        var res = 0
        for (i in 1..<barIdx.size) {
            if (i == 1 || i == barIdx.size - 1) {
                res = res.coerceAtLeast(barIdx[i] - barIdx[i - 1])
            } else {
                val term = barIdx[i] - barIdx[i - 1]
                res = res.coerceAtLeast(if (term % 2 == 0) term / 2 else term / 2 + 1)
            }
        }

        print(res)
    }
}