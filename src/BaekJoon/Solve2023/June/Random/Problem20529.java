package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem20529 {
    Map<String, Map<String, Integer>> dif;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        dif = new HashMap<>();
        for (int i = 0; i < caseCnt; i++) {
            int cnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Map<String, Integer> mbtiMap = new HashMap<>();
            for (int j = 0; j < cnt; j++) {
                String mbti = st.nextToken();

                if (!mbtiMap.containsKey(mbti))
                    mbtiMap.put(mbti, 0);

                mbtiMap.put(mbti, mbtiMap.get(mbti) + 1);
            }

            int res = Integer.MAX_VALUE;
            for(String a : mbtiMap.keySet()) {
                if (mbtiMap.get(a) >= 3) {
                    res = 0;
                    break;
                } else if (mbtiMap.get(a) == 2) {
                    for (String b : mbtiMap.keySet()) {
                        if (a.equals(b)) continue;

                        res = Math.min(res, getDif(a, b) * 2);
                    }
                } else if (mbtiMap.get(a) == 1) {
                    for (String b : mbtiMap.keySet()) {
                        if (a.equals(b)) continue;

                        for (String c : mbtiMap.keySet()) {
                            if (a.equals(c) || b.equals(c)) continue;

                            res = Math.min(res, getDif(a, b) + getDif(b, c) + getDif(a, c));
                        }
                    }
                }
            }

            bw.write(String.valueOf(res));
        }

        br.close();
        bw.close();
    }

    private int getDif(String a, String b) {
        if (dif.containsKey(a)) {
            if (dif.get(a).containsKey(b)) {
                return dif.get(a).get(b);
            }
        }

        int res = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                res++;
        }

        if (!dif.containsKey(a))
            dif.put(a, new HashMap<>());
        if (!dif.containsKey(b))
            dif.put(b, new HashMap<>());

        dif.get(a).put(b, res);
        dif.get(b).put(a, res);

        return res;
    }
}
