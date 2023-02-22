package BaekJoon.Solve2022.BasicMath_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1712 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		br.close();
		
		int base = Integer.parseInt(st.nextToken());
		int cost = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		
		st = null;
		
		if (cost > price) {
			bw.write("-1");
		} else if (cost == price && base > 0) {
			bw.write("-1");
		} else {
			int value = price - cost;
			bw.write(Integer.toString(base / value + 1));
		}
		bw.flush();
		
		bw.close();
	}
}
