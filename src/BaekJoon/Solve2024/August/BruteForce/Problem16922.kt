package BaekJoon.Solve2024.August.BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader

class Problem16922 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val set = HashSet<Int>()
        dfs(n, 0, set, 0)

        print(set.size)
    }

    fun dfs(depth: Int, num: Int, set: HashSet<Int>, idx: Int) {
        if (depth == 0) {
            set.add(num)
            return
        }
        val v = arrayOf(1, 5, 10, 50)
        for (i in idx..3) {
            dfs(depth - 1, num + v[i], set, i)
        }
    }
}