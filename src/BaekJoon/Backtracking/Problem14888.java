package BaekJoon.Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14888 {
    int[] valArr;
    int[] operArr = new int[4];
    int[] usedOperArr = new int[4];
    StringBuilder sb = new StringBuilder();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCnt = Integer.parseInt(br.readLine());
        valArr = new int[inputCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < inputCnt; i++) {
            valArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operArr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(getValue(0) + "\n");
        bw.write(Integer.toString(getValue(1)));

        br.close();
        bw.close();
    }

    private int getValue(int type) {
        int result;
        if (type == 0) { //최대값 구하기
            result = Integer.MIN_VALUE;
        } else { //최소값 구하기
            result = Integer.MAX_VALUE;
        }

        List<String> operCase = new ArrayList<>();
        getOperCase(operCase);

        for (int i = 0, iLimit = operCase.size(); i < iLimit; i++) {
            int tmp = valArr[0];
            String operOrder = operCase.get(i);

            for (int j = 0, jLimit = operOrder.length(); j < jLimit; j++) {
                String operator = operOrder.substring(j, j+1);

                if (operator.equals("0")) {
                    tmp = tmp + valArr[j + 1];
                } else if (operator.equals("1")) {
                    tmp = tmp - valArr[j + 1];
                } else if (operator.equals("2")) {
                    tmp = tmp * valArr[j + 1];
                } else if (operator.equals("3")) {
                    tmp = tmp / valArr[j + 1];
                }
            }

            if (type == 0) {
                if (tmp > result) {
                    result = tmp;
                }
            } else {
                if (tmp < result) {
                    result = tmp;
                }
            }
        }

        return result;
    }

    private void getOperCase(List<String> datas) {
        if (sb.length() == valArr.length - 1) {
            datas.add(sb.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 가용 가능 확인
            if (operArr[i] > usedOperArr[i]) {
                sb.append(i);
                usedOperArr[i]++;

                getOperCase(datas);

                sb.deleteCharAt(sb.length() - 1);
                usedOperArr[i]--;
            }
        }
    }
}
