package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3003 {
	public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int[] answer = {1, 1, 2, 2, 2, 8};
        int[] req = new int[6];
        
        int idx = 0;
        while(st.hasMoreTokens()) {
            req[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
        
        idx = 0;
        for (int tmp : answer) {
            answer[idx] = answer[idx] - req[idx];
            idx++;
        }
        
        for (int tmp : answer) {
            System.out.print(tmp + " ");
        }
	}
}