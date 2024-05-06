package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem2331 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> numList = new ArrayList<>();
        int num = a;
        while (!numList.contains(num)) {
            numList.add(num);

            int next = 0;
            while (num > 0) {
                int tmp = 1;
                for (int i = 0; i < p; i++) tmp *= num % 10;

                next += tmp;
                num /= 10;
            }

            num = next;
        }

        System.out.print(numList.indexOf(num));

        br.close();
    }
}
