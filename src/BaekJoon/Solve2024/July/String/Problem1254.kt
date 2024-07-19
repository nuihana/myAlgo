package BaekJoon.Solve2024.July.String

import java.io.BufferedReader
import java.io.InputStreamReader

class Problem1254 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val str = br.readLine()

        var pivot = str.length / 2
        var isOdd = str.length % 2 != 0
        while (pivot < str.length) {
            var isPalindrome = false
            if (isOdd) {
                var l = pivot - 1
                var r = pivot + 1

                while (r < str.length) {
                    if (str[l] != str[r]) break
                    l--
                    r++
                }

                if (r == str.length) isPalindrome = true

                pivot++
            } else {
                var l = pivot - 1
                var r = pivot

                while (r < str.length) {
                    if (str[l] != str[r]) break
                    l--
                    r++
                }

                if (r == str.length) isPalindrome = true
            }

            isOdd = !isOdd
            if (isPalindrome) {
                val res = if (isOdd) pivot * 2 else pivot * 2 - 1
                print(res)
                break
            }
        }
    }
}