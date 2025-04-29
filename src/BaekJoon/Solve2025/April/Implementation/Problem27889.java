package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem27889 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> school = new HashMap<String, String>();
        school.put("NLCS", "North London Collegiate School");
        school.put("BHA", "Branksome Hall Asia");
        school.put("KIS", "Korea International School");
        school.put("SJA", "St. Johnsbury Academy");

        String src = br.readLine();

        System.out.print(school.get(src));

        br.close();
    }
}
