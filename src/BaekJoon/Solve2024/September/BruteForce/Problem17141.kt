package BaekJoon.Solve2024.September.BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.LinkedList
import java.util.StringTokenizer

class Problem17141 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        val size = st.nextToken().toInt()
        val vCnt = st.nextToken().toInt()

        val map = Array(size){ Array(size){ 0 } }
        val virus = ArrayList<Array<Int>>()
        for (i in 0..< size) {
            st = StringTokenizer(br.readLine())
            for (j in 0..< size) {
                map[i][j] = st.nextToken().toInt()

                if (map[i][j] == 2) virus.add(arrayOf(i, j))
            }
        }

        var res: Int
        if (virus.size <= vCnt) {
            val isVisit = getIsVisit(map)
            val q = LinkedList<Array<Int>>()

            for (v in virus) {
                isVisit[v[0]][v[1]] = true
                q.offer(arrayOf(v[0], v[1], 0))
            }

            val dx = arrayOf(-1, 0, 1, 0)
            val dy = arrayOf(0, 1, 0, -1)
            var tmp = 0
            while (!q.isEmpty()) {
                val now = q.poll()
                tmp = tmp.coerceAtLeast(now[2])

                for (i in 0..3) {
                    val nx = now[0] + dx[i]
                    val ny = now[1] + dy[i]
                    if (nx < 0 || nx >= map.size || ny < 0 || ny >= map.size || isVisit[nx][ny]) continue
                    isVisit[nx][ny] = true
                    q.offer(arrayOf(nx, ny, now[2] + 1))
                }
            }

            if (isFull(isVisit)) {
                res = tmp
            } else {
                res = 2500
            }
        } else {
            val use = Array(vCnt){ -1 }
            res = searchCase(0, 0, use, virus, map)
        }
        print(if (res == 2500) -1 else res)
    }

    fun searchCase(depth: Int, start: Int, use: Array<Int>, virus: ArrayList<Array<Int>>, map: Array<Array<Int>>): Int {
        if (depth == use.size) {
            return calcTime(use, virus, map)
        }

        var res = 2500
        for (i in start..<virus.size) {
            use[depth] = i
            res = res.coerceAtMost(searchCase(depth + 1, i + 1, use, virus, map))
        }

        return res
    }

    fun calcTime(use: Array<Int>, virus: ArrayList<Array<Int>>, map: Array<Array<Int>>): Int {
        val isVisit = getIsVisit(map)
        val q = LinkedList<Array<Int>>()

        for (id in use) {
            val tmp = virus[id]
            isVisit[tmp[0]][tmp[1]] = true
            q.offer(arrayOf(tmp[0], tmp[1], 0))
        }

        val dx = arrayOf(-1, 0, 1, 0)
        val dy = arrayOf(0, 1, 0, -1)
        var res = 0
        while (!q.isEmpty()) {
            val now = q.poll()
            res = res.coerceAtLeast(now[2])

            for (i in 0..3) {
                val nx = now[0] + dx[i]
                val ny = now[1] + dy[i]
                if (nx < 0 || nx >= map.size || ny < 0 || ny >= map.size || isVisit[nx][ny]) continue
                isVisit[nx][ny] = true
                q.offer(arrayOf(nx, ny, now[2] + 1))
            }
        }

        if (isFull(isVisit)) {
            return res
        } else {
            return 2500
        }
    }

    fun getIsVisit(map: Array<Array<Int>>): Array<Array<Boolean>> {
        val res = Array(map.size){ Array(map.size){ false } }
        for (i in map.indices) {
            for (j in map.indices) {
                if (map[i][j] == 1) res[i][j] = true
            }
        }
        return res
    }

    fun isFull(visit: Array<Array<Boolean>>): Boolean {
        for (line in visit) {
            for (unit in line) {
                if (!unit) return false
            }
        }
        return true
    }
}