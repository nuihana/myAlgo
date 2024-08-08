package BaekJoon.Solve2024.August.Math

import java.io.BufferedReader
import java.io.InputStreamReader

class Problem1448 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val len = ArrayList<Int>()
        for (i in 0..<n) {
            len.add(br.readLine().toInt())
        }
        len.sortDescending()

        var res = -1
        for (i in 0..<len.size - 2) {
            if (len[i] >= len[i + 1] + len[i + 2]) continue
            res = len[i] + len[i + 1] + len[i + 2]
            break
        }

        print(res)
    }
}