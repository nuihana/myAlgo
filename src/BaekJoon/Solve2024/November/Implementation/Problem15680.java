package BaekJoon.Solve2024.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15680 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String flag = br.readLine();
        if ("0".equals(flag)) {
            System.out.print("YONSEI");
        } else if ("1".equals(flag)) {
            System.out.print("Leading the Way to the Future");
        }

        br.close();
    }
}
