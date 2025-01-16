package BaekJoon.Solve2025.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15963 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String want = st.nextToken();
        String stock = st.nextToken();

        if (want.equals(stock)) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }

        br.close();
    }
}
