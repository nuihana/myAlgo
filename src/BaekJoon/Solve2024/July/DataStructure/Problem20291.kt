package BaekJoon.Solve2024.July.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashMap

class Problem20291 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val map = HashMap<String, Int?>()
        val n = br.readLine().toInt()
        for (i in 0..<n) {
            var file = br.readLine()

            file = file.substring(file.indexOf('.') + 1)

            if (!map.containsKey(file)) map[file] = 0
            map[file] = map[file]?.plus(1)
        }

        val list = map.keys.stream().sorted().toArray()
        for (key in list) {
            print(key)
            print(" ")
            println(map[key])
        }
    }
}