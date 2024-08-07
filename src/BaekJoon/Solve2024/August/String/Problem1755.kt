package BaekJoon.Solve2024.August.String

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem1755 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()

        val res = ArrayList<Data>()
        for (i in from..to) {
            res.add(Data(i))
        }
        res.sortBy { T -> T.strVal }

        val sb = StringBuilder()
        for (i in 0..<res.size) {
            sb.append(res[i].intVal).append(" ")
            if (i % 10 == 9) sb.append("\n")
        }

        print(sb.toString())
    }

    class Data(value: Int) {
        val map = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var intVal = -1
        var strVal = ""
        init {
            intVal = value
            if (value >= 10) {
                strVal = map[value / 10]
            }
            strVal += map[value % 10]
        }
    }
}