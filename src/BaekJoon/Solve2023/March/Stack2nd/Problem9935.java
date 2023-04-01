package BaekJoon.Solve2023.March.Stack2nd;

import java.io.*;
import java.util.Arrays;

public class Problem9935 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        CustomStack stack = new CustomStack(bomb);

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        bw.write(stack.getValue());

        br.close();
        bw.close();
    }
}

class CustomStack {
    int idx = 0;
    char[] data = new char[1000000];
    char[] bomb = new char[36];
    int countdown = 0;
    int bombSize = 0;

    public CustomStack(String bstr) {
        for (int i = 0; i < bstr.length(); i++) {
            bomb[i] = bstr.charAt(i);
        }
        bombSize = bstr.length();
    }

    public void push(char value) {
        data[idx] = value;
        idx++;

        if (value == bomb[countdown]) {
            countdown++;
            if (bombSize == countdown) {
                bomb();
            }
        } else {
            if (value == bomb[0]) {
                countdown = 1;
            } else {
                countdown = 0;
            }
        }
    }
    public void bomb() {
        countdown = 0;
        idx -= bombSize;

        for (int i = bombSize - 1; i > 0; i--) {
            if (idx >= i) {
                boolean flag = true;

                for (int j = 0; j < i; j++) {
                    if (data[idx - i + j] != bomb[j]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    countdown = i;
                    break;
                }
            }
        }
    }
    public boolean isEmpty() {
        if (idx <= 0) {
            return true;
        } else {
            return false;
        }
    }
    public String getValue() {
        if (isEmpty()) {
            return "FRULA";
        } else {
            return new String(Arrays.copyOfRange(data, 0, idx));
        }
    }
}