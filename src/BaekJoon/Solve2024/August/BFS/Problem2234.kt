package BaekJoon.Solve2024.August.BFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import java.util.LinkedList
import java.util.StringTokenizer

class Problem2234 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine())
        val width = st.nextToken().toInt()
        val height = st.nextToken().toInt()

        val map = Array(height){ Array(width){ Block() } }
        for (i in 0..<height) {
            st = StringTokenizer(br.readLine())
            for (j in 0..<width) {
                map[i][j].init(st.nextToken().toInt(), i, j)
            }
        }

        val q = LinkedList<Block>()
        val isVisit = Array(height){ Array(width){ false } }
        val sizeMem = ArrayList<Int>()
        sizeMem.add(-1)
        var id = 0
        var max = 0
        for (i in 0..<height) {
            for (j in 0..<width) {
                if (!isVisit[i][j]) {
                    q.offer(map[i][j])
                    isVisit[i][j] = true
                    id++

                    var size = 0
                    while (!q.isEmpty()) {
                        val now = q.poll()

                        now.setID(id)
                        size++
                        for (k in 0..3) {
                            if (now.pass[k] == 0) {
                                var nx = -1
                                var ny = -1

                                when (k) {
                                    0 -> {
                                        nx = now.x - 1
                                        ny = now.y
                                    }
                                    1 -> {
                                        nx = now.x
                                        ny = now.y + 1
                                    }
                                    2 -> {
                                        nx = now.x + 1
                                        ny = now.y
                                    }
                                    3 -> {
                                        nx = now.x
                                        ny = now.y - 1
                                    }
                                }

                                if (nx < 0 || nx >= height || ny < 0 || ny >= width || isVisit[nx][ny]) continue
                                isVisit[nx][ny] = true
                                q.offer(map[nx][ny])
                            }
                        }
                    }

                    max = max.coerceAtLeast(size)
                    sizeMem.add(size)
                }
            }
        }

        val rel = Array(id + 1){ Array(id + 1){ 0 } }
        for (i in 0..<height) {
            for (j in 0..<width) {
                val now = map[i][j]

                for (k in 0..3) {
                    var nx = -1
                    var ny = -1

                    when (k) {
                        0 -> {
                            nx = now.x - 1
                            ny = now.y
                        }
                        1 -> {
                            nx = now.x
                            ny = now.y + 1
                        }
                        2 -> {
                            nx = now.x + 1
                            ny = now.y
                        }
                        3 -> {
                            nx = now.x
                            ny = now.y - 1
                        }
                    }

                    if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue
                    if (map[nx][ny].id != now.id) {
                        rel[now.id][map[nx][ny].id] = 1
                    }
                }
            }
        }

        var sumMax = 0
        for (i in 1..id) {
            for (j in 1..id) {
                if (i != j && rel[i][j] > 0) {
                    sumMax = sumMax.coerceAtLeast(sizeMem[i] + sizeMem[j])
                }
            }
        }

        println(id)
        println(max)
        print(sumMax)
    }

    class Block {
        var id = -1
        var x = -1
        var y = -1
        val pass = Array(4){ 0 } // 0: 북, 1: 동, 2: 남, 3: 서

        fun init(value: Int, i: Int, j: Int) {
            x = i
            y = j
            var tmp = value
            if (tmp >= 8) {
                pass[2] = 1
                tmp -= 8
            }
            if (tmp >= 4) {
                pass[1] = 1
                tmp -= 4
            }
            if (tmp >= 2) {
                pass[0] = 1
                tmp -= 2
            }
            if (tmp >= 1) {
                pass[3] = 1
            }
        }

        fun setID(id: Int) {
            this.id = id
        }
    }
}