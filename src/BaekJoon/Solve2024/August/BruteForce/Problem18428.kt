package BaekJoon.Solve2024.August.BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

class Problem18428 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()

        val map = Array(n){ Array(n){ 'X' } }
        for (i in 0..<n) {
            val st = StringTokenizer(br.readLine())
            for (j in 0..<n) {
                map[i][j] = st.nextToken()[0]
            }
        }

        if (searchCase(map, 0)) print("YES")
        else print("NO")
    }

    fun searchCase(map: Array<Array<Char>>, depth: Int): Boolean {
        if (depth == 3) {
            return canHide(map)
        }

        val size = map.size
        for (i in 0..<size) {
            for (j in 0..<size) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O'
                    if (searchCase(map, depth + 1)) return true
                    map[i][j] = 'X'
                }
            }
        }

        return false
    }

    fun canHide(map: Array<Array<Char>>): Boolean {
        val size = map.size
        val students = LinkedList<Array<Int>>()
        for (i in 0..<size) {
            for (j in 0..<size) {
                if (map[i][j] == 'S') {
                    students.add(arrayOf(i, j))
                }
            }
        }

        val dx = arrayOf(-1, 0, 1, 0)
        val dy = arrayOf(0, 1, 0, -1)
        for (stu in students) {
            for (i in 0..3) {
                var nx = stu[0] + dx[i]
                var ny = stu[1] + dy[i]
                while (nx in 0..<size && ny in 0..<size) {
                    if (map[nx][ny] == 'T') return false
                    else if (map[nx][ny] == 'S' || map[nx][ny] == 'O') break
                    nx += dx[i]
                    ny += dy[i]
                }
            }
        }

        return true
    }
}