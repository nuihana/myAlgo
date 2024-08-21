package BaekJoon.Solve2024.August.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem17825 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val dice = Array(10){ 0 }
        val piece = Array(10){ 0 }
        for (i in 0..< 10) {
            dice[i] = st.nextToken().toInt()
        }

        print(permutation(0, dice, piece))
    }

    fun permutation(idx: Int, dice: Array<Int>, piece: Array<Int>): Int {
        if (idx == 10) {
            return playGame(dice, piece)
        }

        var res = 0
        for (i in 0..3) {
            piece[idx] = i
            res = res.coerceAtLeast(permutation(idx + 1, dice, piece))
        }

        return res
    }

    fun playGame(dice: Array<Int>, piece: Array<Int>): Int {
        val map = arrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0,
                            10, 13, 16, 19, 25, 30, 35, 40, 0,
                            20, 22, 24, 25, 30, 35, 40, 0,
                            30, 28, 27, 26, 25, 30, 35, 40, 0)
        val isVisited = Array(map.size){ false }
        var score = 0
        val p = Array(4){ 0 }

        for (i in 0..9) {
            val nowDice = dice[i]
            val nowPiece = piece[i]
            if (isFinish(p[nowPiece])) return 0

            val next = nextPoint(p[nowPiece], nowDice)
            if (isFinish(next)) {
                setVisit(isVisited, p[nowPiece], false)
                p[nowPiece] = next
                continue
            }
            if (isVisited[next]) return 0
            setVisit(isVisited, p[nowPiece], false)
            setVisit(isVisited, next, true)

            p[nowPiece] = next
            score += map[p[nowPiece]]
        }

        return score
    }

    fun isFinish(idx: Int): Boolean {
        return idx == 21 || idx == 30 || idx == 38 || idx == 47
    }

    fun nextPoint(nowIdx: Int, dice: Int): Int {
        var nextIdx = nowIdx + dice

        if (nowIdx < 21) {
            if (nextIdx >= 21) nextIdx = 21
        } else if (nowIdx < 30) {
            if (nextIdx >= 30) nextIdx = 30
        } else if (nowIdx < 38) {
            if (nextIdx >= 38) nextIdx = 38
        } else if (nowIdx < 47) {
            if (nextIdx >= 47) nextIdx = 47
        }

        if (nextIdx == 5) return 22
        if (nextIdx == 10) return 31
        if (nextIdx == 15) return 39
        return nextIdx
    }

    fun setVisit(visited: Array<Boolean>, idx: Int, chk: Boolean) {
        if (idx == 20 || idx == 29 || idx == 37 || idx == 46) {
            visited[20] = chk
            visited[29] = chk
            visited[37] = chk
            visited[46] = chk
        } else if (idx == 26 || idx == 34 || idx == 43) {
            visited[26] = chk
            visited[34] = chk
            visited[43] = chk
        } else if (idx == 27 || idx == 35 || idx == 44) {
            visited[27] = chk
            visited[35] = chk
            visited[44] = chk
        } else if (idx == 28 || idx == 36 || idx == 45) {
            visited[28] = chk
            visited[36] = chk
            visited[45] = chk
        } else {
            visited[idx] = chk
        }
    }
}