package BaekJoon.Solve2025.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14581 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String id = br.readLine();
        String imo = ":fan:";
        System.out.println(imo.repeat(3));
        System.out.println(imo.concat(":").concat(id).concat(":").concat(imo));
        System.out.print(imo.repeat(3));

        br.close();
    }
}
