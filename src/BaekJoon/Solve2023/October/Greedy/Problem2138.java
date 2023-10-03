package BaekJoon.Solve2023.October.Greedy;

import java.io.*;

public class Problem2138 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] src1 = br.readLine().toCharArray();
        char[] src2 = src1.clone();
        char[] dest = br.readLine().toCharArray();

        int pushCnt = 0;
        for (int i = 1; i < src1.length; i++) {
            if (src1[i - 1] == dest[i - 1]) continue;
            else {
                pushBtn(src1, i);
                pushCnt++;
            }
        }
        if (isSame(src1, dest)) {
            bw.write(String.valueOf(pushCnt));
            bw.close();
            return;
        }

        pushCnt = 1;
        pushBtn(src2, 0);
        for (int i = 1; i < src2.length; i++) {
            if (src2[i - 1] == dest[i - 1]) continue;
            else {
                pushBtn(src2, i);
                pushCnt++;
            }
        }
        if (isSame(src2, dest)) {
            bw.write(String.valueOf(pushCnt));
            bw.close();
            return;
        }

        bw.write("-1");

        br.close();
        bw.close();
    }

    private void pushBtn(char[] arr, int pos) {
        if (pos == 0) {
            arr[0] = arr[0] == '0' ? '1' : '0';
            arr[1] = arr[1] == '0' ? '1' : '0';
        } else if (pos == arr.length - 1) {
            arr[arr.length - 1] = arr[arr.length - 1] == '0' ? '1' : '0';
            arr[arr.length - 2] = arr[arr.length - 2] == '0' ? '1' : '0';
        } else {
            arr[pos - 1] = arr[pos - 1] == '0' ? '1' : '0';
            arr[pos] = arr[pos] == '0' ? '1' : '0';
            arr[pos + 1] = arr[pos + 1] == '0' ? '1' : '0';
        }
    }

    private boolean isSame(char[] src, char[] dest) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] != dest[i]) return false;
        }
        return true;
    }
}
