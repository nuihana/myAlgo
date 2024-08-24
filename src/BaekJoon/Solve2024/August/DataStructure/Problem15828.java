package BaekJoon.Solve2024.August.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem15828 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Queue<Integer> buffer = new LinkedList<>();
        while (true) {
            int info = Integer.parseInt(br.readLine());
            if (info == -1) break;

            if (info == 0) {
                buffer.poll();
            } else {
                if (buffer.size() < size) {
                    buffer.offer(info);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (buffer.isEmpty()) {
            sb.append("empty");
        } else {
            while (!buffer.isEmpty()) {
                sb.append(buffer.poll()).append(" ");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
