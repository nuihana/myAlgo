package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem16235 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int treeCnt = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        int[][] ground = new int[size][size];
        int[][] supply = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(ground[i], 5);
            for (int j = 0; j < size; j++) {
                supply[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> treeList = new ArrayList<>();
        for (int i = 0; i < treeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            treeList.add(new int[]{ x - 1, y - 1, year });
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        };
        treeList.sort(comparator);

        int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
        for (int i = 0; i < time; i++) {
            List<int[]> nextList = new ArrayList<>();
            List<int[]> tmpList = new ArrayList<>();
            //봄 : 나이 증가
            for (int[] tree : treeList) {
                if (ground[tree[0]][tree[1]] >= tree[2]) {
                    ground[tree[0]][tree[1]] -= tree[2];
                    tree[2]++;
                    nextList.add(tree);
                } else {
                    tmpList.add(tree);
                }
            }
            //여름 : 죽은 나무 양분
            for (int[] dead : tmpList) {
                ground[dead[0]][dead[1]] += dead[2] / 2;
            }
            tmpList.clear();
            //가을 : 번식
            for (int[] tree : nextList) {
                if (tree[2] % 5 == 0) {
                    for (int j = 0; j < 8; j++) {
                        int nx = tree[0] + dx[j];
                        int ny = tree[1] + dy[j];
                        if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                        tmpList.add(new int[]{ nx, ny, 1 });
                    }
                }
            }
            //겨울 : 땅에 양분 추가
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    ground[j][k] += supply[j][k];
                }
            }

            nextList.addAll(tmpList);
            nextList.sort(comparator);
            treeList = nextList;
        }

        System.out.print(treeList.size());

        br.close();
    }
}
