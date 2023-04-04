package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11723 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        JduSet set = new JduSet();
        for (int i = 0; i < commandCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int value = Integer.parseInt(st.nextToken());
                set.add(value);
            } else if (command.equals("remove")) {
                int value = Integer.parseInt(st.nextToken());
                set.remove(value);
            } else if (command.equals("check")) {
                int value = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf(set.check(value)));
                bw.newLine();
            } else if (command.equals("toggle")) {
                int value = Integer.parseInt(st.nextToken());
                set.toggle(value);
            } else if (command.equals("all")) {
                set.all();
            } else if (command.equals("empty")) {
                set.empty();
            }
        }

        br.close();
        bw.close();
    }
}

class JduSet {
    int[] set = new int[21];

    public void add(int val) {
        set[val] = 1;
    }
    public void remove(int val) {
        set[val] = 0;
    }
    public int check(int val) {
        return set[val];
    }
    public void toggle(int val) {
        set[val] = set[val] > 0 ? 0 : 1;
    }
    public void all() {
        for (int i = 1; i <= 20; i++) {
            set[i] = 1;
        }
    }
    public void empty() {
        for (int i = 1; i <= 20; i++) {
            set[i] = 0;
        }
    }
}