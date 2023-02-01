package BaekJoon.GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1541 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String val = br.readLine();

        String[] minusSplit = val.split("-");
        int result = 0;

        if(minusSplit[0].indexOf("+") > -1) {
            String[] tmpArr = minusSplit[0].split("[+]");
            for (String tmp : tmpArr) {
                result += Integer.parseInt(tmp);
            }
        } else {
            result += Integer.parseInt(minusSplit[0]);
        }

        for (int i = 1; i < minusSplit.length; i++) {
            if(minusSplit[i].indexOf("+") > -1) {
                String[] tmpArr = minusSplit[i].split("[+]");
                for (String tmp : tmpArr) {
                    result -= Integer.parseInt(tmp);
                }
            } else {
                result -= Integer.parseInt(minusSplit[i]);
            }
        }

        System.out.print(result);

        br.close();
    }
}
