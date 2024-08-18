package BaekJoon.Solve2024.August.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1235 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ids.add(br.readLine());
        }

        int len = 1;
        while (!isPossibleLen(ids, len)) {
            len++;
        }

        System.out.print(len);

        br.close();
    }

    private boolean isPossibleLen(List<String> ids, int len) {
        Set<String> newIds = new HashSet<>();
        for (String id : ids) {
            newIds.add(id.substring(id.length() - len));
        }

        return newIds.size() == ids.size();
    }
}
