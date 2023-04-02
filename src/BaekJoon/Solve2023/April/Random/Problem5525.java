package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem5525 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int len = Integer.parseInt(br.readLine());
        int strLen = Integer.parseInt(br.readLine());
        String str = br.readLine();

        FilteredQueue que = new FilteredQueue(len);
        int result = 0;
        for (int i = 0; i < strLen; i++) {
            result += que.add(str.charAt(i));
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    class FilteredQueue {
        int queSize = 0;
        int need;
        boolean flag;

        public FilteredQueue(int size) {
            need = size * 2 + 1;
            flag = true;
        }

        public int add(char ch) {
            if (ch == 'I' && flag) {
                queSize++;
                flag = !flag;
            } else if (ch == 'O' && !flag) {
                queSize++;
                flag = !flag;
            } else {
                init(ch);
            }

            if (achieve()) {
                return 1;
            } else {
                return 0;
            }
        }
        private void init(char ch) {
            if (ch == 'O') {
                queSize = 0;
                flag = true;
            } else if (ch == 'I') {
                queSize = 1;
                flag = false;
            }
        }
        private boolean achieve() {
            if (queSize == need) {
                queSize -= 2;
                return true;
            } else {
                return false;
            }
        }
    }
}
