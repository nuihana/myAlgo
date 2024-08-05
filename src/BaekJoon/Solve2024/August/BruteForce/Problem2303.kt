package BaekJoon.Solve2024.August.BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem2303 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        var winner = 0
        var winScore = 0
        for (i in 1..n) {
            val cards = Array(5){ 0 }
            val st = StringTokenizer(br.readLine())
            for (j in 0..4) {
                cards[j] = st.nextToken().toInt()
            }

            val score = score(cards)
            if (score > winScore) {
                winScore = score
                winner = i
            } else if (score == winScore) {
                winner = i
            }
        }

        print(winner)
    }

    fun score(cards: Array<Int>): Int {
        var res = 0
        for (i in 0..4) {
            var tmp = cards[i]
            for (j in i + 1..4) {
                tmp += cards[j]
                for (k in j + 1..4) {
                    tmp += cards[k]
                    res = res.coerceAtLeast(tmp % 10)
                    tmp -= cards[k]
                }
                tmp -= cards[j]
            }
        }

        return res
    }
}