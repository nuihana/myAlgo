package BaekJoon.Solve2024.August.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem5046 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine())
        val memCnt = st.nextToken().toInt()
        val money = st.nextToken().toInt()
        val hotelCnt = st.nextToken().toInt()
        val weekCnt = st.nextToken().toInt()

        val hotels = Array(hotelCnt){ Array(weekCnt + 1){ 0 } }
        for (i in 0..<hotelCnt) {
            hotels[i][0] = br.readLine().toInt()
            st = StringTokenizer(br.readLine())
            for (j in 1..weekCnt) {
                hotels[i][j] = st.nextToken().toInt()
            }
        }

        var minPrice = 500001
        for (hotel in hotels) {
            for (i in 1..weekCnt) {
                if (hotel[i] >= memCnt) {//인원 수용 가능
                    if (money >= hotel[0] * memCnt) {//예산 가능
                        minPrice = minPrice.coerceAtMost(hotel[0] * memCnt)
                    }
                }
            }
        }

        if (minPrice == 500001) {
            print("stay home")
        } else {
            print(minPrice)
        }
    }
}