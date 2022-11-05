package BaekJoon.BasicMath_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10757 {
	public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        br.close();
        
        String a = st.nextToken();
        String b = st.nextToken();
        
        StringBuilder sb = new StringBuilder(a);
        a = sb.reverse().toString();
        sb = new StringBuilder(b);
        b = sb.reverse().toString();
        sb = new StringBuilder();
        
        
    	for(int i = 0, upper = 0; i < (a.length() > b.length() ? a.length() : b.length()) || upper > 0; i++) {
            int aVal = i >= a.length() ? 0 : Integer.parseInt(a.substring(i, i+1));
            int bVal = i >= b.length() ? 0 : Integer.parseInt(b.substring(i, i+1));
            
            int tmp = aVal + bVal;
            
            if (upper == 1) {
                tmp += 1;
                upper = 0;
            }
            
            if (tmp > 9) {
                upper = 1;
                tmp -= 10;
            }
            
            sb.insert(0, Integer.toString(tmp));
        }
        
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
	}
}
