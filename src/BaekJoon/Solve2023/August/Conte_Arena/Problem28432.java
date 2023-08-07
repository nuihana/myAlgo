package BaekJoon.Solve2023.August.Conte_Arena;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem28432 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        int idx = -1;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("?")) {
                idx = i;
            }
            list.add(str);
        }

        int m = Integer.parseInt(br.readLine());
        List<String> endList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            endList.add(br.readLine());
        }

        char start, end;
        if (n == 1) {
            bw.write(endList.get(0));
        } else if (idx == 0) {
            end = list.get(idx + 1).charAt(0);

            for (String str : endList) {
                if (isEnd(str, end) && !list.contains(str)) {
                    bw.write(str);
                    break;
                }
            }
        } else if (idx == n - 1) {
            start = list.get(idx - 1).charAt(list.get(idx - 1).length() - 1);

            for (String str : endList) {
                if (isStart(str, start) && !list.contains(str)) {
                    bw.write(str);
                    break;
                }
            }
        } else {
            start = list.get(idx - 1).charAt(list.get(idx - 1).length() - 1);
            end = list.get(idx + 1).charAt(0);

            for (String str : endList) {
                if (isStart(str, start) && isEnd(str, end) && !list.contains(str)) {
                    bw.write(str);
                    break;
                }
            }
        }

        br.close();
        bw.close();
    }

    private boolean isStart(String str, char c) {
        if (str.charAt(0) == c) return true;
        return false;
    }

    private boolean isEnd(String str, char c) {
        if (str.charAt(str.length() - 1) == c) return true;
        return false;
    }
}
