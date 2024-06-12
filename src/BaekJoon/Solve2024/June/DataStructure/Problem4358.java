package BaekJoon.Solve2024.June.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Problem4358 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        SortedMap<String, Integer> map = new TreeMap<>();
        while (true) {
            String tree = br.readLine();

            if (tree == null || tree.isEmpty()) break;
            if (map.get(tree) == null) map.put(tree, 0);
            map.put(tree, map.get(tree) + 1);
            total++;
        }

        StringBuilder sb = new StringBuilder();
        for (String tree : map.keySet()) {
            double rate = (double) map.get(tree) / total * 100;
            sb.append(tree).append(" ").append(String.format("%.4f", rate)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
