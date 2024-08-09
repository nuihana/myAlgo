package BaekJoon.Solve2024.August.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

class Problem14469 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()

        val pq = PriorityQueue<Array<Int>> { i1, i2 -> i1[0] - i2[0] }
        for (i in 1..n) {
            val st = StringTokenizer(br.readLine())

            pq.offer(arrayOf(st.nextToken().toInt(), st.nextToken().toInt()))
        }

        var endTime = 0
        while (!pq.isEmpty()) {
            val now = pq.poll()

            if (endTime > now[0]) {
                endTime += now[1]
            } else {
                endTime = now[0] + now[1]
            }
        }

        print(endTime)
    }
}