package BaekJoon.Solve2024.August.BFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

class Problem16173 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val size = br.readLine().toInt()
        val map = Array(size){ Array(size){ 0 } }
        for (i in 0..<size) {
            val st = StringTokenizer(br.readLine())
            for (j in 0..<size) {
                map[i][j] = st.nextToken().toInt()
            }
        }

        val q = LinkedList<Array<Int>>()
        q.offer(arrayOf(0, 0))
        var isReachable = false
        while (!q.isEmpty()) {
            val now = q.poll()
            if (map[now[0]][now[1]] == 0) continue
            if (map[now[0]][now[1]] == -1) {
                isReachable = true
                break
            }

            if (now[1] + map[now[0]][now[1]] < size) {
                q.offer(arrayOf(now[0], now[1] + map[now[0]][now[1]]))
            }

            if (now[0] + map[now[0]][now[1]] < size) {
                q.offer(arrayOf(now[0] + map[now[0]][now[1]], now[1]))
            }
        }

        if (isReachable) print("HaruHaru")
        else print("Hing")
    }
}