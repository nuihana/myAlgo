package BaekJoon.Solve2022.BasicMath_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2869 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		br.close();
		
		int climb = Integer.parseInt(st.nextToken());
		int fall = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		st = null;
		
		bw.write(Integer.toString((int)Math.ceil((double)(height - climb) / (climb - fall)) + 1));
		bw.flush();
		
		bw.close();
	}
}
