package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14391 {
    int[][] paper;
    int height;
    int width;
    List<Bit> fragList;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        paper = new int[width][height];

        for (int i = 0; i < height; i++) {
            String str = br.readLine();
            for (int j = 0; j < width; j++) {
                paper[j][i] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        int maxLen = Math.max(height, width);
        int bitSize = height * width;
        fragList = new ArrayList<>();
        for (int i = maxLen; i > 0; i--) { // 길이가 긴 bit부터 추가
            if (i <= height) {
                for (int y = 0, yLimit = height - i + 1; y < yLimit; y++) {
                    for (int x = 0; x < width; x++) {
                        fragList.add(new Bit(x, y, i, bitSize)); // 세로 방향 bit
                    }
                }
            }

            if (i <= width && i > 1) {
                for (int x = 0, xLimit = width - i + 1; x < xLimit; x++) {
                    for (int y = 0; y < height; y++) {
                        fragList.add(new Bit(x, y, i * -1, bitSize)); // 가로 방향 bit
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < fragList.size(); i++) {
            result = Math.max(result, getMaximumCase(fragList.get(i), i));
        }

        bw.write(String.valueOf(result));

        getMaximumCase(fragList.get(0), 0);

        br.close();
        bw.close();
    }

    private int getMaximumCase(Bit bit, int start) {
        if (bit.isFilled()) {
            return bit.value;
        }

        int result = 0;
        for (int i = start + 1; i < fragList.size(); i++) {
            Bit tmp = new Bit(bit);
            if (tmp.isDupled(fragList.get(i))) {
                tmp.add(fragList.get(i));
                result = Math.max(result, getMaximumCase(tmp, i));
            }
        }

        return result;
    }

    class Bit {
        boolean[] mask;
        int value;

        public Bit(int startX, int startY, int length, int bitSize) {
            mask = new boolean[bitSize];
            value = 0;
            if (length > 0) { // length가 양수면 bit는 y 방향
                int idx = startX + startY * width;
                while (length > 0) {
                    mask[idx] = true;
                    value += paper[startX][startY] * Math.pow(10, length - 1);
                    startY++;
                    idx += width;
                    length--;
                }
            } else { // length가 음수면 bit는 x 방향
                int idx = startX + startY * width;
                while (length < 0) {
                    mask[idx] = true;
                    value += paper[startX][startY] * Math.pow(10, Math.abs(length) - 1);
                    startX++;
                    idx++;
                    length++;
                }
            }
        }
        public Bit(Bit copy) {
            value = copy.value;
            mask = new boolean[copy.mask.length];
            System.arraycopy(copy.mask, 0, mask, 0, copy.mask.length);
        }

        public boolean isDupled(Bit another) {
            for (int i = 0; i < mask.length; i++) {
                if (mask[i] && another.mask[i]) {
                    return false;
                }
            }
            return true;
        }
        public boolean isFilled() {
            for (int i = 0; i < mask.length; i++) {
                if (!mask[i]) {
                    return false;
                }
            }
            return true;
        }
        public void add(Bit another) {
            value += another.value;
            for (int i = 0; i < mask.length; i++) {
                if (another.mask[i]) {
                    mask[i] = true;
                }
            }
        }
    }
}
