package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10801 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aDeck = new int[10];
        for (int i = 0; i < 10; i++) {
            aDeck[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] bDeck = new int[10];
        for (int i = 0; i < 10; i++) {
            bDeck[i] = Integer.parseInt(st.nextToken());
        }

        int aWin = 0, bWin = 0;
        for (int i = 0; i < 10; i++) {
            if (aDeck[i] > bDeck[i]) {
                aWin++;
            } else if (aDeck[i] < bDeck[i]) {
                bWin++;
            }
        }

        System.out.print(aWin > bWin ? "A" : aWin < bWin ? "B" : "D");

        br.close();
    }
}
