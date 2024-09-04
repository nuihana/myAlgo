package BaekJoon.Solve2024.September.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1007 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = pint(br.readLine());
        for (int test = 1; test <= tc; test++) {
            N = pint(br.readLine());
            isC=new boolean[N];
            point= new int[N][2];
            int sumx=0,sumy=0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                point[i][0]=pint(st.nextToken());
                point[i][1]= pint(st.nextToken());
                sumx+=point[i][0];
                sumy+=point[i][1];
            }

            ans=Double.MAX_VALUE;
            rec(0,0, sumx, sumy);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    double ans;
    int N;
    boolean[] isC;
    int[][]point;

    void rec(int cnt, int prev, int x, int y) {
        if(cnt==N/2) {
            ans = Math.min(ans, Math.sqrt((double)x*x + (double)y*y) );
            return;
        }
        for (int i = prev; i < N; i++)
            rec(cnt+1, i+1, x-2*point[i][0], y-2*point[i][1]);
    }

    int pint(String s) {
        return Integer.parseInt(s);
    }
}
