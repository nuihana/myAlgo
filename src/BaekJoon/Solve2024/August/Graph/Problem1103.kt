package BaekJoon.Solve2024.August.Graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

class Problem1103 {
    var res = -1
    var isLoop = false
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val r = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        val map = Array(r){ Array(c){ 0 } }
        for (i in 0..<r) {
            val line = br.readLine()
            for (j in 0..<c) {
                if (line[j] == 'H') {
                    map[i][j] = -1
                } else {
                    map[i][j] = line[j] - '0'
                }
            }
        }

        val isVisit = Array(r){ Array(c){ false } }
        val dp = Array(r){ Array(c){ 0 } }
        isVisit[0][0] = true
        dfs(0, 0, r, c, 1, map, isVisit, dp)

        if (isLoop) print(-1)
        else print(res)
    }

    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)
    fun dfs(x: Int, y: Int, r: Int, c: Int, depth: Int, map: Array<Array<Int>>, isVisit: Array<Array<Boolean>>, dp: Array<Array<Int>>) {
        if (depth > res) res = depth
        dp[x][y] = depth

        for (i in 0..3) {
            val nx = x + dx[i] * map[x][y]
            val ny = y + dy[i] * map[x][y]
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == -1) continue

            if (isVisit[nx][ny]) {
                isLoop = true
                return
            }

            if (dp[nx][ny] > depth) continue

            isVisit[nx][ny] = true
            dfs(nx, ny, r, c, depth + 1, map, isVisit, dp)
            isVisit[nx][ny] = false
        }
    }
}