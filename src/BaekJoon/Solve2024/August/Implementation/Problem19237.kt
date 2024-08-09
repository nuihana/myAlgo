package BaekJoon.Solve2024.August.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Problem19237 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine())
        val mapSize = st.nextToken().toInt()
        val sharkCnt = st.nextToken().toInt()
        val term = st.nextToken().toInt()

        val res = Fishbowl(mapSize, term, sharkCnt)
        for (i in 0..<mapSize) {
            st = StringTokenizer(br.readLine())
            for (j in 0..<mapSize) {
                val id = st.nextToken().toInt()
                if (id > 0) {
                    res.init(i, j, id)
                }
            }
        }

        res.initDirection(br.readLine())
        for (i in 1..sharkCnt) {
            val instinct = Array(4) { Array(4) { 0 } }
            for (j in 0..3) {
                st = StringTokenizer(br.readLine())
                for (k in 0..3) {
                    instinct[j][k] = st.nextToken().toInt()
                }
            }

            res.initShark(i, instinct)
        }

        print(res.prove())
    }

    class Fishbowl(size: Int, default: Int, cnt: Int) {
        val data = Array(size) { Array(size) { Area() } }
        val sharks = Array(cnt + 1) { Shark() }
        val size_ = size
        val reft = default

        var inShark = cnt

        init {
            for (i in 1..cnt) {
                sharks[i].setID(i)
            }
        }

        fun init(x: Int, y: Int, i: Int) {
            data[x][y].initShark(i, reft, sharks[i])
        }

        fun initDirection(src: String) {
            val st = StringTokenizer(src)
            for (i in 1..<sharks.size) {
                sharks[i].setDir(st.nextToken().toInt())
            }
        }

        fun initShark(i: Int, arr: Array<Array<Int>>) {
            sharks[i].setIns(arr)
        }

        fun prove(): Int {
            var res = 0

            while (res <= 1000) {
                if (inShark == 1) break

                res++
                val planList = ArrayList<Plan>()
                for (i in 0..<size_) {
                    for (j in 0..<size_) {
                        val shark = data[i][j].getShark()
                        if (shark != null) {
                            var next = -1
                            //아무 냄새 없는 칸
                            for (d in shark.getInstinct()) {
                                when (d) {// 1: 위, 2: 아래, 3: 왼쪽, 4: 오른쪽
                                    1 -> {
                                        val nx = i - 1
                                        val ny = j

                                        if (nx < 0 || nx >= size_ || ny < 0 || ny >= size_) continue
                                        if (data[nx][ny].scent == 0) {
                                            next = d
                                            break
                                        }
                                    }

                                    2 -> {
                                        val nx = i + 1
                                        val ny = j

                                        if (nx < 0 || nx >= size_ || ny < 0 || ny >= size_) continue
                                        if (data[nx][ny].scent == 0) {
                                            next = d
                                            break
                                        }
                                    }

                                    3 -> {
                                        val nx = i
                                        val ny = j - 1

                                        if (nx < 0 || nx >= size_ || ny < 0 || ny >= size_) continue
                                        if (data[nx][ny].scent == 0) {
                                            next = d
                                            break
                                        }
                                    }

                                    4 -> {
                                        val nx = i
                                        val ny = j + 1

                                        if (nx < 0 || nx >= size_ || ny < 0 || ny >= size_) continue
                                        if (data[nx][ny].scent == 0) {
                                            next = d
                                            break
                                        }
                                    }
                                }
                            }
                            //자신의 냄새가 있는 칸
                            if (next == -1) {
                                for (d in shark.getInstinct()) {
                                    when (d) {// 1: 위, 2: 아래, 3: 왼쪽, 4: 오른쪽
                                        1 -> {
                                            val nx = i - 1
                                            val ny = j

                                            if (nx < 0 || nx >= size_ || ny < 0 || ny >= size_) continue
                                            if (data[nx][ny].scent == shark.id) {
                                                next = d
                                                break
                                            }
                                        }

                                        2 -> {
                                            val nx = i + 1
                                            val ny = j

                                            if (nx < 0 || nx >= size_ || ny < 0 || ny >= size_) continue
                                            if (data[nx][ny].scent == shark.id) {
                                                next = d
                                                break
                                            }
                                        }

                                        3 -> {
                                            val nx = i
                                            val ny = j - 1

                                            if (nx < 0 || nx >= size_ || ny < 0 || ny >= size_) continue
                                            if (data[nx][ny].scent == shark.id) {
                                                next = d
                                                break
                                            }
                                        }

                                        4 -> {
                                            val nx = i
                                            val ny = j + 1

                                            if (nx < 0 || nx >= size_ || ny < 0 || ny >= size_) continue
                                            if (data[nx][ny].scent == shark.id) {
                                                next = d
                                                break
                                            }
                                        }
                                    }
                                }
                            }

                            when (next) {// 1: 위, 2: 아래, 3: 왼쪽, 4: 오른쪽
                                1 -> {
                                    val nx = i - 1
                                    val ny = j

                                    shark.direction = 1
                                    planList.add(Plan(nx, ny, shark))
                                }

                                2 -> {
                                    val nx = i + 1
                                    val ny = j

                                    shark.direction = 2
                                    planList.add(Plan(nx, ny, shark))
                                }

                                3 -> {
                                    val nx = i
                                    val ny = j - 1

                                    shark.direction = 3
                                    planList.add(Plan(nx, ny, shark))
                                }

                                4 -> {
                                    val nx = i
                                    val ny = j + 1

                                    shark.direction = 4
                                    planList.add(Plan(nx, ny, shark))
                                }
                            }
                        }
                    }
                }

                for (plan in planList) {
                    data[plan.x][plan.y].addShark(plan.obj)
                }
                //같은 칸 상어 서열정리
                for (i in 0..<size_) {
                    for (j in 0..<size_) {
                        inShark -= data[i][j].removeShark()
                        data[i][j].spendTime()
                    }
                }
                //상어 냄새 세팅
                for (i in 0..<size_) {
                    for (j in 0..<size_) {
                        data[i][j].setSharkScent(reft)
                    }
                }
            }

            if (res > 1000) res = -1
            return res
        }
    }

    class Area {
        var scent = 0
        var time = 0
        val sharks = ArrayList<Shark>()

        fun initShark(i: Int, reft: Int, shark: Shark) {
            setScent(i, reft)
            sharks.add(shark)
        }

        fun setScent(i: Int, reft: Int) {
            scent = i
            time = reft
        }

        fun getShark(): Shark? {
            if (sharks.size > 0) {
                val res = sharks[0]
                sharks.clear()
                return res
            }
            return null
        }

        fun spendTime() {
            if (time > 0) {
                time--
            }

            if (time == 0) {
                scent = 0
            }
        }

        fun addShark(shark: Shark) {
            sharks.add(shark)
        }

        fun removeShark(): Int {
            if (sharks.size > 1) {
                var top = sharks[0]
                for (i in 1..<sharks.size) {
                    if (sharks[i].id < top.id) {
                        top = sharks[i]
                    }
                }

                val res = sharks.size - 1
                sharks.clear()
                sharks.add(top)

                return res
            } else {
                return 0
            }
        }

        fun setSharkScent(reft: Int) {
            if (sharks.size > 0) {
                setScent(sharks[0].id, reft)
            }
        }
    }

    class Shark() {
        var id = 0
        var direction = 0 // 1: 위, 2: 아래, 3: 왼쪽, 4: 오른쪽
        var instinct = Array(4) { Array(4) { 0 } }

        fun setID(i: Int) {
            id = i
        }

        fun setDir(d: Int) {
            direction = d
        }

        fun setIns(arr: Array<Array<Int>>) {
            instinct = arr
        }

        fun getInstinct(): Array<Int> {
            return instinct[direction - 1]
        }

        override fun toString(): String {
            return "Shark(id=$id, direction=$direction, instinct=\n${printIns()}\n)"
        }

        fun printIns(): String {
            val sb = StringBuilder()
            for (line in instinct) {
                for (item in line) {
                    sb.append(item).append(" ")
                }
                sb.append("\n")
            }
            return sb.toString()
        }
    }

    class Plan(x: Int, y: Int, obj: Shark) {
        val x = x
        val y = y
        val obj = obj
    }
}