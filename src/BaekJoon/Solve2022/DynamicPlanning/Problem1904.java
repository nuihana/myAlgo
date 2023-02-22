package BaekJoon.Solve2022.DynamicPlanning;

import java.io.*;

public class Problem1904 {
    int[] valArr = new int[1000001];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        valArr[0] = 0;
        valArr[1] = 1;
        valArr[2] = 2;

        for (int i = 3, iLimit = valArr.length; i < iLimit; i++) {
            valArr[i] = -1;
        }

        bw.write(Integer.toString(setValue(input)));

        br.close();
        bw.close();
    }

    private int setValue(int value) {
        if (valArr[value] == -1) {
            valArr[value] = (setValue(value - 1) + setValue(value - 2)) % 15746;
        }

        return valArr[value];
    }
}
