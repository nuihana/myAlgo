package BaekJoon.Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14889 {
    int[][] valArr;
    boolean[] isVisited;
    int result = Integer.MAX_VALUE;;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCnt = Integer.parseInt(br.readLine());
        valArr = new int[inputCnt][inputCnt];
        isVisited = new boolean[inputCnt];

        for (int i = 0; i < inputCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < inputCnt; j++) {
                valArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getCase(0, 0);
        System.out.println(result);

        br.close();
    }

    private void getCase(int idx, int count) {
        int size = valArr.length;

        if (count == size / 2) {
            getDifference();
            return;
        }

        for (int i = idx; i < size; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                getCase(i + 1, count + 1);
                isVisited[i] = false;
            }
        }
    }

    private void getDifference() {
        int startPower = 0;
        int linkPower = 0;
        int size = valArr.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (isVisited[i] == true && isVisited[j] == true) {
                    startPower += valArr[i][j];
                    startPower += valArr[j][i];
                } else if (isVisited[i] == false && isVisited[j] == false) {
                    linkPower += valArr[i][j];
                    linkPower += valArr[j][i];
                }
            }
        }

        int diff = Math.abs(startPower - linkPower);

        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }

        result = Math.min(diff, result);
    }
}
