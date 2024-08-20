package BaekJoon.Solve2024.August.BFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

class Problem3187 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val r = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        val map = Array(r){ Array(c){ '.' } }
        for (i in 0..<r) {
            val line = br.readLine()
            for (j in 0..<c) {
                map[i][j] = line[j]
            }
        }

        val isVisit = Array(r){ Array(c){ false } }
        val q = LinkedList<Array<Int>>()
        val dx = arrayOf(-1, 0, 1, 0)
        val dy = arrayOf(0, 1, 0, -1)
        var vCnt = 0
        var kCnt = 0
        for (i in 0..<r) {
            for (j in 0..<c) {
                if (!isVisit[i][j] && map[i][j] != '#') {
                    q.offer(arrayOf(i, j))
                    isVisit[i][j] = true
                    var tmpV = 0
                    var tmpK = 0
                    while (!q.isEmpty()) {
                        val now = q.poll()
                        if (map[now[0]][now[1]] == 'v') tmpV++
                        if (map[now[0]][now[1]] == 'k') tmpK++

                        for (k in 0..3) {
                            val nx = now[0] + dx[k]
                            val ny = now[1] + dy[k]
                            if (nx < 0 || nx >= r || ny < 0 || ny >= c || isVisit[nx][ny] || map[nx][ny] == '#') continue
                            isVisit[nx][ny] = true
                            q.offer(arrayOf(nx, ny))
                        }
                    }

                    if (tmpK > tmpV) {
                        kCnt += tmpK
                    } else {
                        vCnt += tmpV
                    }
                }
            }
        }

        print("$kCnt $vCnt")
    }
}