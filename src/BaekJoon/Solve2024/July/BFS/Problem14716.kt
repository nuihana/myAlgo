package BaekJoon.Solve2024.July.BFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

class Problem14716 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine())
        val height = st.nextToken().toInt()
        val width = st.nextToken().toInt()

        val field = Array(height){ Array(width){ 0 } }
        for (i in 0..<height) {
            st = StringTokenizer(br.readLine())
            for (j in 0..<width) {
                field[i][j] = st.nextToken().toInt()
            }
        }

        val isChk= Array(height){ Array(width){ false } }
        val q = LinkedList<Array<Int>>()
        var res = 0
        val dx = arrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
        val dy = arrayOf(0, 1, 1, 1, 0, -1, -1, -1)
        for (i in 0..<height) {
            for (j in 0..<width) {
                if (field[i][j] == 1 && !isChk[i][j]) {
                    q.offer(arrayOf(i, j))
                    isChk[i][j] = true
                    res++

                    while (!q.isEmpty()) {
                        val now = q.poll()

                        for (k in 0..7) {
                            val nx = now[0] + dx[k]
                            val ny = now[1] + dy[k]

                            if (nx < 0 || nx >= height || ny < 0 || ny >= width || field[nx][ny] == 0 || isChk[nx][ny]) continue
                            isChk[nx][ny] = true
                            q.offer(arrayOf(nx, ny))
                        }
                    }
                }
            }
        }

        print(res)
    }
}