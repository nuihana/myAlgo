package BaekJoon.BasicMath_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Problem11653 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		br.close();
		
		for (int i = 2; i < num; i++) {
			boolean flag = true;
			
			while(flag) {
				if (num % i == 0) {
					num /= i;
					bw.write(Integer.toString(i) + "\n");
				} else {
					flag = false;
				}
			}
		}
		
		if (num > 1) {
			bw.write(Integer.toString(num));
		}
		
		bw.close();
	}
}
