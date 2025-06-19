package BaekJoon.Solve2025.June.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem28691 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        if (src.equals("M")) {
            System.out.print("MatKor");
        } else if (src.equals("W")) {
            System.out.print("WiCys");
        } else if (src.equals("C")) {
            System.out.print("CyKor");
        } else if (src.equals("A")) {
            System.out.print("AlKor");
        } else if (src.equals("$")) {
            System.out.print("$clear");
        }

        br.close();
    }
}
