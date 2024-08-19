package BaekJoon.Solve2024.August.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem2852 {
    fun solution() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val scoreList = ArrayList<Time>()
    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        val team = st.nextToken().toInt()
        val time = st.nextToken()

        scoreList.add(Time(time, team))
    }

    var one = Time("00:00", 1)
    var two = Time("00:00", 2)
    var win = 0
    var mem = Time("00:00", 0)
    for (score in scoreList) {
        if (win == 0) {
            mem.setTime(score.hour, score.second)
            mem.setTeam(score.t)
        }

        if (score.t == 1) {
            win++
        } else {
            win--
        }

        if (win == 0) {
            if (mem.t == 1) {
                one.addTime(mem, score)
            } else {
                two.addTime(mem, score)
            }
        }
    }

    if (win != 0) {
        if (mem.t == 1) {
            one.addTime(mem, Time("48:00", 0))
        } else {
            two.addTime(mem, Time("48:00", 0))
        }
    }

    println(one.toString())
    print(two.toString())
    }

class Time(src: String, team: Int) {
    var t = 0
    var hour = 0
    var second = 0

    init {
        t = team
        hour = src.substring(0, 2).toInt()
        second = src.substring(3, 5).toInt()
    }

    fun setTime(h: Int, s: Int) {
        hour = h
        second = s
    }
    fun setTeam(team: Int) {
        t = team
    }

    fun addTime(from: Time, to: Time) {
        var h = to.hour - from.hour
        var s = to.second - from.second

        hour += h
        second += s
        while (second < 0) {
            hour--
            second += 60
        }

        while (second >= 60) {
            hour++
            second -= 60
        }
    }

    fun adjustLen(v: Int): String {
        if (v < 10) return "0" + v
        return v.toString()
    }

    override fun toString(): String {
        return "${adjustLen(hour)}:${adjustLen(second)}"
    }
}
}