package BaekJoon.Solve2024.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem1076 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> head = new HashMap<>();
        head.put("black", 0);
        head.put("brown", 1);
        head.put("red", 2);
        head.put("orange", 3);
        head.put("yellow", 4);
        head.put("green", 5);
        head.put("blue", 6);
        head.put("violet", 7);
        head.put("grey", 8);
        head.put("white", 9);

        Map<String, Integer> tail = new HashMap<>();
        tail.put("black", 1);
        tail.put("brown", 10);
        tail.put("red", 100);
        tail.put("orange", 1000);
        tail.put("yellow", 10000);
        tail.put("green", 100000);
        tail.put("blue", 1000000);
        tail.put("violet", 10000000);
        tail.put("grey", 100000000);
        tail.put("white", 1000000000);

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        System.out.print((head.get(first) * 10 + head.get(second)) * tail.get(third));

        br.close();
    }
}
