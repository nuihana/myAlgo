package BaekJoon.IO_ArithmeticOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10926 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder(bf.readLine());
		
		bf.close();
		
		sb.append("??!");
		
		System.out.print(sb.toString());
	}
}
