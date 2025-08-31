package BaekJoon.Solve2025.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2997 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) list.add(Integer.parseInt(st.nextToken()));
        list.sort(Comparator.naturalOrder());

        int lf = list.get(1) - list.get(0);
        int rf = list.get(2) - list.get(1);
        if (lf == rf) {
            System.out.print(list.get(2) + rf);
        } else if (lf < rf) {
            System.out.print(list.get(1) + lf);
        } else {
            System.out.print(list.get(0) + rf);
        }

        br.close();
    }
}
