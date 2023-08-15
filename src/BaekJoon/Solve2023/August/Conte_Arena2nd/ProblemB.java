package BaekJoon.Solve2023.August.Conte_Arena2nd;

import java.io.*;

public class ProblemB {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        int res = -1;
        if (first.replaceAll("[0-9]", "").equals("")) {
            res = Integer.parseInt(first) + 3;
        } else if (second.replaceAll("[0-9]", "").equals("")) {
            res = Integer.parseInt(second) + 2;
        } else {
            res = Integer.parseInt(third) + 1;
        }

        if (res % 3 == 0 && res % 5 == 0) {
            bw.write("FizzBuzz");
        } else if (res % 3 == 0) {
            bw.write("Fizz");
        } else if (res % 5 == 0) {
            bw.write("Buzz");
        } else {
            bw.write(String.valueOf(res));
        }

        br.close();
        bw.close();
    }
}
