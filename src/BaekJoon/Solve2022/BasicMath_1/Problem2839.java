package BaekJoon.Solve2022.BasicMath_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2839 {
	public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        
        br.close();
        
        int result = -1;
        
        for (int fiveDiv = input / 5; fiveDiv >= 0; fiveDiv--) {
            int tmp = input - fiveDiv * 5;
            if (tmp % 3 == 0) {
                result = fiveDiv + tmp / 3;
                fiveDiv = -1;
            }
        }
        
        bw.write(Integer.toString(result));
        
        bw.flush();
        bw.close();
	}
}
