package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem30676 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ram = Integer.parseInt(br.readLine());
        if (ram >= 620) {
            System.out.print("Red");
        } else if (ram >= 590) {
            System.out.print("Orange");
        } else if (ram >= 570) {
            System.out.print("Yellow");
        } else if (ram >= 495) {
            System.out.print("Green");
        } else if (ram >= 450) {
            System.out.print("Blue");
        } else if (ram >= 425) {
            System.out.print("Indigo");
        } else if (ram >= 380) {
            System.out.print("Violet");
        }

        br.close();
    }
}
