package BaekJoon.Solve2024.August.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem16165 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val groupCnt = st.nextToken().toInt()
        val queryCnt = st.nextToken().toInt()

        val memMap = HashMap<String, ArrayList<String>>()
        val groupMap = HashMap<String, String>()
        for (i in 0..<groupCnt) {
            val groupName = br.readLine()
            val memCnt = br.readLine().toInt()

            memMap[groupName] = ArrayList()
            for (j in 0..<memCnt) {
                val mem = br.readLine()
                groupMap.put(mem, groupName)
                memMap[groupName]?.add(mem)
            }
        }

        for (i in 0..queryCnt) {
            val query = br.readLine()
            val flag = br.readLine().toInt()
            if (flag == 0) {
                memMap[query]?.sort()
                for (mem in memMap[query]!!) {
                    println(mem)
                }
            } else {
                println(groupMap[query])
            }
        }
    }
}