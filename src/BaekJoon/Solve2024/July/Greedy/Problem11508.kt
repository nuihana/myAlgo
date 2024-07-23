package BaekJoon.Solve2024.July.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

class Problem11508 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val pq = PriorityQueue<Int>{ o1, o2 -> o2 - o1 }
        for (i in 0..<n) {
            pq.offer(br.readLine().toInt())
        }

        var res = 0
        var idx = 0
        while (!pq.isEmpty()) {
            idx++
            val now = pq.poll()
            if (idx % 3 == 0) continue
            res += now
        }

        print(res)
    }
}