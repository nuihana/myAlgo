package BaekJoon.Solve2023.April.TwoPointer;

import java.io.*;
import java.util.*;

public class Problem1450 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int volume = Integer.parseInt(st.nextToken());
        int[] numArr = new int[numCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int divide = numCnt / 2;
        int[] leftArr = Arrays.copyOfRange(numArr, 0, divide);
        int[] rightArr = Arrays.copyOfRange(numArr, divide, numCnt);

        List<Long> leftSumList = new ArrayList<>();
        leftSumList.add(0L);
        for (int i = 1; i <= leftArr.length; i++) {
            getSumCase(leftSumList, leftArr, i, 0, 0, 0);
        }
        Collections.sort(leftSumList);

        List<Long> rightSumList = new ArrayList<>();
        rightSumList.add(0L);
        for (int i = 1; i <= rightArr.length; i++) {
            getSumCase(rightSumList, rightArr, i, 0, 0, 0);
        }
        Collections.sort(rightSumList);

        int idx = 0;
        for (int i = 0; i < rightSumList.size(); i++) {
            if (rightSumList.get(i) <= volume) {
                idx = i;
            } else {
                break;
            }
        }

        int result = 0;
        for (int i = 0; i < leftSumList.size(); i++) {
            while(leftSumList.get(i) + rightSumList.get(idx) > volume && idx > 0) {
                idx--;
            }

            if (leftSumList.get(i) + rightSumList.get(idx) <= volume) {
                result += idx + 1;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private void getSumCase(List<Long> numList, int[] numArr, int size, int depth, long num, int start) {
        if (size == depth) {
            numList.add(num);
            return;
        }

        long tmp = num;
        for (int i = start; i < numArr.length; i++) {
            getSumCase(numList, numArr, size, depth + 1, tmp + numArr[i], i + 1);
        }
    }
}
