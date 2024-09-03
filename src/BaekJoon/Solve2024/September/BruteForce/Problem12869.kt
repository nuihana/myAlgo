package BaekJoon.Solve2024.September.BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import java.util.StringTokenizer

class Problem12869 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val scvCnt = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())

        val scvs = Array(3){ 0 }
        val isVisit = Array(61){ Array(61){ Array(61){ false } } }
        for (i in 0..< scvCnt) {
            scvs[i] = st.nextToken().toInt()
        }

        print(search(isVisit, 0, scvs[0], scvs[1], scvs[2]))
    }

    fun search(isVisit: Array<Array<Array<Boolean>>>, t: Int, a: Int, b: Int, c: Int): Int {
        if (a <= 0 && b <= 0 && c <= 0) return t

        var ta = a.coerceAtLeast(0)
        var tb = b.coerceAtLeast(0)
        var tc = c.coerceAtLeast(0)

        val max = ta.coerceAtLeast(tb).coerceAtLeast(tc)
        val min = ta.coerceAtMost(tb).coerceAtMost(tc)
        val mid = ta + tb + tc - max - min
        ta = max
        tb = mid
        tc = min

        if (isVisit[ta][tb][tc]) return 21
        else isVisit[ta][tb][tc] = true

        var res = 21
        res = res.coerceAtMost(search(isVisit, t + 1, ta - 9, tb - 3, tc - 1))
        res = res.coerceAtMost(search(isVisit, t + 1, ta - 9, tb - 1, tc - 3))
        res = res.coerceAtMost(search(isVisit, t + 1, ta - 3, tb - 9, tc - 1))
        res = res.coerceAtMost(search(isVisit, t + 1, ta - 3, tb - 1, tc - 9))
        res = res.coerceAtMost(search(isVisit, t + 1, ta - 1, tb - 9, tc - 3))
        res = res.coerceAtMost(search(isVisit, t + 1, ta - 1, tb - 3, tc - 9))

        return res
    }
}