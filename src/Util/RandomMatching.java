package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RandomMatching {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<char[]> list = new ArrayList<>();
        Map<String, String> deckMap = new HashMap<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String src = st.nextToken();
            if (src.length() < 2) break;

            String name = st.nextToken();

            char[] mem = new char[]{ src.charAt(0), src.charAt(1) };
            list.add(mem);
            deckMap.put(src, name);
        }

        boolean[] isUsed = new boolean[list.size()];
        StringBuilder sb = new StringBuilder();
        while (isAllFilled(isUsed)) {
            int a = (int) Math.floor(Math.random() * list.size());
            while (isUsed[a]) a = (int) Math.floor(Math.random() * list.size());
            isUsed[a] = true;
            sb.append(list.get(a)[0]).append(list.get(a)[1]);

            String aDeck = "" + list.get(a)[0] + list.get(a)[1];
            sb.append("[").append(deckMap.get(aDeck)).append("]").append(" vs ");

            if (!isAllFilled(isUsed)) break;

            int b = (int) Math.floor(Math.random() * list.size());
            while (isUsed[b] || list.get(a)[0] == list.get(b)[0]) {
                b = (int) Math.floor(Math.random() * list.size());
            }
            isUsed[b] = true;
            sb.append(list.get(b)[0]).append(list.get(b)[1]);

            String bDeck = "" + list.get(b)[0] + list.get(b)[1];
            sb.append("[").append(deckMap.get(bDeck)).append("]").append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private boolean isAllFilled(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) return true;
        }
        return false;
    }
}
