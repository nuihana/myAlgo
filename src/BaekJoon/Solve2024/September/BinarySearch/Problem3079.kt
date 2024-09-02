package BaekJoon.Solve2024.September.BinarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem3079 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val recCnt = st.nextToken().toInt()
        val total = st.nextToken().toInt()

        val time = Array(recCnt){ 0 }
        for (i in 0..<recCnt) {
            time[i] = br.readLine().toInt()
        }

        print(findMinTime(time, total))
    }

    fun findMinTime(time: Array<Int>, total: Int): Long {
        var l = 0L
        var r = 1000000000000000000

        var res = 0L
        while (l <= r) {
            val mid = (l + r) / 2
            if (isPossible(time, mid, total)) {
                res = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        return res
    }

    fun isPossible(time: Array<Int>, spend: Long, total: Int): Boolean {
        var suc = 0L
        for (t in time) {
            suc += spend / t
            if (suc >= total) return true
        }
        return suc >= total
    }
}