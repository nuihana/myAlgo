package BaekJoon.Solve2024.July.BackTracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem16987 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val eggCnt = br.readLine().toInt()
        val eggs = Array(eggCnt){ Array(2){ 0 } }
        for (i in 0..<eggCnt) {
            val st = StringTokenizer(br.readLine())
            eggs[i][0] = st.nextToken().toInt()
            eggs[i][1] = st.nextToken().toInt()
        }

        print(maxBreakableCnt(eggs, 0, 0))
    }

    private fun maxBreakableCnt(eggs: Array<Array<Int>>, idx: Int, res: Int): Int {
        if (eggs.size == idx) return res
        if (eggs[idx][0] <= 0) return maxBreakableCnt(eggs, idx + 1, res)

        var max = res
        for (i in eggs.indices) {
            if (i == idx || eggs[i][0] <= 0) continue
            eggs[idx][0] -= eggs[i][1]
            eggs[i][0] -= eggs[idx][1]
            var broken = 0
            if (eggs[idx][0] <= 0) broken++
            if (eggs[i][0] <= 0) broken++
            max = max.coerceAtLeast(maxBreakableCnt(eggs.copyOf(), idx + 1, res + broken))
            eggs[idx][0] += eggs[i][1]
            eggs[i][0] += eggs[idx][1]
        }

        return max
    }
}