package BaekJoon.Solve2024.August.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader

class Problem17615 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val arr = br.readLine().toCharArray()

        var redCnt = 0
        var blueCnt = 0
        for (i in 0..< n) {
            if (arr[i] == 'R') redCnt++
            if (arr[i] == 'B') blueCnt++
        }

        var res = n
        var sideBallCnt = 0
        // R을 왼쪽으로
        for (i in 0 ..< n) {
            if (arr[i] == 'R') sideBallCnt++
            else break
        }

        res = res.coerceAtMost(redCnt - sideBallCnt)
        sideBallCnt = 0
        // R을 오른쪽으로
        for (i in n - 1 downTo 0) {
            if (arr[i] == 'R') sideBallCnt++
            else break
        }

        res = res.coerceAtMost(redCnt - sideBallCnt)
        sideBallCnt = 0
        // B를 왼쪽으로
        for (i in 0 ..< n) {
            if (arr[i] == 'B') sideBallCnt++
            else break
        }

        res = res.coerceAtMost(blueCnt - sideBallCnt)
        sideBallCnt = 0
        // B를 오른쪽으로
        for (i in n - 1 downTo 0) {
            if (arr[i] == 'B') sideBallCnt++
            else break
        }

        res = res.coerceAtMost(blueCnt - sideBallCnt)

        print(res)
    }
}