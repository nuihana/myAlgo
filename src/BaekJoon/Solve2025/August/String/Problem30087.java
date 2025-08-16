package BaekJoon.Solve2025.August.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem30087 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> classes = new HashMap<>();
        classes.put("Algorithm", "204");
        classes.put("DataAnalysis", "207");
        classes.put("ArtificialIntelligence", "302");
        classes.put("CyberSecurity", "B101");
        classes.put("Network", "303");
        classes.put("Startup", "501");
        classes.put("TestStrategy", "105");

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String className = br.readLine();
            sb.append(classes.get(className)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
