package BaekJoon.Solve2024.August.String

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Problem11655 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val src = br.readLine()
        val sb = StringBuilder()
        for (c in src) {
            var nc = c
            if (c >= 'a' && c <= 'z') {
                nc += 13
                if (nc > 'z') nc -= 26
            } else if (c >= 'A' && c <= 'Z') {
                nc += 13
                if (nc > 'Z') nc -= 26
            }
            sb.append(nc)
        }
        print(sb.toString())
    }
}