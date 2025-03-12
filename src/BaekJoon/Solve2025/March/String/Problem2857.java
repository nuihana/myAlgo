package BaekJoon.Solve2025.March.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem2857 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String agent = br.readLine();

            if (agent.indexOf("FBI") >= 0) {
                res.add(i);
            }
        }

        if (res.isEmpty()) {
            System.out.print("HE GOT AWAY!");
        } else {
            for (int id : res) {
                System.out.print(id + " ");
            }
        }

        br.close();
    }
}
