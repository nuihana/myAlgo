package BaekJoon.Solve2024.July.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

class Problem2841 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine())

        var n = st.nextToken().toInt()
        val p = st.nextToken().toInt()

        var rel = 0
        val guitar = Array(7){ Stack<Int>() }
        for (i in 0..<n) {
            st = StringTokenizer(br.readLine())

            val id = st.nextToken().toInt()
            val pret = st.nextToken().toInt()

            while (guitar[id].isNotEmpty() && guitar[id].peek() > pret) {
                guitar[id].pop()
                rel++
            }

            if (guitar[id].isNotEmpty() && guitar[id].peek() == pret) {
                rel--
            } else {
                guitar[id].push(pret)
            }
        }

        print(n + rel)
    }
}