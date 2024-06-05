package BaekJoon.Solve2024.June.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1063 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] king = convert(st.nextToken());
        int[] stone = convert(st.nextToken());
        int move = Integer.parseInt(st.nextToken());

        while (move-- > 0) {
            String query = br.readLine();

            int nx = -1, ny = -1;
            if (query.equals("R")) {
                nx = king[0];
                ny = king[1] + 1;
            } else if (query.equals("L")) {
                nx = king[0];
                ny = king[1] - 1;
            } else if (query.equals("B")) {
                nx = king[0] - 1;
                ny = king[1];
            } else if (query.equals("T")) {
                nx = king[0] + 1;
                ny = king[1];
            } else if (query.equals("RT")) {
                nx = king[0] + 1;
                ny = king[1] + 1;
            } else if (query.equals("LT")) {
                nx = king[0] + 1;
                ny = king[1] - 1;
            } else if (query.equals("RB")) {
                nx = king[0] - 1;
                ny = king[1] + 1;
            } else if (query.equals("LB")) {
                nx = king[0] - 1;
                ny = king[1] - 1;
            }

            if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;

            int[] tmp = new int[]{ nx, ny };

            if (stone[0] == nx && stone[1] == ny) {
                if (query.equals("R")) {
                    ny += 1;
                } else if (query.equals("L")) {
                    ny -= 1;
                } else if (query.equals("B")) {
                    nx -= 1;
                } else if (query.equals("T")) {
                    nx += 1;
                } else if (query.equals("RT")) {
                    nx += 1;
                    ny += 1;
                } else if (query.equals("LT")) {
                    nx += 1;
                    ny -= 1;
                } else if (query.equals("RB")) {
                    nx -= 1;
                    ny += 1;
                } else if (query.equals("LB")) {
                    nx -= 1;
                    ny -= 1;
                }

                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
                stone[0] = nx;
                stone[1] = ny;
            }

            king = tmp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char) (king[1] + 'A')).append(king[0] + 1).append("\n");
        sb.append((char) (stone[1] + 'A')).append(stone[0] + 1);
        System.out.print(sb);

        br.close();
    }

    private int[] convert(String src) {
        int[] res = new int[2];

        res[0] = src.charAt(1) - '1';
        res[1] = src.charAt(0) - 'A';

        return res;
    }
}
