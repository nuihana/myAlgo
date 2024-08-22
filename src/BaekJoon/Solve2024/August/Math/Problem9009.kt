package BaekJoon.Solve2024.August.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Stack

class Problem9009 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var t = br.readLine().toInt()
        val sb = StringBuilder()
        val fbnc = fibonacci()
        while (t-- > 0) {
            var num = br.readLine().toInt()
            val stack = Stack<Int>()
            while (num > 0) {
                val piece = findCeil(fbnc, num)
                stack.push(piece)
                num -= piece
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ")
            }
            sb.append("\n")
        }
        print(sb.toString())
    }

    fun fibonacci(): ArrayList<Int> {
        val res = ArrayList<Int>()
        res.add(0)
        res.add(1)
        var i = 2
        while (true) {
            val now = res[i - 2] + res[i - 1]
            if (now >= 1000000000) break
            res.add(now)
            i++
        }
        return res
    }

    fun findCeil(fbnc: ArrayList<Int>, num: Int): Int {
        var l = 0
        var r = fbnc.size - 1

        var res = 0
        while (l <= r) {
            val mid = (l + r) / 2
            if (num >= fbnc[mid]) {
                res = fbnc[mid]
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return res
    }
}