package BaekJoon.Solve2024.July.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

class Problem2564 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine())
        val width = st.nextToken().toInt()
        val height = st.nextToken().toInt()

        val pCnt = br.readLine().toInt()

        val map = Array(height + 1) { Array(width + 1) { 0 } }
        for (i in 0 ..< pCnt) {
            st = StringTokenizer(br.readLine())

            val side = st.nextToken().toInt()
            val idx = st.nextToken().toInt()

            if (side == 1) {
                map[0][idx] = 1
            } else if (side == 2) {
                map[height][idx] = 1
            } else if (side == 3) {
                map[idx][0] = 1
            } else if (side == 4) {
                map[idx][width] = 1
            }
        }

        st = StringTokenizer(br.readLine())

        val side = st.nextToken().toInt()
        val idx = st.nextToken().toInt()

        val q = LinkedList<Array<Int>>()
        val isVisited = Array(height + 1) { Array(width + 1) { false } }
        if (side == 1) {
            q.offer(arrayOf(0, idx, 0))
            isVisited[0][idx] = true
        } else if (side == 2) {
            q.offer(arrayOf(height, idx, 0))
            isVisited[height][idx] = true
        } else if (side == 3) {
            q.offer(arrayOf(idx, 0, 0))
            isVisited[idx][0] = true
        } else if (side == 4) {
            q.offer(arrayOf(idx, width, 0))
            isVisited[idx][width] = true
        }

        var res = 0
        val dx = arrayOf(-1, 0, 1, 0)
        val dy = arrayOf(0, 1, 0, -1)
        while (!q.isEmpty()) {
            val now = q.poll()

            for (i in 0 .. 3) {
                val nx = now[0] + dx[i]
                val ny = now[1] + dy[i]

                if (nx < 0 || nx > height || ny < 0 || ny > width || isVisited[nx][ny]) continue // 범위 초과
                if (nx in 1..<height && ny in 1 ..< width) continue
                if (map[nx][ny] > 0) res += now[2] + 1
                isVisited[nx][ny] = true
                q.offer(arrayOf(nx, ny, now[2] + 1))
            }
        }

        print(res)
    }
}