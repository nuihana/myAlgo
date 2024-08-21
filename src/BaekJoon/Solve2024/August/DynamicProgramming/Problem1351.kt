package BaekJoon.Solve2024.August.DynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem1351 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toLong()
        val p = st.nextToken().toInt()
        val q = st.nextToken().toInt()

        val map = HashMap<Long, Long>()
        map[0] = 1
        print(memoization(map, n, p, q))
    }

    fun memoization(map: HashMap<Long, Long>, idx: Long, p: Int, q: Int): Long {
        if (map.containsKey(idx)) return map[idx]!!
        val first = memoization(map, idx / p, p, q)
        val second = memoization(map, idx / q, p, q)
        map[idx] = first + second
        return map[idx]!!
    }
}