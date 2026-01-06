package BaekJoon.Solve2026.January.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem27964 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> cheeseSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String topping = st.nextToken();
            if (topping.endsWith("Cheese")) cheeseSet.add(topping);
        }

        if (cheeseSet.size() >= 4) {
            System.out.print("yummy");
        } else {
            System.out.print("sad");
        }

        br.close();
    }
}
