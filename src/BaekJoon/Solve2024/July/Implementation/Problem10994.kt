package BaekJoon.Solve2024.July.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Problem10994 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val size = 1 + (n - 1) * 4
        val field = Array(size){ Array(size){ ' ' } }

        fill(n, 0, 0, field)
        val res = StringBuilder()
        for (i in 0..<size) {
            for (j in 0..<size) {
                res.append(field[i][j])
            }
            res.append("\n")
        }

        print(res.toString())
    }

    fun fill(n: Int, x: Int, y: Int, field: Array<Array<Char>>) {
        if (n == 1) {
            field[x][y] = '*'
            return
        }
        val size = 1 + (n - 1) * 4

        for (i in 0..<size) {
            field[y][x + i] = '*'
            field[y + i][x] = '*'
            field[y + size - 1][x + i] = '*'
            field[y + i][x + size - 1] = '*'
        }

        fill(n - 1, x + 2, y + 2, field)
    }
}