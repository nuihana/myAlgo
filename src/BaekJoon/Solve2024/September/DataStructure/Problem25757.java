package BaekJoon.Solve2024.September.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem25757 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int need = game.equalsIgnoreCase("Y") ? 1 : game.equalsIgnoreCase("F") ? 2 : 3;

        Set<String> wait = new HashSet<>();
        Set<String> already = new HashSet<>();
        Map<String, Integer> amount = new HashMap<>();
        int result = 0;
        while (n-- > 0) {
            String player = br.readLine();

            setPlayerWait(player, wait, already, amount);
            result += chkPlayable(need, wait, already, amount);
        }

        System.out.print(result);

        br.close();
    }

    private void setPlayerWait(String name, Set<String> wait, Set<String> already, Map<String, Integer> amount) {
        if (already.contains(name)) return;
        wait.add(name);
        amount.compute(name, (k, v) -> v == null ? 1 : v + 1);
    }

    private int chkPlayable(int need, Set<String> wait, Set<String> already, Map<String, Integer> amount) {
        if (wait.size() < need) return 0;

        for (String player : wait) {
            amount.put(player, amount.get(player) - 1);
            already.add(player);
        }
        wait.clear();

        return 1;
    }
}
