package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem2816 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int kbs1 = list.indexOf("KBS1");
        sb.append("1".repeat(kbs1)).append("4".repeat(kbs1));
        int kbs2 = list.indexOf("KBS2");
        if (kbs1 > kbs2) kbs2++;
        if (kbs2 > 1) {
            sb.append("1".repeat(kbs2)).append("4".repeat(kbs2 - 1));
        }
        System.out.print(sb);

        br.close();
    }
}
