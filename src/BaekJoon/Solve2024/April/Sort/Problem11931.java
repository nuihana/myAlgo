package BaekJoon.Solve2024.April.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem11931 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCnt; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        list.sort(Comparator.reverseOrder());
        for (int i = 0; i < numCnt; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
