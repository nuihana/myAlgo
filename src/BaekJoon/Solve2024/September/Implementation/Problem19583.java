package BaekJoon.Solve2024.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem19583 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String start = st.nextToken();
        String end = st.nextToken();
        String stEnd = st.nextToken();

        Set<String> chked = new HashSet<>();
        Set<String> res = new HashSet<>();
        while (true) {
            String chat = br.readLine();

            if (chat == null || chat.equals("")) {
                break;
            }

            st = new StringTokenizer(chat);
            String time = st.nextToken();
            String name = st.nextToken();

            if (isBefore(time, start)) {
                chked.add(name);
            } else if (isAfter(time, end) && chked.contains(name) && isBefore(time, stEnd)) {
                res.add(name);
            }
        }

        System.out.print(res.size());

        br.close();
    }

    private boolean isBefore(String src, String cpr) {
        int sHour = Integer.parseInt(src.substring(0, 2));
        int cHour = Integer.parseInt(cpr.substring(0, 2));

        if (sHour < cHour) return true;
        if (sHour > cHour) return false;

        int sMinute = Integer.parseInt(src.substring(3, 5));
        int cMinute = Integer.parseInt(cpr.substring(3, 5));
        if (sMinute <= cMinute) return true;
        return false;
    }

    private boolean isAfter(String src, String cpr) {
        int sHour = Integer.parseInt(src.substring(0, 2));
        int cHour = Integer.parseInt(cpr.substring(0, 2));

        if (sHour > cHour) return true;
        if (sHour < cHour) return false;

        int sMinute = Integer.parseInt(src.substring(3, 5));
        int cMinute = Integer.parseInt(cpr.substring(3, 5));
        if (sMinute >= cMinute) return true;
        return false;
    }
}
