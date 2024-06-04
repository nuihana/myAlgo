package BaekJoon.Solve2024.June.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem5373 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int testCaseCnt = Integer.parseInt(br.readLine());
        while (testCaseCnt-- > 0) {
            int rotateCnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Cube cube = new Cube();
            while (st.hasMoreTokens()) {
                cube.rotate(st.nextToken());
            }
            sb.append(cube.printUp());
        }
        System.out.print(sb);

        br.close();
    }

    class Cube {
        String[] color = { "w", "r", "b", "o", "g", "y" };
        int[][][] surface; // 0: 위 w, 1: 앞 r, 2: 오른쪽 b, 3: 뒤 o, 4: 왼쪽 g, 5: 아래 y

        public Cube() {
            surface = new int[6][3][3];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    Arrays.fill(surface[i][j], i);
                }
            }
        }

        public String printUp() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(color[surface[0][j][2 - i]]);
                }
                sb.append("\n");
            }
            return sb.toString();
        }
        public void rotate(String order) {
            boolean flag = order.charAt(1) == '+';
            char direction = order.charAt(0);

            if (direction == 'U') {
                execute(0, 4, 1, 2, 3, flag);
            } else if (direction == 'D') {
                execute(5, 3, 2, 1, 4, flag);
            } else if (direction == 'F') {
                execute(1, 0, 4, 5, 2, flag);
            } else if (direction == 'B') {
                execute(3, 2, 5, 4, 0, flag);
            } else if (direction == 'L') {
                execute(4, 1, 0, 3, 5, flag);
            } else if (direction == 'R') {
                execute(2, 5, 3, 0, 1, flag);
            }
        }

        private void execute(int f, int u, int l, int d, int r, boolean clw) {
            int[][] tmp = new int[3][3];
            int[] tmp2 = new int[3];

            if (clw) {
                for (int i = 0; i < 3; ++i) // 돌리는 대상 면을 반시계방향으로 돌림
                    for (int j = 0; j < 3; ++j) {
                        tmp[i][j] = surface[f][2 - j][i];
                    }
                for (int i = 0; i < 3; ++i)
                    tmp2[i] = surface[u][i][0];
                for (int i = 0; i < 3; ++i)
                    surface[u][i][0] = surface[l][0][2 - i];
                for (int i = 0; i < 3; ++i)
                    surface[l][0][2 - i] = surface[d][2][i];
                for (int i = 0; i < 3; ++i)
                    surface[d][2][i] = surface[r][2 - i][2];
                for (int i = 0; i < 3; ++i)
                    surface[r][2 - i][2] = tmp2[i];
            } else {
                for (int i = 0; i < 3; ++i) // 돌리는 대상 면을 반시계방향으로 돌림
                    for (int j = 0; j < 3; ++j) {
                        tmp[i][j] = surface[f][j][2 - i];
                    }
                for (int i = 0; i < 3; ++i) // 돌아가는 면 기준 가장 앞에 있는 (u)를 백업한다.
                    tmp2[i] = surface[u][i][0];
                for (int i = 0; i < 3; ++i) //
                    surface[u][i][0] = surface[r][2 - i][2];
                for (int i = 0; i < 3; ++i)
                    surface[r][2 - i][2] = surface[d][2][i];
                for (int i = 0; i < 3; ++i)
                    surface[d][2][i] = surface[l][0][2 - i];
                for (int i = 0; i < 3; ++i)
                    surface[l][0][2 - i] = tmp2[i];
            }
            surface[f] = tmp;
        }
    }
}
