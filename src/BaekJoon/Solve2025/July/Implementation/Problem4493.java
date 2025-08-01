package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4493 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int c = Integer.parseInt(br.readLine());

            int one = 0;
            int two = 0;
            while (c-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String l = st.nextToken();
                String r = st.nextToken();

                if (!l.equals(r)) {
                    if (l.equals("R")) {
                        if (r.equals("P")) {
                            two++;
                        } else if (r.equals("S")) {
                            one++;
                        }
                    } else if (l.equals("P")) {
                        if (r.equals("R")) {
                            one++;
                        } else if (r.equals("S")) {
                            two++;
                        }
                    } else if (l.equals("S")) {
                        if (r.equals("R")) {
                            two++;
                        } else if (r.equals("P")) {
                            one++;
                        }
                    }
                }
            }

            if (one > two) {
                sb.append("Player 1");
            } else if (one < two) {
                sb.append("Player 2");
            } else {
                sb.append("TIE");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
