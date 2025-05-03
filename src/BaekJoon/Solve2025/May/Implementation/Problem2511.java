package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2511 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] b = new int[10];
        for (int i = 0; i < 10; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int aScore = 0;
        int bScore = 0;
        int lastWin = -1;
        for (int i = 0; i < 10; i++) {
            if (a[i] > b[i]) {
                aScore += 3;
                lastWin = 1;
            } else if (a[i] < b[i]) {
                bScore += 3;
                lastWin = 2;
            } else {
                aScore++;
                bScore++;
            }
        }

        System.out.println(aScore + " " + bScore);
        if (aScore == bScore) {
            if (lastWin == 1) {
                System.out.print("A");
            } else if (lastWin == 2) {
                System.out.print("B");
            } else {
                System.out.print("D");
            }
        } else {
            if (aScore > bScore) {
                System.out.print("A");
            } else {
                System.out.print("B");
            }
        }

        br.close();
    }
}
