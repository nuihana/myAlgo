package BaekJoon.Solve2023.April.Tree;

import java.io.*;
import java.util.*;

public class Problem5639 {
    StringBuilder sb = new StringBuilder();
    List<Integer> preOrder = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        while(str != null && !str.equals("")) {
            int value = Integer.parseInt(str);
            preOrder.add(value);
            str = br.readLine();
        }

        getPostOrder(0, preOrder.size());
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private void getPostOrder(int from, int to) {
        //서브 리프가 없다면, 해당 값이 서브 루트
        if (from == to) {
            return;
        }

        //서브 루트 가능한 값 구하기
        int rootableIdx = -1;
        for (int i = from + 1, prev = preOrder.get(from); i < to; i++) {
            if (preOrder.get(i) > prev) {
                rootableIdx = i - 1;
                break;
            }

            prev = preOrder.get(i);
        }

        //증가값(서브 리프)이 없는 경우, 해당 루프의 모든 값은 서브 루트
        if (rootableIdx == -1) {
            for (int i = to - 1; i >= from; i--) {
                sb.append(preOrder.get(i) + "\n");
            }
        }

        //서브 루트별 서브 리프를 재귀하여 재탐색
        for (int i = rootableIdx, leafFromIdx = rootableIdx + 1, leafToIdx = rootableIdx + 1; i >= from; i--) {
            if (i == from) {
                getPostOrder(leafFromIdx, to);
                sb.append(preOrder.get(i) + "\n");
            } else {
                for (int j = leafFromIdx; j < to; j++) {
                    if (preOrder.get(j) > preOrder.get(i - 1)) {
                        break;
                    }
                    leafToIdx++;
                }

                getPostOrder(leafFromIdx, leafToIdx);
                sb.append(preOrder.get(i) + "\n");
            }
            leafFromIdx = leafToIdx;
        }
    }
}
