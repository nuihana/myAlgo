package BaekJoon.Solve2024.July.BFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

class Problem16948 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val size = br.readLine().toInt()
        var st = StringTokenizer(br.readLine())
        val sx = st.nextToken().toInt()
        val sy = st.nextToken().toInt()
        val ex = st.nextToken().toInt()
        val ey = st.nextToken().toInt()

        val isVisited: Array<Array<Boolean>> = Array(size){ Array(size){ false } }
        val q = LinkedList<Array<Int>>()
        q.offer(arrayOf(sx, sy, 0))
        isVisited[sx][sy] = true

        var res = -1
        val dx = arrayOf(-2, -2, 0, 0, 2, 2)
        val dy = arrayOf(-1, 1, -2, 2, -1, 1)
        while (!q.isEmpty()) {
            val now = q.poll()

            if (now[0] == ex && now[1] == ey) {
                res = now[2]
                break
            }

            for (i in 0..5) {
                var nx = now[0] + dx[i]
                var ny = now[1] + dy[i]
                if (nx < 0 || nx >= size || ny < 0 || ny >= size || isVisited[nx][ny]) continue
                isVisited[nx][ny] = true
                q.offer(arrayOf(nx, ny, now[2] + 1))
            }
        }

        print(res)
    }
}