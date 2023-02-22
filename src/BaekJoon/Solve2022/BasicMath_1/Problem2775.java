package BaekJoon.Solve2022.BasicMath_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2775 {
    private int[][] buffer = new int[15][15];
    
	public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int inputCnt = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < inputCnt; i++) {
            bw.write(Integer.toString(recursiveFactorio(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()))));
            bw.write("\n");
        }
        
        bw.flush();
        
        br.close();
        bw.close();
	}
    
    private int recursiveFactorio(int depth, int num) {
        if (depth == 0) {
            return num;
        }
        
        if (buffer[depth][num] != 0) {
            return buffer[depth][num];
        }
        
        int result = 0;
        
        for (int i = 1; i <= num; i++) {
            result += recursiveFactorio(depth - 1, i);
        }
        
        if (buffer[depth][num] == 0) {
            buffer[depth][num] = result;
        }
        
        return result;
    }
}
