package BaekJoon.Solve2024.August.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal
import java.util.StringTokenizer

class Problem1405 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val actionCnt = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        val s = st.nextToken().toInt()
        val n = st.nextToken().toInt()

        val ord = Array(actionCnt){ -1 }
        val dirProbability = Array(4){ 0.0 }
        dirProbability[0] = e.toDouble() / 100
        dirProbability[1] = w.toDouble() / 100
        dirProbability[2] = s.toDouble() / 100
        dirProbability[3] = n.toDouble() / 100
        val isVisit = Array(29){ Array(29){ false } }

        print(BigDecimal(dfs(0, ord, dirProbability, isVisit, 14, 14)).toString())
    }

    fun dfs(depth: Int, ord: Array<Int>, prob: Array<Double>, isVisit: Array<Array<Boolean>>, x: Int, y: Int): Double {
        if (isVisit[x][y]) return 0.0
        if (depth == ord.size) {
            return getProbability(ord, prob)
        }

        var res = 0.0
        isVisit[x][y] = true
        for (i in 0..3) {
            ord[depth] = i
            if (i == 0) { // 동
                res += dfs(depth + 1, ord, prob, isVisit, x, y + 1)
            } else if (i == 1) { // 서
                res += dfs(depth + 1, ord, prob, isVisit, x, y - 1)
            } else if (i == 2) { // 남
                res += dfs(depth + 1, ord, prob, isVisit, x + 1, y)
            } else if (i == 3) { // 북
                res += dfs(depth + 1, ord, prob, isVisit, x - 1, y)
            }
        }
        isVisit[x][y] = false

        return res
    }

    fun getProbability(ord: Array<Int>, prob: Array<Double>): Double {
        var res = 1.0
        for (dir in ord) {
            res *= prob[dir]
        }
        return res
    }
}