package BaekJoon.Solve2024.July.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.StringTokenizer

class Problem1268 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val studentCnt = br.readLine().toInt()
        val classInfo = Array(studentCnt + 1){ Array(6){ 0 } }
        val sameClass = Array(studentCnt + 1){ Array(studentCnt + 1){ 0 } }
        for (i in 1..studentCnt) {
            val st = StringTokenizer(br.readLine())
            for (j in 1..5) {
                classInfo[i][j] = st.nextToken().toInt()
            }
        }

        for (i in 1..5) {
            for (j in 1..9) {
                val list = ArrayList<Int>()
                for (k in 1..studentCnt) {
                    if (classInfo[k][i] == j) list.add(k)
                }

                if (list.size > 1) {
                    for (a in list) {
                        for (b in list) {
                            if (a == b) continue
                            sameClass[a][b] = 1
                            sameClass[b][a] = 1
                        }
                    }
                }
            }
        }

        var max = 0
        var res = 1
        for (i in 1..studentCnt) {
            var tmp = 0
            for (j in 1..studentCnt) {
                if (i != j && sameClass[i][j] > 0) tmp++
            }

            if (tmp > max) {
                max = tmp
                res = i
            }
        }

        print(res)
    }
}