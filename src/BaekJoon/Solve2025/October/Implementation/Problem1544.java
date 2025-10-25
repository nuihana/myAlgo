package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1544 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            String tmp = list.get(i);
            for (int j = i + 1; j < n; j++) {
                if (tmp.length() == list.get(j).length()) {
                    String tmp2 = list.get(j) + list.get(j);
                    if (tmp2.contains(tmp)) {
                        list.remove(j);
                        n--;
                        j--;
                    }
                }
            }
        }
        System.out.print(n);

        br.close();
    }
}
