package BaekJoon.Solve2024.July.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashMap
import java.util.LinkedList
import java.util.StringTokenizer

class Problem20922 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        val numCnt = st.nextToken().toInt()
        val max = st.nextToken().toInt()

        st = StringTokenizer(br.readLine())
        val q = LinkedList<Int>()
        val cnt = HashMap<Int, Int>()
        var res = 0
        for (i in 0..<numCnt) {
            val num = st.nextToken().toInt()

            if (!cnt.containsKey(num)) cnt[num] = 0
            cnt[num] = cnt[num]!! + 1
            q.offer(num)

            if (cnt[num]!! > max) {
                while (!q.isEmpty() && cnt[num]!! > max) {
                    val ex = q.poll()

                    cnt[ex] = cnt[ex]!! - 1
                }
            }

            res = res.coerceAtLeast(q.size)
        }

        print(res)
    }
}