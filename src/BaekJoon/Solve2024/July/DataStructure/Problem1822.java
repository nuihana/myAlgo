package BaekJoon.Solve2024.July.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Problem1822 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        int bCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < aCnt; i++) {
            aList.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bCnt; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> filteredList = aList.stream().filter((i) -> !bSet.contains(i)).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        if (filteredList.isEmpty()) {
            sb.append("0");
        } else {
            sb.append(filteredList.size()).append("\n");
            for (int val : filteredList) {
                sb.append(val).append(" ");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
