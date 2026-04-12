package BaekJoon.Solve2026.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1722 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] v = new boolean[n + 1];
        long[] a = new long[n];
        a[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (st.nextToken().equals("1")) {
            long th = Long.parseLong(st.nextToken()) - 1;
            for(int i = n; i > 0; i--){
                long ith = th / a[i-1] + 1;
                th %= a[i-1];
                long count = 0;
                int index = 0;
                while (count != ith){
                    index++;
                    if(!v[index]) count++;
                }
                v[index] = true;
                sb.append(index).append(" ");
            }
        } else {
            long th = 1;
            for(int i = n; i > 0; i--){
                int data = Integer.parseInt(st.nextToken());
                int index = 0;
                int count = 0;
                while (index != data){
                    index++;
                    if(!v[index]) count++;
                }
                v[index] = true;
                th += (count-1) * a[i-1];
            }
            sb.append(th);
        }
        System.out.print(sb);

        br.close();
    }
}
