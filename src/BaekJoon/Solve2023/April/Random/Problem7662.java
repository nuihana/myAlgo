package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem7662 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        DoublePriorityQueue que = new DoublePriorityQueue();
        for (int i = 0; i < caseCnt; i++) {
            int inputCnt = Integer.parseInt(br.readLine());
            que.clear();
            for (int j = 0; j < inputCnt; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    que.add(value);
                } else if (command.equals("D")) {
                    que.remove(value);
                }
            }
            bw.write(que.print());
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}

class DoublePriorityQueue {
    PriorityQueue<Integer> ascQue;
    PriorityQueue<Integer> descQue;
    Map<Integer, Integer> map;
    int size = 0;

    public DoublePriorityQueue() {
        ascQue = new PriorityQueue<>();
        descQue = new PriorityQueue<>(Collections.reverseOrder());
        map = new HashMap<>();
    }

    public void add(int val) {
        if (map.get(val) == null) {
            map.put(val, 1);
        } else {
            map.put(val, map.get(val) + 1);
        }

        ascQue.add(val);
        descQue.add(val);
        size++;
    }
    public void remove(int direction) {
        if (size > 0) {
            if (direction > 0) {
                int tmp = descQue.poll();
                while(map.get(tmp) == null || map.get(tmp) == 0 && !descQue.isEmpty()) {
                    tmp = descQue.poll();
                }

                map.put(tmp, map.get(tmp) - 1);
                size--;
            } else {
                int tmp = ascQue.poll();
                while(map.get(tmp) == null || map.get(tmp) == 0 && !ascQue.isEmpty()) {
                    tmp = ascQue.poll();
                }

                map.put(tmp, map.get(tmp) - 1);
                size--;
            }
        } else {
            ascQue = new PriorityQueue<>();
            descQue = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();
        }
    }
    public void clear() {
        ascQue = new PriorityQueue<>();
        descQue = new PriorityQueue<>(Collections.reverseOrder());
        map = new HashMap<>();
        size = 0;
    }
    public String print() {
        int maxId = descQue.peek();
        while(map.get(maxId) == null || map.get(maxId) == 0 && !descQue.isEmpty()) {
            maxId = descQue.poll();
        }

        int minId = ascQue.peek();
        while(map.get(minId) == null || map.get(minId) == 0 && !ascQue.isEmpty()) {
            minId = ascQue.poll();
        }

        return maxId + " " + minId;
    }
}