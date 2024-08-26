package BaekJoon.Solve2024.August.Graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem16562 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        val studentCnt = st.nextToken().toInt()
        val relationCnt = st.nextToken().toInt()
        val money = st.nextToken().toInt()

        st = StringTokenizer(br.readLine())
        val cost = Array(studentCnt + 1){ 0 }
        for (i in 1..studentCnt) {
            cost[i] = st.nextToken().toInt()
        }

        val union = Array(studentCnt + 1){ 0 }
        for (i in 1..studentCnt) {
            union[i] = i
        }

        for (i in 1..relationCnt) {
            st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()

            union(a, b, union, cost)
        }

        var minMoney = 0
        val visited = Array(studentCnt + 1){ false }
        for (i in 1..studentCnt) {
            val root = find(i, union)
            if (visited[root]) {
                visited[i] = true
                continue
            }
            minMoney += cost[root]
            visited[root] = true
            visited[i] = true
        }

        if (money < minMoney) print("Oh no")
        else print(minMoney)
    }

    fun find(a: Int, union: Array<Int>): Int {
        if (union[a] == a) return a
        return find(union[a], union)
    }

    fun union(a: Int, b: Int, union: Array<Int>, cost: Array<Int>) {
        val rootA = find(a, union)
        val rootB = find(b, union)
        if (rootA != rootB) {
            if (cost[rootA] < cost[rootB]) {
                union[rootB] = rootA
            } else {
                union[rootA] = rootB
            }
        }
    }
}