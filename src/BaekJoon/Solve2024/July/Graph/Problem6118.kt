package BaekJoon.Solve2024.July.Graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import java.util.PriorityQueue
import java.util.StringTokenizer

class Problem6118 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine())
        val nodeCnt = st.nextToken().toInt()
        val edgeCnt = st.nextToken().toInt()

        val ways = Array(nodeCnt + 1){ ArrayList<Int>() }
        for (i in 0..< edgeCnt) {
            st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()

            ways[a].add(b)
            ways[b].add(a)
        }

        val dist = Array(nodeCnt + 1){ 50001 }
        val q = PriorityQueue<Array<Int>>{ i1, i2 -> i1[1] - i2[1] }
        q.offer(arrayOf(1, 0))
        dist[1] = 0
        while (!q.isEmpty()) {
            val now = q.poll()

            for (next in ways[now[0]]) {
                if (dist[next] > now[1] + 1) {
                    dist[next] = now[1] + 1
                    q.offer(arrayOf(next, now[1] + 1))
                }
            }
        }

        val res = ArrayList<Int>()
        var max = 0
        for (i in 1..nodeCnt) {
            if (max < dist[i]) {
                res.clear()
                res.add(i)
                max = dist[i]
            } else if (max == dist[i]) {
                res.add(i)
            }
        }

        print("${res[0]} $max ${res.size}")
    }
}