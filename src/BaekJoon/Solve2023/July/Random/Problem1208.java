package BaekJoon.Solve2023.July.Random;

import java.io.*;
import java.util.*;

public class Problem1208 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] arr = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int half = cnt / 2;
        int[] left = Arrays.copyOfRange(arr, 0, half);
        int[] right = Arrays.copyOfRange(arr, half, cnt);

        Map<Integer, Integer> leftMap = getSumMap(left);
        Map<Integer, Integer> rightMap = getSumMap(right);

        long res = 0;
        for (int k : leftMap.keySet()) {
            if (rightMap.containsKey(num - k)) {
                res += (long) leftMap.get(k) * rightMap.get(num - k);
            }
        }

        if (num == 0) res--;
        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private Map<Integer, Integer> getSumMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        dfs(map, arr, 0, 0);

        return map;
    }

    private void dfs(Map<Integer, Integer> map, int[] arr, int sum, int idx) {
        if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
        else map.put(sum, 1);

        for (int i = idx; i < arr.length; i++) {
            dfs(map, arr, sum + arr[i], i + 1);
        }
    }
}
