package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2526 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int t = n;
        List<Integer> list = new ArrayList<>();
        list.add(t);
        while (true) {
            if (list.contains(t * n % p)) {
                System.out.print(list.size() - list.indexOf(t * n % p));
                break;
            }
            list.add(t * n % p);
            t = t * n % p;
        }

        br.close();
    }
}
