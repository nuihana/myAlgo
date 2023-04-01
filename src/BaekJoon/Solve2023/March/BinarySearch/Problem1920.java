package BaekJoon.Solve2023.March.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1920 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int valCnt = Integer.parseInt(br.readLine());
        int[] valArr = new int[valCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < valCnt; i++) {
            valArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(valArr);

        int questCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < questCnt; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (include(valArr, 0, valCnt - 1, target)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        br.close();
        bw.close();
    }

    private boolean include(int[] arr, int start, int end, int value) {
        int mid = (start + end) / 2;

        if (start > end) {
            return false;
        }

        if (arr[mid] == value) {
            return true;
        }

        if (arr[mid] > value) {
            return include(arr, start, mid - 1, value);
        } else {
            return include(arr, mid + 1, end, value);
        }
    }
}
