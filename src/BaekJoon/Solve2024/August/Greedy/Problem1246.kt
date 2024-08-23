package BaekJoon.Solve2024.August.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem1246 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val eggCnt = st.nextToken().toInt()
        val clientCnt = st.nextToken().toInt()

        val clients = Array(clientCnt){ 0 }
        for (i in 0..<clientCnt) {
            clients[i] = br.readLine().toInt()
        }
        clients.sort()

        var maxCost = 0
        var maxBenefit = 0
        for (i in 0..<clientCnt) {
            val cost = clients[i]
            val benefit = cost * eggCnt.coerceAtMost(clientCnt - i)

            if (benefit > maxBenefit) {
                maxBenefit = benefit
                maxCost = cost
            }
        }

        print("$maxCost $maxBenefit")
    }
}