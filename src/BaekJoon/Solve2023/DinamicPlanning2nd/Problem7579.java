package BaekJoon.Solve2023.DinamicPlanning2nd;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7579 {
    int appCnt;
    final int maxMemory = 10000;
    App[] appArr;
    int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        appCnt = Integer.parseInt(st.nextToken());
        int needMemory = Integer.parseInt(st.nextToken());

        appArr = new App[appCnt + 1];

        dp = new int[appCnt + 1][maxMemory + 1];

        st = new StringTokenizer(br.readLine());
        StringTokenizer stt = new StringTokenizer(br.readLine());
        appArr[0] = new App(0, 0);
        for (int i = 1; i <= appCnt; i++) {
            appArr[i] = new App(Integer.parseInt(st.nextToken()), Integer.parseInt(stt.nextToken()));
        }

        Arrays.sort(appArr);

        for (int i = 0, result = 0, iLimit = maxMemory + 1; i < iLimit; i++) {
            result = dping(appCnt, i);
            if (result >= needMemory) {
                bw.write(Integer.toString(i));
                break;
            }
        }

        br.close();
        bw.close();
    }

    private int dping(int idx, int cost) {
        if (idx < 0 || cost < 0) {
            return 0;
        }

        if (dp[idx][cost] > 0) {
            return dp[idx][cost];
        }

        if (appArr[idx].getDisabledCost() > cost) {
            dp[idx][cost] = dping(idx - 1, cost);
        } else {
            dp[idx][cost] = Math.max(dping(idx - 1, cost), appArr[idx].getMemory() + dping(idx - 1, cost - appArr[idx].getDisabledCost()));
        }

        return dp[idx][cost];
    }
}

class App implements Comparable<App> {
    private int memory;
    private int disabledCost;
    public App(int mem, int cost) {
        this.memory = mem;
        this.disabledCost = cost;
    }
    public int getMemory() {
        return this.memory;
    }
    public int getDisabledCost() {
        return this.disabledCost;
    }

    @Override
    public int compareTo(App other) {
        return this.memory - other.getMemory() == 0 ? this.disabledCost - other.getDisabledCost() : this.memory - other.getMemory();
    }
}