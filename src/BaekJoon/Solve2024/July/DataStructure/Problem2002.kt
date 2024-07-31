package BaekJoon.Solve2024.July.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashMap

class Problem2002 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val entMap = HashMap<String, Int>()
        for (i in 0..<n) {
            val id = br.readLine()
            entMap[id] = i
        }

        var res = 0
        val chk = Array(n){ false }
        for (i in 0..<n) {
            val id = br.readLine()

            val ord = entMap[id]!!
            var ok = false
            for (j in 0..<ord) {
                if (!chk[j]) ok = true
            }

            chk[ord] = true
            if (ok) res++
        }

        print(res)
    }
}