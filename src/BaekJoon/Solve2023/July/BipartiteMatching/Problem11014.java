package BaekJoon.Solve2023.July.BipartiteMatching;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11014 {
    List<List<Integer>> list;
    int[] idxArr;
    boolean[] done;
    final int[] di = {1, 1, 0, 0, -1, -1};
    final int[] dj = {-1, 1, -1, 1, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            int nodeCnt = 0;
            int[][] field = new int[height][width];
            for (int i = 0; i < height; i++) {
                String line = br.readLine();
                for (int j = 0; j < width; j++) {
                    char c = line.charAt(j);
                    if (c == 'x') field[i][j] = 1;
                    else nodeCnt++;
                }
            }

            list = new ArrayList<>();
            for (int i = 0; i <= width * height; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (field[i][j] == 1) continue;
                    for (int k = 0; k < 6; k++) {
                        int x = i + di[k];
                        int y = j + dj[k];
                        if (x < 0 || x >= height || y < 0 || y >= width) continue;
                        if (field[x][y] == 1) continue;
                        list.get(idx(i, j, width)).add(idx(x, y, width));
                    }
                }
            }

            int maxMatching = 0;
            idxArr = new int[width * height];
            Arrays.fill(idxArr, -1);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j += 2) {
                    if (field[i][j] == 1) continue;
                    done = new boolean[width * height];
                    if (dfs(idx(i, j, width))) maxMatching++;
                }
            }

            bw.write(String.valueOf(nodeCnt - maxMatching));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private boolean dfs(int n) {
        if (done[n]) return false;
        done[n] = true;

        for (int i : list.get(n)) {
            if (idxArr[i] == -1 || dfs(idxArr[i])) {
                idxArr[i] = n;
                return true;
            }
        }
        return false;
    }

    private int idx(int i, int j, int width) {
        return i * width + j;
    }
}
