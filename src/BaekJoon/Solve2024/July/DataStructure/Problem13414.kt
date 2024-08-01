package BaekJoon.Solve2024.July.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.LinkedList
import java.util.StringTokenizer

class Problem13414 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        var limit = st.nextToken().toInt()
        val wait = st.nextToken().toInt()
        val q = LinkedList<String>()
        val m = HashMap<String, Int>()
        for (i in 0..<wait) {
            val student = br.readLine()

            q.offer(student)
            if (m[student] == null) m[student] = 1
            else m[student] = m[student]!! + 1
        }

        val sb = StringBuilder()
        while (!q.isEmpty() && limit > 0) {
            val now = q.poll()

            if (m[now]!! > 1) {
                m[now] = m[now]!! - 1
            } else {
                sb.append(now).append("\n")
                limit--
            }
        }

        print(sb.toString())
    }
}